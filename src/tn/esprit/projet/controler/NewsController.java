package tn.esprit.projet.controler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import static tn.esprit.projet.controler.SoireeController.eventSelect;
import tn.esprit.projet.dao.ArticleDAO;
import tn.esprit.projet.main.MainApp;
import tn.esprit.projet.model.Article;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.MailClass;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author Jawher
 */
public class NewsController implements Initializable, ControlledScreen {

    public static Article articleSelect = null;
    ScreensController screencontroller;
    ArticleDAO adao = new ArticleDAO();

    @FXML
    private AnchorPane left_pane;
    @FXML
    private AnchorPane right_pane;
    @FXML
    private ListView<Article> ls_lus;
    @FXML
    private ListView<Article> ls_notes;
    @FXML
    private ListView<Article> ls_new;
    @FXML
    private Tab tab_new;
    @FXML
    private Tab tab_lus;
    @FXML
    private Tab tab_notes;
    @FXML
    private Label lb_titre;
    @FXML
    private Label lb_date;
    @FXML
    private WebView wv_article;
    @FXML
    private Hyperlink h_comm;
    @FXML
    private Hyperlink h_inv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        charger();
    }

    public void charger() {
        lb_date.setText("");
        lb_titre.setText("");
        wv_article.getEngine().loadContent("");
        ls_lus.setItems(adao.ListerArticlesParOrdre("nbr_visite"));
        ls_notes.setItems(adao.ListerArticlesParOrdre("note_moy"));
        ls_new.setItems(adao.ListerArticlesParOrdre("date_redaction"));
    }

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        screencontroller = screenpage;
    }

    @FXML
    private void noterCommenter(ActionEvent event) {
        Stage stage = new Stage();
        if (articleSelect != null) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(MainApp.c_notercommenterFile));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(SoireeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void InviterAmi(ActionEvent event) {
    if (articleSelect != null) {
            Stage newStage = new Stage();
            VBox comp = new VBox();
            comp.setMaxHeight(300);

            VBox espaceMail = new VBox();
            espaceMail.setMaxHeight(300);
            espaceMail.setSpacing(10);

            HBox hb_user = new HBox();
            Label lb_user = new Label("Votre e-mail: ");
            final TextField tf_user = new TextField();
            hb_user.getChildren().add(lb_user);
            hb_user.getChildren().add(tf_user);
            hb_user.setSpacing(20);
            espaceMail.getChildren().add(hb_user);

            HBox hb_mail = new HBox();
            Label lb_mail = new Label("L'e-mail de votre ami: ");
            final TextField tf_mail = new TextField();
            hb_mail.getChildren().add(lb_mail);
            hb_mail.getChildren().add(tf_mail);
            hb_mail.setSpacing(20);
            espaceMail.getChildren().add(hb_mail);

            HBox hb_comm = new HBox();
            Label lb_comm = new Label("Message: ");
            final TextArea ta_comm = new TextArea();
            tf_user.addEventHandler(EventType.ROOT, new EventHandler<Event>() {

                @Override
                public void handle(Event t) {
                    ta_comm.setText(" Salut! je suis " + tf_user.getText()
                            + " et je t'invite à lire cet article:\n"
                            + articleSelect.getTitre());
                }
            });
            ta_comm.setEditable(false);
            ta_comm.setMaxSize(300, 100);
            hb_comm.getChildren().add(lb_comm);
            hb_comm.getChildren().add(ta_comm);
            hb_comm.setSpacing(20);
            espaceMail.getChildren().add(hb_comm);

            Button btn_comm = new Button("Envoyer");
            btn_comm.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    MailClass class1 = new MailClass();
                    class1.Setmail("[JetSetMag] Invitation à lire un article ", ta_comm.getText());
                    try {
                        class1.SendMyMail(tf_user.getText(), tf_mail.getText(), tf_user.getText(), tf_mail.getText());
                    } catch (Exception ex) {
                        System.out.println("erreur: " + ex.getMessage());
                    }
                    System.out.println(articleSelect + " bouton");
                }
            });
            espaceMail.getChildren().add(btn_comm);

            comp.getChildren().add(espaceMail);
            comp.setSpacing(20);

            Scene stageScene = new Scene(comp, 400, 300);
            newStage.setScene(stageScene);
            newStage.show();
        }
    }

    @FXML
    private void recupererLigne(MouseEvent event) {
        if (tab_lus.isSelected()) {
            articleSelect = ls_lus.getSelectionModel().getSelectedItem();
        } else if (tab_notes.isSelected()) {
            articleSelect = ls_notes.getSelectionModel().getSelectedItem();
        } else if (tab_new.isSelected()) {
            articleSelect = ls_new.getSelectionModel().getSelectedItem();
        }
        System.out.println(articleSelect);
        wv_article.getEngine().loadContent(articleSelect.getTexte().replaceAll("§", "'"));
        lb_titre.setText(articleSelect.getTitre());
        lb_date.setText("écrit le: " + articleSelect.getDate_redaction().substring(0, 16));
        eventSelect = null;
    }

}
