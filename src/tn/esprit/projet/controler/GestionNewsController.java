/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.projet.controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import tn.esprit.projet.dao.ArticleDAO;
import tn.esprit.projet.dao.CommonDAO;
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
    CommonDAO cdao = new CommonDAO();
    ArticleDAO adao = new ArticleDAO();
    @FXML
    private Tab onglet_consult;
    @FXML
    private VBox vb;
    @FXML
    private Tab onglet_ajout;
    @FXML
    private Tab onglet_modif;

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
//        ObservableList<Object[]> items = cdao.finAll("article");
//        System.out.println(items.toString());
//        tab.getItems().setAll(items);
        ObservableList<Article> items = adao.ListerArticles();
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
        adao.deleteByElement((Article) model.getFocusedItem());
        charger();
    }

    @FXML
    private void supprimerTout(ActionEvent event) {
        adao.delete();
        charger();
    }

}
