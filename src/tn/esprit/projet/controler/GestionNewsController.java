package tn.esprit.projet.controler;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import tn.esprit.projet.dao.ArticleDAO;
import tn.esprit.projet.dao.CommonDAO;
import tn.esprit.projet.main.MainApp;
import tn.esprit.projet.model.Article;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author oukhay
 */
public class GestionNewsController implements Initializable, ControlledScreen {

    ScreensController screencontroller;
    @FXML
    private Button btn_del;
    @FXML
    private TableView<Article> tab;
    @FXML
    private Button btn_deltt;
    @FXML
    private Tab onglet_consult;
    @FXML
    private VBox vb;
    @FXML
    private Tab onglet_ajout;
    @FXML
    private Tab onglet_modif;
    @FXML
    private TextField tf_titre;
    @FXML
    private Button btn_add;
    @FXML
    private HTMLEditor html_text;
    @FXML
    private HTMLEditor html_text_mod;
    @FXML
    private TextField tf_id;
    @FXML
    private TextField tf_titre_mod;
    @FXML
    private Button btn_mod;
    @FXML
    private Button btn_valid;

    CommonDAO cdao = new CommonDAO();
    ArticleDAO adao = new ArticleDAO();
    Article a;
    @FXML
    private TabPane tabpane;
    @FXML
    private ImageView header;
    @FXML
    private Button btn_pdf;

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
            t.setCellValueFactory(new PropertyValueFactory(s));
            t.setMinWidth(100);
            t.setMaxWidth(200);
            tab.getColumns().add(t);
        }
        ObservableList<Article> items = adao.ListerArticles();
        tab.setItems(items);
    }

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        screencontroller = screenpage;
    }

    @FXML
    private void supprimerLigne(ActionEvent event) {
        try {
            TableView.TableViewFocusModel model = tab.getFocusModel();
            adao.deleteByElement((Article) model.getFocusedItem());
            charger();
        } catch (Exception e) {
            System.out.println("erreur: " + e.getMessage());
        }
    }

    @FXML
    private void supprimerTout(ActionEvent event) {
        try {
            adao.delete();
            charger();
        } catch (Exception e) {
            System.out.println("erreur: " + e.getMessage());
        }
    }

    @FXML
    private void ajouterArticle(ActionEvent event) {
        a = new Article();
        a.setTitre(tf_titre.getText());
        a.setTexte(html_text.getHtmlText().replaceAll("'", "§"));
        adao.add(a);
        System.out.println("a.gettext ajout " + a.getTexte());
        charger();
        tabpane.getSelectionModel().select(onglet_consult);
    }

    @FXML
    private void chargerModif(ActionEvent event) {
        tabpane.getSelectionModel().select(onglet_modif);

        TableView.TableViewFocusModel model = tab.getFocusModel();
        a = (Article) model.getFocusedItem();
        tf_id.setText(String.valueOf(a.getId_article()));
        tf_id.setDisable(true);
        tf_titre_mod.setText(a.getTitre());
        html_text_mod.setHtmlText(a.getTexte().replaceAll("§", "'"));
        System.out.println("htmltextmod " + html_text_mod.getHtmlText());
    }

    @FXML
    private void modifierArticle(ActionEvent event) {
        a = new Article();
        a.setId_article(Integer.parseInt(tf_id.getText()));
        a.setTitre(tf_titre_mod.getText());
        a.setTexte(html_text_mod.getHtmlText().replaceAll("'", "§"));
        System.out.println("a.gettext modif " + a.getTexte());
        adao.update(a);
        charger();
        tabpane.getSelectionModel().select(onglet_consult);
    }

    @FXML
    private void genererRapportArticle(ActionEvent event) {
        cdao.genererRapport("article");
    }

        private void goToEvents(ActionEvent event) {
        MainApp.mainCantainer.loadscreen(MainApp.g_evenementID, MainApp.g_evenementFile);
        screencontroller.setScreen(MainApp.g_evenementID);
    }

        private void goToMembre(ActionEvent event) {
         MainApp.mainCantainer.loadscreen(MainApp.g_membreID, MainApp.g_membreFile);
          screencontroller.setScreen(MainApp.g_membreID);
    }

        private void goToCommentaire(ActionEvent event) {
        MainApp.mainCantainer.loadscreen(MainApp.g_commentaireID, MainApp.g_commentaireFile);
        screencontroller.setScreen(MainApp.g_commentaireID);
    }
}
