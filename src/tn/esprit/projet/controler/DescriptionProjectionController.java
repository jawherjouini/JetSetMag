/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author oukhay
 */
public class DescriptionProjectionController implements Initializable {
    @FXML
    private AnchorPane anchP;
    @FXML
    private WebView webview;
    @FXML
    private Label lblNom;
    @FXML
    private Font x1;
    @FXML
    private Label lblDesc;
    @FXML
    private Color x2;
    @FXML
    private Label lblDateH;
    @FXML
    private ImageView imgview;
    @FXML
    private VBox MyVbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
