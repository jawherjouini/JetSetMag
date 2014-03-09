
package tn.esprit.projet.controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Callback;
import tn.esprit.projet.dao.ArticleDAO;
import tn.esprit.projet.model.Article;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author Jawher
 */
public class NewsController implements Initializable, ControlledScreen {

    ScreensController screencontroller;
    ArticleDAO adao = new ArticleDAO();

    @FXML
    private AnchorPane left_pane;
    @FXML
    private Font x1;
    @FXML
    private AnchorPane mid_pane;
    @FXML
    private Color x2;
    @FXML
    private AnchorPane right_pane;
    @FXML
    private ListView<Article> ls_lus;
    @FXML
    private ListView<Article> ls_notes;
    @FXML
    private ListView<Article> ls_new;
    @FXML
    private Label l_lus;
    @FXML
    private Label l_notes;
    @FXML
    private Label l_new;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        charger();
    }

    public void charger() {
        ls_lus.setItems(adao.ListerArticles());
        ls_lus.setCellFactory(new Callback<ListView<Article>, ListCell<Article>>() {
            @Override
            public ListCell<Article> call(ListView<Article> p) {
                ListCell<Article> cell = new ListCell<Article>() {
                    @Override
                    protected void updateItem(Article t, boolean bln) {
                        /* super.updateItem(t, bln); */
                        if (t != null) {
                            Label l = new Label(t.getDate_redaction().substring(0, 16));
                            setText(t.getTitre()+ " tttttttttttttt"
                                    + "tttttttttttttttttttttttttttttttt\nttttttttttttttttttttttttttttttttttttttttt"
                                    + "ttt\ntttttt | lu " + t.getNbr_visite() + " fois");
                        }
                    }
                };
                return cell;
            }
        });
        
    }

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        screencontroller = screenpage;
    }

    @FXML
    private void recupereligne(MouseEvent event) {
        System.out.println(ls_lus.getSelectionModel().getSelectedItem());
    }

}
