/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.controler;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tn.esprit.projet.dao.EvenementDAO;
import tn.esprit.projet.main.MainApp;
import tn.esprit.projet.model.Evenement;
import tn.esprit.projet.util.FileUpload;

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
        private TextField tf_date_deb;
        private TextField tf_date_fin;
    @FXML
    private TextArea ta_description;

    EvenementDAO eventdao = new EvenementDAO();
    @FXML
    private TextField tf_annee_deb;
    @FXML
    private ComboBox<?> cb_mois_deb;
    @FXML
    private ComboBox<?> cb_jour_deb;
    @FXML
    private TextField tf_heure;
    @FXML
    private Font x4;
    @FXML
    private TextField tf_annee_fin;
    @FXML
    private TextField tf_img;
      File file;
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
         FileUpload fu = new FileUpload();
        try {
            fu.upload("jetsetmag.comze.com","a9331234","Oukhay1991", "MyImage", file);
        } catch (IOException ex) {
            Logger.getLogger(AjoutEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        eventdao.ajouterEvenement(evenement);
    }
        @FXML
    private void choisirImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        configureFileChooserImage(fileChooser);
        fileChooser.setTitle("Open Resource File");
        Stage stage = new Stage();
        file = fileChooser.showOpenDialog(stage);
           
        String image = file.getAbsolutePath();
        tf_img.setText(image);
        System.out.println(file.getAbsolutePath());
    }
     private static void configureFileChooserImage(
            final FileChooser fileChooser) {
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
    }
     public String GetDate(){
        return null;
     }
    
}
