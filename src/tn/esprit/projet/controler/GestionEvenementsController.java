
package tn.esprit.projet.controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import tn.esprit.projet.dao.CommonDAO;
import tn.esprit.projet.dao.EvenementDAO;
import tn.esprit.projet.main.MainApp;
import tn.esprit.projet.model.Evenement;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author Chaker
 */
public class GestionEvenementsController implements Initializable, ControlledScreen {
    
    ScreensController screencontroller;
    CommonDAO cdao = new CommonDAO();
    EvenementDAO edao = new EvenementDAO();
    Evenement selectedEvent;
    
    @FXML
    private TabPane tabpane_evenement;
    @FXML
    private Tab tabconsult_event;
    @FXML
    private TableView<Evenement> table_events;
    @FXML
    private Tab tabajout_event;
    @FXML
    private TextField titre;
    @FXML
    private ChoiceBox<String> type;
    @FXML
    private TextField date_deb;
    @FXML
    private TextField date_fin;
    @FXML
    private CheckBox bonplan;
    @FXML
    private TextArea description;
    @FXML
    private Tab tabmodif_event;
    @FXML
    private TextField titre_modif;
    @FXML
    private ChoiceBox<String> type_modif;
    @FXML
    private TextField date_deb_modif;
    @FXML
    private TextField date_fin_modif;
    @FXML
    private CheckBox bonplan_modif;
    @FXML
    private TextArea description_modif;
    @FXML
    private AnchorPane validerAjout;
    @FXML
    private MenuItem g_commentaire;
    @FXML
    private MenuItem g_film;
    @FXML
    private MenuItem g_news;
    @FXML
    private MenuItem g_membre;
    @FXML
    private MenuItem g_salle;
    @FXML
    private MenuItem g_statistiques;

    /**
     * Initializes the controller class.
     */
    
    public void charger() {
        table_events.getColumns().clear();
        /* Setting Columns and Adding Columns */
        for (String s : cdao.ColonneName("evenement")) {
            TableColumn t = new TableColumn(s);
            t.setCellValueFactory(new PropertyValueFactory(s));
            t.setMinWidth(100);
            t.setMaxWidth(300);
            table_events.getColumns().add(t);
        }
        
        /* Setting Items */
        ObservableList<Evenement> items = edao.ListerEvenements();
        table_events.setItems(items);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        charger();
        type.setItems(FXCollections.observableArrayList("Sortie", "Soirée", 
                "Concert", "Piece de théatre", "Projection"));
        type.getSelectionModel().selectFirst();
        type_modif.setItems(FXCollections.observableArrayList("Sortie", 
                "Soirée", "Concert", "Piece de théatre", "Projection"));
        type_modif.getSelectionModel().selectFirst();
    }    
    
    @Override
    public void SetScreenParent(ScreensController screenpage) {
        screencontroller = screenpage;
    }

    @FXML
    private void supprimerLigne(ActionEvent event) {
        int id=table_events.getSelectionModel().getSelectedItem().getId_evenement();
        edao.supprimerEvenement(id);
        charger();
    }

    @FXML
    private void supprimerTout(ActionEvent event) {
        edao.supprimerTous();
    }

    @FXML
    private void validerAjout(ActionEvent event) {
        
        Evenement e = new Evenement();
        e.setTitre_event(titre.getText());
        e.setBon_plan(bonplan.isSelected());
        e.setDate_deb_event(date_deb.getText());
        e.setDate_fin_event(date_fin.getText());
        e.setDescription(description.getText());
        e.setType_event(type.getSelectionModel().getSelectedItem().toString());
        
        edao.ajouterEvenement(e);
        titre.setText("");
        bonplan.setSelected(false);
        date_deb.setText("");
        date_fin.setText("");
        description.setText("");
        type.getSelectionModel().selectFirst();
        
            
        tabpane_evenement.getSelectionModel().select(tabconsult_event);
    }

    @FXML
    private void validerModification(ActionEvent event) {
        int id = selectedEvent.getId_evenement();
        Evenement e = new Evenement();
            e.setTitre_event(titre_modif.getText());
            e.setDate_deb_event(date_deb_modif.getText());
            e.setDate_fin_event(date_fin_modif.getText());
            e.setType_event(type_modif.getSelectionModel().getSelectedItem());
            e.setDescription(description_modif.getText());
            e.setBon_plan(bonplan_modif.isSelected());
            e.setId_evenement(id);
            
        edao.modifierEvenement(e);
        tabpane_evenement.getSelectionModel().select(tabconsult_event);
    }

    @FXML
    private void consultSelected(Event event) {
        if(tabconsult_event.isSelected()){
            charger();
        }
        
    }

    @FXML
    private void modifierSelected(ActionEvent event) {
        
        selectedEvent = table_events.getSelectionModel().getSelectedItem();
        if(selectedEvent!=null){
            tabmodif_event.setDisable(false);
           titre_modif.setText(selectedEvent.getTitre_event());
           description_modif.setText(selectedEvent.getDescription());
           date_deb_modif.setText(selectedEvent.getDate_deb_event().toString());
           date_fin_modif.setText(selectedEvent.getDate_fin_event().toString());
           type_modif.getSelectionModel().select(selectedEvent.getType_event());
           bonplan_modif.setSelected(selectedEvent.isBon_plan());
           tabpane_evenement.getSelectionModel().select(tabmodif_event);
        }
    }

    @FXML
    private void consultAjout(Event event) {
    }

    @FXML
    private void goToGestionComment(ActionEvent event) {
          MainApp.mainCantainer.loadscreen(MainApp.g_commentaireID, MainApp.g_commentaireFile);
          screencontroller.setScreen(MainApp.g_commentaireID);
    }

    @FXML
    private void goToGestionFilm(ActionEvent event) {
    }

    @FXML
    private void goToGestionNews(ActionEvent event) {
         MainApp.mainCantainer.loadscreen(MainApp.g_newsID, MainApp.g_newsFile);
          screencontroller.setScreen(MainApp.g_newsID);
    }

    @FXML
    private void goToGestionMembre(ActionEvent event) {
         MainApp.mainCantainer.loadscreen(MainApp.g_membreID, MainApp.g_membreFile);
          screencontroller.setScreen(MainApp.g_membreID);
    }

    @FXML
    private void goToGestionSalle(ActionEvent event) {
        MainApp.mainCantainer.loadscreen(MainApp.g_sallecinemaID, MainApp.g_sallecinemmaFile);
          screencontroller.setScreen(MainApp.g_sallecinemaID);
    }

    @FXML
    private void goToGestionStatistiuqes(ActionEvent event) {
    }
    
}
