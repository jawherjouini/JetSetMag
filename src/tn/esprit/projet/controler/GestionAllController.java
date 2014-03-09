/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.projet.controler;

import com.sun.org.apache.bcel.internal.generic.LLOAD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import tn.esprit.projet.main.MainApp;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author oukhay
 */
public class GestionAllController implements Initializable, ControlledScreen {

    ScreensController screencontroller;
    @FXML
    private AnchorPane header;
    @FXML
    private AnchorPane body;
     AnchorPane lLoader;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void goToFilm(ActionEvent event) {
       
        loading(MainApp.g_filmFile);
    }

    @FXML
    private void goToNews(ActionEvent event) {
        loading(MainApp.g_newsFile);
    }

    @FXML
    private void goToEvents(ActionEvent event) {
        loading(MainApp.g_evenementFile);
     
    }

    @FXML
    private void goToMembre(ActionEvent event) {
         loading(MainApp.g_membreFile);
    }

    @FXML
    private void goToSalle(ActionEvent event) {
        loading(MainApp.g_sallecinemmaFile);
    }

    @FXML
    private void goToComment(ActionEvent event) {
        loading(MainApp.g_commentaireFile);
    }

    @FXML
    private void goToStatistiques(ActionEvent event) {
        loading(MainApp.g_statistiqueFile);
    }

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        screencontroller = screenpage;
    }
    
      private void loading(String fxml) {
        try {
            body.getChildren().removeAll(lLoader);
            lLoader = FXMLLoader.load(getClass().getResource(fxml));
            body.getChildren().add(lLoader);
        } catch (IOException ex) {
            Logger.getLogger(AccueilClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
