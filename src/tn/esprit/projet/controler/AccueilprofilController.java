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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author oukhay
 */
public class AccueilprofilController implements Initializable {

    @FXML
    private AnchorPane sidebar;
    @FXML
    private AnchorPane body;
    @FXML
    private Font x1;
    private AnchorPane paneProfil;
    AnchorPane loader;
    @FXML
    private Region sideBar;
    @FXML
    private Color x2;
    @FXML
    private Hyperlink hlmonprofil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

    @FXML
    private void consulterProfil(ActionEvent event) {
        body.getChildren().remove(loader);
        try {
            loader = FXMLLoader.load(getClass().getResource("/tn/esprit/projet/view/client/ConsulterProfil.fxml"));

            body.getChildren().add(loader);
        } catch (IOException ex) {
            Logger.getLogger(ConsulterProfilController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void modifierProfil(ActionEvent event) {
        body.getChildren().remove(loader);
        try {
            loader = FXMLLoader.load(getClass().getResource("/tn/esprit/projet/view/client/ModifierProfil.fxml"));

            body.getChildren().add(loader);
        } catch (IOException ex) {
            Logger.getLogger(AccueilprofilController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void effectuerReclamation(ActionEvent event) {
        body.getChildren().remove(loader);
        try {
            loader = FXMLLoader.load(getClass().getResource("/tn/esprit/projet/view/client/Reclamation.fxml"));

            body.getChildren().add(loader);
        } catch (IOException ex) {
            Logger.getLogger(AccueilprofilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ajouterEvenement(ActionEvent event) {
        try {
            body.getChildren().remove(loader);
            loader = FXMLLoader.load(getClass().getResource("/tn/esprit/projet/view/client/AjoutEvenement.fxml"));
            body.getChildren().add(loader);
        } catch (IOException ex) {
            Logger.getLogger(AccueilprofilController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void bigger(MouseEvent event) {
        Font f = new Font(25);

        hlmonprofil.setFont(f);
    }

}
