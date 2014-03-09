
package tn.esprit.projet.controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import tn.esprit.projet.dao.CommonDAO;
import tn.esprit.projet.dao.MembreDAO;
import tn.esprit.projet.main.MainApp;

import tn.esprit.projet.model.Membre;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class GestionMembreController implements Initializable,ControlledScreen {
    ScreensController screencontroller;
    CommonDAO cdao = new CommonDAO();
     MembreDAO adao = new MembreDAO();

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
    private Tab onglet_ajout;
    @FXML
    private Font x1;
    @FXML
    private Pane pane;
    @FXML
    private TextField Nom;
    @FXML
    private TextField User_name;
    @FXML
    private TextField email;
    @FXML
    private TableView<Membre> tab;
    @FXML
    private Button confirmer;
    @FXML
    private Button annuler;
    @FXML
    private Label message;
    @FXML
    private MenuItem g_evenement;
    @FXML
    private MenuItem g_commentaire;
    @FXML
    private MenuItem g_film;
    @FXML
    private MenuItem g_news;
    @FXML
    private MenuItem g_salle;
    @FXML
    private MenuItem g_statistiques;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        charger();
        
    }    
     public void charger() {
        tab.getColumns().clear();
        for (String s : cdao.ColonneName("membre")) {
            TableColumn t = new TableColumn(s);
            t.setCellValueFactory(new PropertyValueFactory(s));
            t.setMinWidth(100);
            t.setMaxWidth(200);
            tab.getColumns().add(t);
        }
//        ObservableList<Object[]> items = cdao.finAll("article");
//        System.out.println(items.toString());
//        tab.getItems().setAll(items);
        ObservableList<Membre> items = adao.ListerMembre();
        tab.setItems(items);
    }

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        screencontroller = screenpage;
    }


    @FXML
    private void supprimerLigne(ActionEvent event) {
    
        TableView.TableViewFocusModel model = tab.getFocusModel();
        System.out.println(model.getFocusedItem());
        boolean test =adao.deleteByElement((Membre) model.getFocusedItem());
        charger();
        
    
    }

    @FXML
    private void AjouterMembre(ActionEvent event) throws InterruptedException {
        
       adao.AjouterMembre(Nom.getText() ,User_name.getText(), email.getText()) ;
       charger();
       message.setText(adao.returnMessage());
//System.out.println(jTextArearObject.getToolTipText());
    }
    @FXML
    private void AnnulerAjout(ActionEvent event) {
        Nom.setText("");
        User_name.setText("");
        email.setText("");
    }

    @FXML
    private void goToEvents(ActionEvent event) {
         MainApp.mainCantainer.loadscreen(MainApp.g_evenementID, MainApp.g_evenementFile);
          screencontroller.setScreen(MainApp.g_evenementID);
    }

    @FXML
    private void goToComment(ActionEvent event) {
         MainApp.mainCantainer.loadscreen(MainApp.g_commentaireID, MainApp.g_commentaireFile);
          screencontroller.setScreen(MainApp.g_commentaireID);
    }

    @FXML
    private void goToFilm(ActionEvent event) {
    }

    @FXML
    private void goToNews(ActionEvent event) {
         MainApp.mainCantainer.loadscreen(MainApp.g_newsID, MainApp.g_newsFile);
          screencontroller.setScreen(MainApp.g_newsID);
    }

    @FXML
    private void goToSalle(ActionEvent event) {
         MainApp.mainCantainer.loadscreen(MainApp.g_sallecinemaID, MainApp.g_sallecinemmaFile);
          screencontroller.setScreen(MainApp.g_sallecinemaID);
    }

    @FXML
    private void goToStatistiques(ActionEvent event) {
    }
   
    
  
    }
    

