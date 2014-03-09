/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import tn.esprit.projet.dao.CommonDAO;
import tn.esprit.projet.dao.EvenementDAO;
import tn.esprit.projet.model.Evenement;

/**
 * FXML Controller class
 *
 * @author oukhay
 */
public class ConsulterProfilController implements Initializable {
    @FXML
    private Font x1;
    @FXML
    private Color x2;
    @FXML
    private Font x3;
    @FXML
    private Label lbuser;
    @FXML
    private Color x4;
    @FXML
    private Label lbmail;
    @FXML
    private Label lbname;
    EvenementDAO eventdao = new EvenementDAO();
    CommonDAO cdao = new CommonDAO();
    @FXML
    private TableView<Evenement> table_events;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbuser.setText(loginController.membre.getUsername());
        lbmail.setText(loginController.membre.getEmail());
        lbname.setText(loginController.membre.getNom());
        loadEvent();
        // TODO
    }    
    public void loadEvent(){
        table_events.getColumns().clear();
        /* Setting Columns and Adding Columns */
        for (String s : cdao.ColonneName("evenement")) {
            if(!s.equals("id_membre")&&!s.equals("bon_plan")&&!s.equals("id_evenement")){
                
            TableColumn t = new TableColumn(s);
            t.setCellValueFactory(new PropertyValueFactory(s));
            t.setMinWidth(100);
            t.setMaxWidth(300);
            table_events.getColumns().add(t);}
        }
        
        /* Setting Items */
        ObservableList<Evenement> items = eventdao.findEventsByID();
        table_events.setItems(items);
        
        
    }
    
}
