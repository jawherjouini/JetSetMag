/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.controler;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.ReflectionBuilder;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;
import static tn.esprit.projet.controler.FilmController.r;
import tn.esprit.projet.dao.Media_Par_ElementDao;
import tn.esprit.projet.main.MainApp;
import tn.esprit.projet.model.Media;
import tn.esprit.projet.model.Media_Par_Element;
import tn.esprit.projet.model.Projection;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author tasnim
 */
public class InterfacedesProjectionsController implements Initializable,ControlledScreen    {
@FXML
    private static AnchorPane anchP;
    @FXML
    private static WebView webview;
    @FXML
    private static Label lblNom;
    @FXML
    private Font x1;
    @FXML
    private static ImageView imgview;
    @FXML
    private static  Label lblDesc;
    @FXML
    private Color x2;
    @FXML
    private static Label lblDateH;
    
    static ScreensController screencontroller;
    @FXML
    private static VBox MyVbox;
    static  final  double WIDTH = 700, HEIGHT= 505;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init();
    }    
     static Media_Par_ElementDao media_Par_ElementDao = new Media_Par_ElementDao();

     private void init() {
         
         List<Image> images = new ArrayList<Image>();
         List<String> malist = new ArrayList<String>();
         ObservableList<Media_Par_Element>   listmedia = media_Par_ElementDao.read();
         for (Media_Par_Element media_Par_Element : listmedia) {
             Media media = new Media();
             Projection projection = new Projection();
             projection=media_Par_Element.getProjection();
             //System.out.println(media_Par_Element);
             if (projection!=null) {
                   //System.out.println(media_Par_Element.getProjection()+" "+media_Par_Element.getMedia().getURL());
                 media=media_Par_Element.getMedia();
                 malist.add(media.getURL());
               //  System.out.println("hhhhhhhh  "+media_Par_Element.getMedia().getURL());
             } 
         }     
         for (int j = 0; j < malist.size(); j++) {
             String string = malist.get(j);
             if (malist.get(j).contains("http")) {
                  images.add(new Image(string.trim() ,false));
             }
//             }else {
//                  File file = new File(string.trim());
//                  images.add( new Image(file.toURI().toString()));               
//                // images.add(new Image("file://"+string.trim() ,false));
//             }
        }
        Shelf displayShelf = new Shelf(images);       
        MyVbox.setStyle("-fx-background-color: linear-gradient(to bottom," +
                    " black 60, #141414 60.1%, black 100%);");
        displayShelf.setPrefSize(WIDTH, HEIGHT);
        MyVbox.getChildren().add(displayShelf);
    }
  
    public void SetScreenParent(ScreensController screenpage) {
        screencontroller=screenpage;
    }

    public static class Shelf extends Region {
        private static final Duration DURATION = Duration.millis(500);
        private static final Interpolator INTERPOLATOR = Interpolator.EASE_BOTH;
        private static final double SPACING = 50;
        private static final double LEFT_OFFSET = -110;
        private static final double RIGHT_OFFSET = 110;
        private static final double SCALE_SMALL = 0.7;
        private PerspectiveImage[] items;
        private Group centered = new Group();
        private Group left = new Group();
        private Group center = new Group();
        private Group right = new Group();
        private int centerIndex = 0;
        private Timeline timeline;
        private ScrollBar scrollBar = new ScrollBar();
        private boolean localChange = false;
        private Rectangle clip = new Rectangle();

        public Shelf(List<Image> images) {
            setClip(clip);
            scrollBar.setStyle("-fx-base: #202020; -fx-background: #202020;");
            items = new PerspectiveImage[images.size()];
           
            for (int i=0; i<images.size(); i++) {
                final PerspectiveImage item =
                        items[i] = new PerspectiveImage(images.get(i));
                        
                final double index = i;
                item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent me) {  
                        //System.out.println((int)scrollBar.getValue());

                        localChange = true;
                        scrollBar.setValue(index);
                        System.out.println((int)scrollBar.getValue());
                         ObservableList<Media_Par_Element>  listmedia = media_Par_ElementDao.read();
                         List<String> malist = new ArrayList<String>();
                         System.out.println("aaaaaaaaaaaaaaaaa");
                         for (Media_Par_Element media_Par_Element : listmedia) {
                            Media media = new Media();
                            Projection projection = new Projection();
                            projection=media_Par_Element.getProjection();
                                if (projection!=null) {
                                    media=media_Par_Element.getMedia();
                                    malist.add(media.getURL());
                                } 
                        } 
                         
                        Image image=null;
                            if (malist.get((int)scrollBar.getValue()).contains("http")) {
                                 image = new Image(malist.get((int)scrollBar.getValue()),false);
                                 System.out.println(malist.get((int)scrollBar.getValue()));
                            }
//                            else {
//                                 File file = new File(malist.get((int)scrollBar.getValue()));
//                                 image= new Image(file.toURI().toString());               
//                               // images.add(new Image("file://"+string.trim() ,false));
//                            
//                       }
                        lblNom.setText(listmedia.get((int)scrollBar.getValue()).getFilm().getTitre());
                        lblDesc.setText(listmedia.get((int)scrollBar.getValue()).getFilm().getSynopsis());
                        lblDateH.setText(listmedia.get((int)scrollBar.getValue()).getProjection().getDate_Projection());
                        imgview= new ImageView(image);
                        //imgview = new ImageView();
                        anchP.setVisible(true);
                        MyVbox.setVisible(false);
                        localChange = false;
                        shiftToCenter(item);
                    }
                });
            }         
            scrollBar.setMax(items.length-1);
            scrollBar.setVisibleAmount(1);
            scrollBar.setUnitIncrement(1);
            scrollBar.setBlockIncrement(1);
            scrollBar.valueProperty().addListener(new InvalidationListener() {
                public void invalidated(Observable ov) {
                    if(!localChange)
                        shiftToCenter(items[(int)scrollBar.getValue()]);
                }
            });
            centered.getChildren().addAll(left, right, center);
            getChildren().addAll(centered,scrollBar);
            setFocusTraversable(true);
            setOnKeyPressed(new EventHandler<KeyEvent>() {
                public void handle(KeyEvent ke) {
                    if (ke.getCode() == KeyCode.LEFT) {
                        shift(1);
                        localChange = true;
                        scrollBar.setValue(centerIndex);
                       // System.out.println("aavvvvvaaa");
                        localChange = false;
                    } else if (ke.getCode() == KeyCode.RIGHT) {
                        shift(-1);
                        localChange = true;
                      //  System.out.println("aaaannnnnnnaaa");
                        scrollBar.setValue(centerIndex);
                        localChange = false;
                    }
                }
            });
            update();
        }
        @Override protected void layoutChildren() {
            // update clip to our size
            clip.setWidth(getWidth());
            clip.setHeight(getHeight());
            // keep centered centered
            centered.setLayoutY((getHeight() - PerspectiveImage.HEIGHT) / 2);
            centered.setLayoutX((getWidth() - PerspectiveImage.WIDTH) / 2);
            // position scroll bar at bottom
            scrollBar.setLayoutX(10);
            scrollBar.setLayoutY(getHeight()-25);
            scrollBar.resize(getWidth()-20,15);
        }

        private void update() {
            // move items to new homes in groups
            left.getChildren().clear();
            center.getChildren().clear();
            right.getChildren().clear();
            for (int i = 0; i < centerIndex; i++) {
                left.getChildren().add(items[i]);
            }
            center.getChildren().add(items[centerIndex]);
            for (int i = items.length - 1; i > centerIndex; i--) {
                right.getChildren().add(items[i]);
            }
            // stop old timeline if there is one running
            if (timeline!=null) timeline.stop();
            // create timeline to animate to new positions
            timeline = new Timeline();
            // add keyframes for left items
            final ObservableList<KeyFrame> keyFrames = timeline.getKeyFrames();
            for (int i = 0; i < left.getChildren().size(); i++) {
                final PerspectiveImage it = items[i];
                double newX = -left.getChildren().size() *
                        SPACING + SPACING * i + LEFT_OFFSET;
                keyFrames.add(new KeyFrame(DURATION,
                    new KeyValue(it.translateXProperty(), newX, INTERPOLATOR),
                    new KeyValue(it.scaleXProperty(), SCALE_SMALL, INTERPOLATOR),
                    new KeyValue(it.scaleYProperty(), SCALE_SMALL, INTERPOLATOR),
                    new KeyValue(it.angle, 45.0, INTERPOLATOR)));
            }
            // add keyframe for center item
            final PerspectiveImage centerItem = items[centerIndex];
            keyFrames.add(new KeyFrame(DURATION,
                    new KeyValue(centerItem.translateXProperty(), 0, INTERPOLATOR),
                    new KeyValue(centerItem.scaleXProperty(), 1.0, INTERPOLATOR),
                    new KeyValue(centerItem.scaleYProperty(), 1.0, INTERPOLATOR),
                    new KeyValue(centerItem.angle, 90.0, INTERPOLATOR)));
            // add keyframes for right items
            for (int i = 0; i < right.getChildren().size(); i++) {
                final PerspectiveImage it = items[items.length - i - 1];
                final double newX = right.getChildren().size() *
                        SPACING - SPACING * i + RIGHT_OFFSET;
                keyFrames.add(new KeyFrame(DURATION,
                        new KeyValue(it.translateXProperty(), newX, INTERPOLATOR),
                        new KeyValue(it.scaleXProperty(), SCALE_SMALL, INTERPOLATOR),
                        new KeyValue(it.scaleYProperty(), SCALE_SMALL, INTERPOLATOR),
                        new KeyValue(it.angle, 135.0, INTERPOLATOR)));
            }
            // play animation
            timeline.play();
        }

        private void shiftToCenter(PerspectiveImage item) {
            for (int i = 0; i < left.getChildren().size(); i++) {
                if (left.getChildren().get(i) == item) {
                    int shiftAmount = left.getChildren().size() - i;
                    shift(shiftAmount);
                    return;
                }
            }
            if (center.getChildren().get(0) == item) {
                return;
            }
            for (int i = 0; i < right.getChildren().size(); i++) {
                if (right.getChildren().get(i) == item) {
                    int shiftAmount = -(right.getChildren().size() - i);
                    shift(shiftAmount);
                    return;
                }
            }
        }

        public void shift(int shiftAmount) {
            if (centerIndex <= 0 && shiftAmount > 0) return;
            if (centerIndex >= items.length - 1 && shiftAmount < 0) return;
            centerIndex -= shiftAmount;
            update();
        }
    }

    /**
     * A Node that displays a image with some 2.5D perspective rotation around the Y axis.
     */
    public static class PerspectiveImage extends Parent {
        private static final double REFLECTION_SIZE = 0.25;
        private static final double WIDTH = 400;
        private static final double HEIGHT = WIDTH + (WIDTH*REFLECTION_SIZE);
        private static final double RADIUS_H = WIDTH / 2;
        private static final double BACK = WIDTH / 10;
        private PerspectiveTransform transform = new PerspectiveTransform();
        /** Angle Property */
        private final DoubleProperty angle = new SimpleDoubleProperty(45) {
            @Override protected void invalidated() {
                // when angle changes calculate new transform
                double lx = (RADIUS_H - Math.sin(Math.toRadians(angle.get())) * RADIUS_H - 1);
                double rx = (RADIUS_H + Math.sin(Math.toRadians(angle.get())) * RADIUS_H + 1);
                double uly = (-Math.cos(Math.toRadians(angle.get())) * BACK);
                double ury = -uly;
                transform.setUlx(lx);
                transform.setUly(uly);
                transform.setUrx(rx);
                transform.setUry(ury);
                transform.setLrx(rx);
                transform.setLry(HEIGHT + uly);
                transform.setLlx(lx);
                transform.setLly(HEIGHT + ury);
            }
        };
        public final double getAngle() { return angle.getValue(); }
        public final void setAngle(double value) { angle.setValue(value); }
        public final DoubleProperty angleModel() { return angle; }

        public PerspectiveImage(Image image) {
            
            ImageView imageView = new ImageView(image);
     
            imageView.setEffect(ReflectionBuilder.create().fraction(REFLECTION_SIZE).build());
            setEffect(transform);
            getChildren().addAll(imageView);
        }
    }    
}
