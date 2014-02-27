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
public class AccueilController implements Initializable,ControlledScreen {
    ScreensController screencontroller;
    @FXML
    private Color x1;
    @FXML
    private Font x2;
    @FXML
    private Button bon;
    @FXML
    private Font x4;
    @FXML
    private Hyperlink connecter;
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
    private void bonplan(ActionEvent event) {
    }

    @FXML
    private void authentifier(ActionEvent event) {
        screencontroller.setScreen(MainApp.screen2ID);
    }

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        screencontroller=screenpage;
    }
    
}
