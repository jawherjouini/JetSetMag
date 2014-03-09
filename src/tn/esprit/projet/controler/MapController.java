/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author oukhay
 */
public class MapController implements Initializable , ControlledScreen{
    ScreensController screencontroller;
    WebEngine engine = new WebEngine();
    @FXML
    private WebView webview;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        WebEngine engine = webview.getEngine();
        engine.load("https://goo.gl/maps/HJ50t");
        System.out.println(engine.getLocation());
//        engine.onVisibilityChangedProperty().addListener(new ChangeListener<EventHandler<WebEvent<Boolean>>>);
        
    }    

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        screencontroller= screenpage;
    }
    
}
