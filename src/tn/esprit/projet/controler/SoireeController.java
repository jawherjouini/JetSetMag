/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.projet.controler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import tn.esprit.projet.dao.EvenementDAO;
import tn.esprit.projet.main.MainApp;
import tn.esprit.projet.model.Evenement;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.MailClass;
import tn.esprit.projet.util.ScreensController;
import static tn.esprit.projet.controler.NewsController.articleSelect;

/**
 * FXML Controller class
 *
 * @author Jawher
 */
public class SoireeController implements Initializable, ControlledScreen {

    EvenementDAO eventDao = new EvenementDAO();
    public static Evenement eventSelect;
    ScreensController screentbal;
    ObservableList<String> list = FXCollections.observableArrayList();
    
    @FXML
    private WebView wv_content;
    @FXML
    private Hyperlink nt_com;
    @FXML
    private Hyperlink invit;
    @FXML
    private ImageView fond_event;
    @FXML
    private Hyperlink h_soirees;
    @FXML
    private Hyperlink h_sorties;
    @FXML
    private Hyperlink h_concerts;
    @FXML
    private Hyperlink h_theatre;
    @FXML
    private ListView<String> ls_events;
    @FXML
    private Label l_events;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        l_events.setText("");
        ls_events.getItems().clear();
    }


    @FXML
    private void afficherEvent(MouseEvent event) {
        String s = ls_events.getSelectionModel().getSelectedItem().substring(38);
        eventSelect = eventDao.ListerEvenementsByTitre(s).get(0);
        articleSelect = null;

        wv_content.getEngine().loadContent("<div style=\"font-family:Verdana, Geneva, sans-serif; background:#FCC;width:610px;height:453px\">\n"
                + "    	<br/><h3 style=\"margin:10px;color:#FFF\">" + eventSelect.getTitre_event() + "</h3><p style=\"margin:10px;float:right;font-size:9px\">Début: " + eventSelect.getDate_deb_event().substring(0, 16) + " - Fin:" + eventSelect.getDate_fin_event().substring(0, 16) + "</p><br/>\n"
                + "        <p style=\"margin:10px;color:#000;font-size:14px\">" + eventSelect.getDescription() + "</p>\n"
                + "    </div>");
    }

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        screentbal = screenpage;
    }

    @FXML
    private void noterCommenter(ActionEvent event) {
        Stage stage = new Stage();
        if (eventSelect != null) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(MainApp.c_notercommenterFile));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(SoireeController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }

    @FXML
    private void InviterAmi(ActionEvent event) {
        if (eventSelect != null) {
            Stage newStage = new Stage();
            VBox comp = new VBox();
            comp.setMaxHeight(300);

            VBox espaceMail = new VBox();
            espaceMail.setMaxHeight(300);
            espaceMail.setSpacing(10);

            HBox hb_user = new HBox();
            Label lb_user = new Label("Votre e-mail: ");
            final TextField tf_user = new TextField();
            hb_user.getChildren().add(lb_user);
            hb_user.getChildren().add(tf_user);
            hb_user.setSpacing(20);
            espaceMail.getChildren().add(hb_user);

            HBox hb_mail = new HBox();
            Label lb_mail = new Label("L'e-mail de votre ami: ");
            final TextField tf_mail = new TextField();
            hb_mail.getChildren().add(lb_mail);
            hb_mail.getChildren().add(tf_mail);
            hb_mail.setSpacing(20);
            espaceMail.getChildren().add(hb_mail);

            HBox hb_comm = new HBox();
            Label lb_comm = new Label("Message: ");
            final TextArea ta_comm = new TextArea();
            tf_user.addEventHandler(EventType.ROOT, new EventHandler<Event>() {

                @Override
                public void handle(Event t) {
                    ta_comm.setText(" Salut! je suis " + tf_user.getText()
                            + " et je t'invite à venir avec moi à cet evènement:\n"
                            + eventSelect.getTitre_event() + " organisé le "
                            + eventSelect.getDate_deb_event() + " jusqu'au "
                            + eventSelect.getDate_fin_event() + "\n"
                            + eventSelect.getDescription());
                }
            });
            ta_comm.setEditable(false);
            ta_comm.setMaxSize(300, 100);
            hb_comm.getChildren().add(lb_comm);
            hb_comm.getChildren().add(ta_comm);
            hb_comm.setSpacing(20);
            espaceMail.getChildren().add(hb_comm);

            Button btn_comm = new Button("Envoyer");
            btn_comm.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    MailClass class1 = new MailClass();
                    class1.Setmail("[JetSetMag] Invitation à un évènement ", ta_comm.getText());
                    try {
                        class1.SendMyMail(tf_user.getText(), tf_mail.getText(), tf_user.getText(), tf_mail.getText());
                    } catch (Exception ex) {
                        System.out.println("erreur: " + ex.getMessage());
                    }
                    System.out.println(eventSelect + " bouton");
                }
            });
            espaceMail.getChildren().add(btn_comm);

            comp.getChildren().add(espaceMail);
            comp.setSpacing(20);

            Scene stageScene = new Scene(comp, 400, 300);
            newStage.setScene(stageScene);
            newStage.show();
        }
    }

    @FXML
    private void chargerSoirees(ActionEvent event) {
        
        l_events.setText("Les soirées prévues");
        ls_events.getItems().clear();
        for (Evenement e : eventDao.ListerEvenementsByType("Soirée")) {
            list.add(e.getDate_deb_event().substring(0, 16) + " | " + e.getDate_fin_event().substring(0, 16) + " | " + e.getTitre_event());
        }
        ls_events.setItems(list);
    }

    @FXML
    private void chargerSorties(ActionEvent event) {
        
        l_events.setText("Les prochaines sorties");
        ls_events.getItems().clear();
        for (Evenement e : eventDao.ListerEvenementsByType("Sortie")) {
            list.add(e.getDate_deb_event().substring(0, 16) + " | " + e.getDate_fin_event().substring(0, 16) + " | " + e.getTitre_event());
        }
        ls_events.setItems(list);
    }

    @FXML
    private void chargerConcerts(ActionEvent event) {
        
        l_events.setText("Les concerts de musique à venir");
        ls_events.getItems().clear();
        for (Evenement e : eventDao.ListerEvenementsByType("Concert")) {
            list.add(e.getDate_deb_event().substring(0, 16) + " | " + e.getDate_fin_event().substring(0, 16) + " | " + e.getTitre_event());
        }
        ls_events.setItems(list);
    }

    @FXML
    private void chargerTheatre(ActionEvent event) {
        
        l_events.setText("Les pièces de théatre à jouer");
        ls_events.getItems().clear();
        for (Evenement e : eventDao.ListerEvenementsByType("Pièce de théâtre")) {
            list.add(e.getDate_deb_event().substring(0, 16) + " | " + e.getDate_fin_event().substring(0, 16) + " | " + e.getTitre_event());
        }
        ls_events.setItems(list);
    }

}
