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
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tn.esprit.projet.dao.CommonDAO;
import tn.esprit.projet.model.Article;

/**
 * FXML Controller class
 *
 * @author Jawher
 */
public class GestionNewsController implements Initializable {
    @FXML
    private MenuBar menu;
    @FXML
    private Menu fichier;
    @FXML
    private MenuItem profil;
    @FXML
    private Menu films;
    @FXML
    private Menu news;
    @FXML
    private Menu events;
    @FXML
    private Menu membres;
    @FXML
    private Menu salles;
    @FXML
    private Menu comms;
    @FXML
    private Menu stats;
    @FXML
    private TabPane tabpane;
    @FXML
    private Tab onglet_cons;
    @FXML
    private Button btn_del;
    @FXML
    private TableView<Article> tab;
    @FXML
    private Tab onglet_ajout;
    @FXML
    private Tab onglet_modif;
    
    CommonDAO cdao = new CommonDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        charger();
    } 
    
    public void charger() {
        tab.getColumns().clear();
        for (String s : cdao.ColonneName("article")) {
            TableColumn t = new TableColumn(s);
            tab.getColumns().add(t);
        }
    }
    
}
