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
import javafx.scene.control.Hyperlink;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficherBoxoffice(ActionEvent event) {
    }

    @FXML
    private void afficherProjection(ActionEvent event) {
    }

    @FXML
    private void afficherFilm(ActionEvent event) {
    }
    
}
