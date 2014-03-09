/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.projet.controler;

import java.lang.reflect.Member;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import tn.esprit.projet.dao.MembreDao;
import tn.esprit.projet.model.Membre;

/**
 * FXML Controller class
 *
 * @author oukhay
 */
public class ModifierProfilController implements Initializable {
    
    @FXML
    private Font x1;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfusername;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfoldpass;
    @FXML
    private TextField tfnewpass;
    Membre membre = new Membre();
    
    MembreDao memdao = new MembreDao();
    @FXML
    private Label lbpopup;
    @FXML
    private Font x2;
    @FXML
    private Label lbverif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tfnom.setText(loginController.membre.getNom());
        tfusername.setText(loginController.membre.getUsername());
        tfemail.setText(loginController.membre.getEmail());
        // TODO
    }
    
    @FXML
    private void effacer(ActionEvent event) { //effcer les champs
        tfemail.setText("");
        tfnewpass.setText("");
        tfnom.setText("");
        tfoldpass.setText("");
        tfusername.setText("");
      lbpopup.setVisible(false);
        lbverif.setVisible(false);
        
    }
    
    @FXML
    private void afficherTf(ActionEvent event) {//Affichage de Textfiel pour changer le mot de passe
        if (tfoldpass.isVisible() && tfnewpass.isVisible()) {
            
            tfoldpass.setVisible(false);
            tfnewpass.setVisible(false);
            tfoldpass.setText("");
            tfnewpass.setText("");
            lbpopup.setVisible(false);
        } else {
            tfoldpass.setVisible(true);
            tfnewpass.setVisible(true);
        }
      
    }
    
    @FXML
    private void ModifierProfil(ActionEvent event) {
        boolean verif = true;
        
        if (!tfnom.getText().isEmpty() && !tfemail.getText().isEmpty() && !tfusername.getText().isEmpty()) {
            loginController.membre.setNom(tfnom.getText());
            loginController.membre.setUsername(tfusername.getText());
            loginController.membre.setEmail(tfemail.getText());            
        } else {
            System.out.println("hellow");
            lbverif.setVisible(true);
            lbverif.setStyle("-fx-text-fill:red;");
            lbverif.setText("Field could not be empty !");
            verif = false;
        }
        if (tfoldpass.isVisible()) {//chekck if the textfield is visible
            if (tfoldpass.getText().equals(loginController.membre.getPassword())) {
                loginController.membre.setPassword(tfnewpass.getText());
                
            } else {
                lbpopup.setVisible(true);
                lbpopup.setStyle("-fx-text-fill:red;");
                lbpopup.setText("Password is incorrect");
                verif = false;
            }
            
        }        
        if (verif) {
            memdao.updateMembre(loginController.membre);
            lbpopup.setVisible(true);
            lbpopup.setStyle("-fx-text-fill:green;");
            lbpopup.setText("your account has been successfully updated");
        }
        
    }
    
    public void setinvisible() {
        if (tfnom.isFocused() || tfemail.isFocused() || tfusername.isFocused()) {
            if (lbverif.isVisible()) {
                lbverif.setVisible(false);
                
            }
        }
        
    }
    
    @FXML
    private void setinvisiblelb(MouseEvent event) {
        setinvisible();
    }
    
}
