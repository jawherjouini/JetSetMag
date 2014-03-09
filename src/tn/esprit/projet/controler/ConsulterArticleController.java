/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author oukhay
 */
public class ConsulterArticleController implements Initializable, ControlledScreen {
    ScreensController sc;
    @FXML
    private VBox vbarticles;
    @FXML
    private HBox hbarticle;
    private HBox hbarticle1 = new HBox();
    
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     vbarticles.getChildren().add(createArticle("ttttt", "tttttt"));
       // System.out.println(((HBox)vbarticles.getChildren().get(1)).getChildren().get(0).toString());

    }    
    public HBox createArticle(String titre , String text){
        HBox hb = new HBox();
        hb.setMinWidth(1200);
        hb.setMinHeight(206);
        ImageView img = new ImageView();
      //  img
        img.setFitWidth(274);
        img.setFitHeight(206);
        VBox vb = new VBox();
        vb.setMinWidth(926);
        vb.setMinHeight(206);
        Label lb_titre = new Label("Title of the article");
        Label lb_text = new Label("Body of the article");
        HBox hbcom = new HBox();
        hbcom.setMinWidth(926);
        hbcom.setMinHeight(32);
        hbcom.setAlignment(Pos.BOTTOM_CENTER);
        hbcom.setSpacing(10);
        TextArea ta_com = new TextArea();
        ta_com.setMinWidth(800);
        ta_com.setMinHeight(32);
        ta_com.setMaxHeight(32);
        //hbcom.set
        Button btn_com = new Button("Commenter");
        
        btn_com.setMinWidth(111);
        btn_com.setMinHeight(32);
        hbcom.getChildren().add(ta_com);
        hbcom.getChildren().add(btn_com);
        vb.getChildren().add(lb_titre);
        vb.getChildren().add(lb_text);
        vb.getChildren().add(hbcom);
        hb.getChildren().add(img);
        hb.getChildren().add(vb);
        return hb;
        
    }

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        sc=screenpage;
    }
    
}
