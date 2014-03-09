/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.controler;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javax.mail.MessagingException;
import tn.esprit.projet.util.MailClass;

/**
 * FXML Controller class
 *
 * @author oukhay
 */
public class ReclamationController implements Initializable {
    
    @FXML
    private Font x1;
    @FXML
    private TextField tfsujet;
    @FXML
    private TextArea tfmessage;
    @FXML
    private Label lbsent;
       private ProgressIndicator progress;
        private ImageView imgload;
    @FXML
    private Region rg;
    @FXML
    private AnchorPane ap;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendMail(ActionEvent event) {
         
          try {
            MailClass class1 = new MailClass();
            class1.Setmail(tfsujet.getText(), tfmessage.getText());
         class1.SendMyMail("gamtestej.nimda@gmail.com","espritjetset@gmail.com",loginController.membre.getNom()+" ID :"+loginController.membre.getId_membre(),"Administrateur");
        
          } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
            
//              imgload.setVisible(false);
           lbsent.setText("Sent message successfully....");
        
      

        
    }

    @FXML
    private void effacer(ActionEvent event) {
        tfmessage.setText("");
        tfsujet.setText("");
        lbsent.setText("");
       
    }

//    @Override
////    public void run() {
////        Image image =new  Image("/tn/esprit/projet/media/loading.gif");
////        ImageView imgload1 = new ImageView(image);
////        imgload1.setLayoutX(370);
////        imgload1.setLayoutY(309);
////        imgload1.setY(0);
////        imgload1.setX(0);
////        imgload1.setFitHeight(30);
////        imgload1.setFitWidth(30);
////        ap.getChildren().add(imgload1);
////
////    }

   
    
}
