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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import tn.esprit.projet.dao.CommonDAO;
import tn.esprit.projet.dao.MembreDao;
import tn.esprit.projet.main.MainApp;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author Jawher
 */
public class loginController implements Initializable,ControlledScreen {
    MembreDao cdao = new MembreDao();
    ScreensController screencontroller;
    @FXML
    private Button btn;
    @FXML
    private TextField tfuser;
    @FXML
    private PasswordField tfpassword;
    @FXML
    private Label verif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void processLogin(ActionEvent event) {
        
        if (cdao.authentification(tfuser.getText(), tfpassword.getText())==2) {
            screencontroller.setScreen(MainApp.screen3ID);
        }
        else 
        if (cdao.authentification(tfuser.getText(), tfpassword.getText())==0) 
                
           
          verif.setText("Username or password is incorrect !!!!");   
        
          
    }

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        screencontroller=screenpage;
    }
    
    
}
