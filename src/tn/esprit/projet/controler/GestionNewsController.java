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
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;
import tn.esprit.projet.dao.ArticleDAO;
import tn.esprit.projet.dao.CommonDAO;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author oukhay
 */
public class GestionNewsController implements Initializable,ControlledScreen {
    ScreensController screencontroller;
    CommonDAO cdao = new CommonDAO();
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
    private TableView<Object> tab;
    @FXML
    private Tab onglet_ajout;
    @FXML
    private TextField tf_titre_article_a;
    @FXML
    private Button btn_ajout;
    @FXML
    private HTMLEditor he_texte_a;
    @FXML
    private Tab onglet_modif;
    @FXML
    private HTMLEditor he_texte_m;
    @FXML
    private TextField tf_id_article;
    @FXML
    private Button btn_modifier;
    @FXML
    private TextField tf_titre_article_m;
    

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

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        screencontroller = screenpage;
    }
    
}
