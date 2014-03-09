/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.controler;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import tn.esprit.projet.dao.EvenementDAO;
import tn.esprit.projet.main.MainApp;
import tn.esprit.projet.model.Evenement;

/**
 * FXML Controller class
 *
 * @author oukhay
 */
public class AjoutEvenementController implements Initializable {
    @FXML
    private Font x1;
    @FXML
    private Color x2;
    @FXML
    private Color x3;
    @FXML
    private ComboBox<String> cbtypeEvent;
    ObservableList<String> listevent = FXCollections.observableArrayList();
    @FXML
    private TextField tf_titre;
    @FXML
    private TextField tf_date_deb;
    @FXML
    private TextField tf_date_fin;
    @FXML
    private TextArea ta_description;

    EvenementDAO eventdao = new EvenementDAO();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listevent.add("Type de l'évéènement");
        listevent.add("Soirée");
        listevent.add("Sortie");
        listevent.add("Concert");
        listevent.add("Pièce de théâtre");
        listevent.add("Projection");
        cbtypeEvent.setItems(listevent);
        
        // TODO
  
    }    



    @FXML
    private void effacerTout(ActionEvent event) {
    }

    @FXML
    private void ajouterEvent(ActionEvent event) {
        Evenement evenement = new Evenement();
        evenement.setTitre_event(tf_titre.getText());
        evenement.setDate_deb_event(tf_date_deb.getText());
        evenement.setDate_fin_event(tf_date_fin.getText());
        evenement.setDescription(ta_description.getText());
        evenement.setType_event(cbtypeEvent.getSelectionModel().getSelectedItem());
        evenement.setId_membre(loginController.membre.getId_membre());
        eventdao.ajouterEvenement(evenement);
    }
    
}
