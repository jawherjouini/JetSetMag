package tn.esprit.projet.controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.projet.dao.CommentaireDAO;
import tn.esprit.projet.dao.CommonDAO;
import tn.esprit.projet.main.MainApp;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.FormattedComment;
import tn.esprit.projet.util.ScreensController;

public class GestionCommentaireController implements Initializable, ControlledScreen {

    ScreensController screencontroller;
    CommonDAO cdao = new CommonDAO();
    CommentaireDAO commentaireDAO = new CommentaireDAO();
    FormattedComment selectedComment;

    @FXML
    private TableView<FormattedComment> table_comments;
    @FXML
    private TextField publication;
    @FXML
    private TextField membre;
    @FXML
    private TextArea texte;
    @FXML
    private TabPane tabpane_commentaire;
    @FXML
    private Tab tabconsult_commentaire;
    @FXML
    private Tab tabmodif_commentaire;
    @FXML
    private TextField date;
    @FXML
    private MenuItem g_evenement;
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

    public void charger() {
        table_comments.getColumns().clear();
        /* Setting Columns */
        TableColumn t1 = new TableColumn("id");
        t1.setCellValueFactory(new PropertyValueFactory("id"));
        t1.setMinWidth(20);
        TableColumn t2 = new TableColumn("Publication");
        t2.setCellValueFactory(new PropertyValueFactory("publication"));
        t2.setMinWidth(150);
        TableColumn tm = new TableColumn("Username");
        tm.setCellValueFactory(new PropertyValueFactory("membre"));
        tm.setMinWidth(100);
        TableColumn t4 = new TableColumn("Texte");
        t4.setCellValueFactory(new PropertyValueFactory("texte"));
        t4.setMinWidth(300);
        TableColumn t3 = new TableColumn("Date/Time");
        t3.setCellValueFactory(new PropertyValueFactory("dateCommentaire"));
        t3.setMinWidth(150);

        /* Adding Columns */
        table_comments.getColumns().add(t1);
        table_comments.getColumns().add(t2);
        table_comments.getColumns().add(tm);
        table_comments.getColumns().add(t3);
        table_comments.getColumns().add(t4);

        /* Setting Items */
        ObservableList<FormattedComment> items = commentaireDAO.ListerCommentaires();
        table_comments.setItems(items);

        /* Testing */
        /*
         System.out.println(items.get(0).id);
         System.out.println(items.get(0).publication);
         System.out.println(items.get(0).texte);
         System.out.println(items.get(0).dateCommentaire);
         */
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        charger();
    }

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        screencontroller = screenpage;
    }

    @FXML
    private void supprimerCommentaire(ActionEvent event) {
        int id = table_comments.getSelectionModel().getSelectedItem().id;
        commentaireDAO.supprimerCommentaire(id);
        charger();

    }

    @FXML
    private void modifierCommentaire(ActionEvent event) {

        selectedComment = table_comments.getSelectionModel().getSelectedItem();
        if (selectedComment != null) {
            tabmodif_commentaire.setDisable(false);
            publication.setText(selectedComment.publication);
            membre.setText(selectedComment.membre);
            texte.setText(selectedComment.texte);
            date.setText(selectedComment.dateCommentaire.toString());
            tabpane_commentaire.getSelectionModel().select(tabmodif_commentaire);
        }

    }

    @FXML
    private void validerModification(ActionEvent event) {

        selectedComment.setTexte(texte.getText());
        commentaireDAO.modifierCommentaire(selectedComment);
        tabpane_commentaire.getSelectionModel().select(tabconsult_commentaire);
    }

    @FXML
    private void consultSelected(Event event) {
        if(tabconsult_commentaire.isSelected()){
            charger();
        }
        
    }

    @FXML
    private void goToGestionEvents(ActionEvent event) {
        MainApp.mainCantainer.loadscreen(MainApp.g_evenementID, MainApp.g_evenementFile);
        screencontroller.setScreen(MainApp.g_evenementID);
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
    }

    @FXML
    private void goToGestionStatiqtiques(ActionEvent event) {
    }

}
