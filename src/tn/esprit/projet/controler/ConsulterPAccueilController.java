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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import tn.esprit.projet.main.MainApp;

/**
 * FXML Controller class
 *
 * @author tasnim
 */
public class ConsulterPAccueilController implements Initializable {
    @FXML
    private Hyperlink boxoffice;
    @FXML
    private Hyperlink projection;
    @FXML
    private Hyperlink film;
    @FXML
    private AnchorPane body;
    @FXML
    private AnchorPane header;
       AnchorPane lLoader;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficherBoxoffice(ActionEvent event) {
        
        loading(MainApp.c_boxofficeFile);
        
    }

    @FXML
    private void afficherProjection(ActionEvent event) {
    }

    @FXML
    private void afficherFilm(ActionEvent event) {
        loading(MainApp.c_regarderfilmFile);
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
