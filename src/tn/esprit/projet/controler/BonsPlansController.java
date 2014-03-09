/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.projet.controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebView;
import tn.esprit.projet.dao.EvenementDAO;
import tn.esprit.projet.model.Evenement;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author Jawher
 */
public class BonsPlansController implements Initializable, ControlledScreen {

    ScreensController sc;
    @FXML
    private GridPane gr_plans;
    @FXML
    private WebView wv_1;
    @FXML
    private WebView wv_2;
    @FXML
    private WebView wv_3;
    @FXML
    private WebView wv_4;
    @FXML
    private WebView wv_5;
    @FXML
    private WebView wv_6;

    ObservableList<Evenement> list = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EvenementDAO edao = new EvenementDAO();
        list = edao.ListerBonsPlans();
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i);
            Evenement e = list.get(i);
            switch (i) {
                case 0: wv_1.getEngine().loadContent("<div style=\"background-color:#FFF;width:430px;height:148px;font-family:Verdana, Geneva, sans-serif\"><p style=\"text-align:right;color:#F00;text-shadow:#666;margin:5px\">"+e.getType_event()+"</p>\n" +
"<h3 style=\"font:Arial, Helvetica, sans-serif;text-align:center;background-color:#006;color:#FFF\">"+e.getTitre_event()+"</h3>\n" +
"<p style=\"font-size:18px;text-align:center;color:#039\">du "+e.getDate_deb_event().substring(0, 16)+"<br/>au "+e.getDate_fin_event().substring(0, 16)+"</p></div>");break;
                case 1: wv_2.getEngine().loadContent("<div style=\"background-color:#FFF;width:430px;height:148px;font-family:Verdana, Geneva, sans-serif\"><p style=\"text-align:right;color:#F00;text-shadow:#666;margin:5px\">"+e.getType_event()+"</p>\n" +
"<h3 style=\"font:Arial, Helvetica, sans-serif;text-align:center;background-color:#006;color:#FFF\">"+e.getTitre_event()+"</h3>\n" +
"<p style=\"font-size:18px;text-align:center;color:#039\">du "+e.getDate_deb_event().substring(0, 16)+"<br/>au "+e.getDate_fin_event().substring(0, 16)+"</p></div>");break;
                
                case 2: wv_3.getEngine().loadContent("<div style=\"background-color:#FFF;width:430px;height:148px;font-family:Verdana, Geneva, sans-serif\"><p style=\"text-align:right;color:#F00;text-shadow:#666;margin:5px\">"+e.getType_event()+"</p>\n" +
"<h3 style=\"font:Arial, Helvetica, sans-serif;text-align:center;background-color:#006;color:#FFF\">"+e.getTitre_event()+"</h3>\n" +
"<p style=\"font-size:18px;text-align:center;color:#039\">du "+e.getDate_deb_event().substring(0, 16)+"<br/>au "+e.getDate_fin_event().substring(0, 16)+"</p></div>");break;
                
                case 3: wv_4.getEngine().loadContent("<div style=\"background-color:#FFF;width:430px;height:148px;font-family:Verdana, Geneva, sans-serif\"><p style=\"text-align:right;color:#F00;text-shadow:#666;margin:5px\">"+e.getType_event()+"</p>\n" +
"<h3 style=\"font:Arial, Helvetica, sans-serif;text-align:center;background-color:#006;color:#FFF\">"+e.getTitre_event()+"</h3>\n" +
"<p style=\"font-size:18px;text-align:center;color:#039\">du "+e.getDate_deb_event().substring(0, 16)+"<br/>au "+e.getDate_fin_event().substring(0, 16)+"</p></div>");break;
                
                case 4: wv_5.getEngine().loadContent("<div style=\"background-color:#FFF;width:430px;height:148px;font-family:Verdana, Geneva, sans-serif\"><p style=\"text-align:right;color:#F00;text-shadow:#666;margin:5px\">"+e.getType_event()+"</p>\n" +
"<h3 style=\"font:Arial, Helvetica, sans-serif;text-align:center;background-color:#006;color:#FFF\">"+e.getTitre_event()+"</h3>\n" +
"<p style=\"font-size:18px;text-align:center;color:#039\">du "+e.getDate_deb_event().substring(0, 16)+"<br/>au "+e.getDate_fin_event().substring(0, 16)+"</p></div>");break;
                
                case 5: wv_6.getEngine().loadContent("<div style=\"background-color:#FFF;width:430px;height:148px;font-family:Verdana, Geneva, sans-serif\"><p style=\"text-align:right;color:#F00;text-shadow:#666;margin:5px\">"+e.getType_event()+"</p>\n" +
"<h3 style=\"font:Arial, Helvetica, sans-serif;text-align:center;background-color:#006;color:#FFF\">"+e.getTitre_event()+"</h3>\n" +
"<p style=\"font-size:18px;text-align:center;color:#039\">du "+e.getDate_deb_event().substring(0, 16)+"<br/>au "+e.getDate_fin_event().substring(0, 16)+"</p></div>");break;
                
            }
        }
    }

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        sc = screenpage;
    }

}
