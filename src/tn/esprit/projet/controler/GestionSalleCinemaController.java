
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
import tn.esprit.projet.dao.CinemaDao;
import tn.esprit.projet.dao.CommonDAO;
import tn.esprit.projet.model.Cinema;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class GestionSalleCinemaController implements Initializable, ControlledScreen {

    ScreensController screencontroller;
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
    private TableView<Cinema> tab;
    @FXML
    private Tab onglet_ajout;
    @FXML
    private Pane pane;
    @FXML
    private Label message;
    @FXML
    private Font x1;
    @FXML
    private Button confirmer;
    @FXML
    private Button annuler;

    CommonDAO cdao = new CommonDAO();
    CinemaDao adao = new CinemaDao();

    @FXML
    private TextField Nom_salle;
    @FXML
    private TextField Adresse;
    @FXML
    private TextField Emplacement;
    @FXML
    private Button Afficher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        charger();
    }

    @FXML
    public void charger() {
        tab.getColumns().clear();
        for (String s : cdao.ColonneName("cinema")) {
            TableColumn t = new TableColumn(s);
           t.setCellValueFactory(new PropertyValueFactory(s));
            t.setMinWidth(100);
            t.setMaxWidth(200);
            tab.getColumns().add(t);
        }
        
        ObservableList<Cinema> items = adao.read();
     
        tab.setItems(items);
       
    }

    @FXML
    private void supprimerLigne(ActionEvent event) {
        TableView.TableViewFocusModel model = tab.getFocusModel();
        System.out.println(model.getFocusedItem());
        int test =adao.delete((Cinema) model.getFocusedItem());
        charger();
        System.out.println(test);

    }

    @FXML
    private void AnnulerAjout(ActionEvent event) {
        Nom_salle.setText("");
        Adresse.setText("");
        Emplacement.setText("");
    }

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        screencontroller = screenpage;
    }

    @FXML
    private void AjouterSalle(ActionEvent event) {
         adao.create(new Cinema(Adresse.getText(), Emplacement.getText(),Nom_salle.getText())) ;
       charger();
    }

}
