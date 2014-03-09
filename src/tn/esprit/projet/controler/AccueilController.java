/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.projet.controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import tn.esprit.projet.main.MainApp;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author Jawher
 */
public class AccueilController implements Initializable, ControlledScreen {

    public static int page = 0;

    ScreensController screencontroller;
    @FXML
    private Color x1;
    @FXML
    private Font x2;
    @FXML
    private Button bon;
    @FXML
    private Hyperlink connecter;
    @FXML
    private Font x4;
    @FXML
    private Color x3;
    @FXML
    private ImageView logo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void authentifier(ActionEvent event) {
        screencontroller.setScreen(MainApp.screen2ID);
    }

    @FXML
    private void accueilBoxOffice(ActionEvent event) {
        page = 1;
        MainApp.mainCantainer.loadscreen(MainApp.screen5ID, MainApp.screen5File);
        screencontroller.setScreen(MainApp.screen5ID);
    }

    @FXML
    private void accueilNews(ActionEvent event) {
        page = 2;
        MainApp.mainCantainer.loadscreen(MainApp.screen5ID, MainApp.screen5File);
        screencontroller.setScreen(MainApp.screen5ID);
    }

    @FXML
    private void accueilEvents(ActionEvent event) {
        page = 3;
        MainApp.mainCantainer.loadscreen(MainApp.screen5ID, MainApp.screen5File);
        screencontroller.setScreen(MainApp.screen5ID);
    }

    @FXML
    private void accueilBonsPlans(ActionEvent event) {
        page = 4;
        MainApp.mainCantainer.loadscreen(MainApp.screen5ID, MainApp.screen5File);
        screencontroller.setScreen(MainApp.screen5ID);
    }

    @FXML
    private void inscrire(ActionEvent event) {

        MainApp.mainCantainer.loadscreen(MainApp.screen6ID, MainApp.screen6File);
        screencontroller.setScreen(MainApp.screen6ID);
    }

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        screencontroller = screenpage;
    }

}
