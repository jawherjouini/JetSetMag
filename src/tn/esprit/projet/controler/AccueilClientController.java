/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.projet.controler;

import com.sun.javafx.scene.control.skin.ButtonSkin;
import java.awt.Graphics;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Skin;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import tn.esprit.projet.main.MainApp;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author oukhay
 */
public class AccueilClientController implements Initializable, ControlledScreen {

    ScreensController screencontroller;
    private Label lb;

    private Text lbinterne;
    private Group gprofil;
    @FXML
    private AnchorPane header;
    private AnchorPane body;
    @FXML
    private Font x2;
    @FXML
    private Text titre;
    @FXML
    private Button btnBoxOffice;
    @FXML
    private Button btnNews;
    @FXML
    private Button btnEvents;
    @FXML
    private Button btnBonPlan;
    @FXML
    private Button btnMonProfil;
    @FXML
    private AnchorPane banner;
    @FXML
    private AnchorPane body1;
    int i = 0;
    AnchorPane lLoader;

    /**
     * Initializes the controller class.
     */
//    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (loginController.membre == null) {
            btnMonProfil.setVisible(false);
        }
        if (AccueilController.page == 1) {
            titre.setText("Box Office");
            changecolor(btnBoxOffice, "white", "black");
//            loading(MainApp.screen11File);
        }
        if (AccueilController.page == 2) {
            titre.setText("News");
            changecolor(btnNews, "white", "black");
            System.out.println("avant");
            loading(MainApp.c_newsFile);
            System.out.println("aprés");
        }
        if (AccueilController.page == 3) {
            titre.setText("Events");
            changecolor(btnEvents, "white", "black");
            loading(MainApp.screen7File);
        }
        if (AccueilController.page == 4) {
            titre.setText("Bons Plans");
            changecolor(btnBonPlan, "white", "black");
        }

        if (AccueilController.page == 5) {
            titre.setText("Mon Profil");
            changecolor(btnMonProfil, "white", "black");
             loading(MainApp.screen9File);

        }

    }

    private void loading(String fxml) {
        try {

            lLoader = FXMLLoader.load(getClass().getResource(fxml));
            body1.getChildren().add(lLoader);
        } catch (IOException ex) {
            Logger.getLogger(AccueilClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        screencontroller = screenpage;
    }

    @FXML
    private void moveToBoxOffice(ActionEvent event) {

        titre.setText("Box Office");

        changecolor(btnBoxOffice, "white", "black");

    }

    @FXML
    private void moveToNews(ActionEvent event) {
        titre.setText("News");
        changecolor(btnNews, "white", "black");
        loading(MainApp.c_newsFile);
    }

    @FXML
    private void moveToEvents(ActionEvent event) {
        titre.setText("Events");
        changecolor(btnEvents, "white", "black");
         loading(MainApp.screen7File);
    }

    @FXML
    private void moveToBonsPlans(ActionEvent event) {
        titre.setText("Bons Plans");
        changecolor(btnBonPlan, "white", "black");
    }

    @FXML
    private void moveToMonProfil(ActionEvent event) {
        titre.setText("Mon Profil");
        changecolor(btnMonProfil, "white", "black");
        loading(MainApp.screen9File);

    }

    private void changecolor(Button btn, String txtColor, String bgColor) {
        btnBonPlan.setStyle("-fx-background-color:white;-fx-text-fill: black;");
        btnBoxOffice.setStyle("-fx-background-color:white;-fx-text-fill: black;");
        btnEvents.setStyle("-fx-background-color:white;-fx-text-fill: black;");
        btnMonProfil.setStyle("-fx-background-color:white;-fx-text-fill: black;");
        btnNews.setStyle("-fx-background-color:white;-fx-text-fill: black;");
        btn.setStyle("-fx-background-color:" + bgColor + " ;-fx-text-fill: " + txtColor + ";");

    }

    @FXML
    private void MoveToHome(MouseEvent event) {
        screencontroller.setScreen(MainApp.screen1ID);
    }

}
