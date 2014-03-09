/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.projet.controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import static tn.esprit.projet.controler.SoireeController.eventSelect;
import tn.esprit.projet.dao.CommentaireDAO;
import tn.esprit.projet.dao.MembreDao;
import tn.esprit.projet.dao.NoteDAO;
import tn.esprit.projet.model.Commentaire;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.FormattedComment;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author Jawher
 */
public class CommentNoteController implements Initializable, ControlledScreen {

    ScreensController sc;
    CommentaireDAO cdao = new CommentaireDAO();
    MembreDao mdao = new MembreDao();

    @FXML
    private Label lb_titre;
    @FXML
    private Button btn_commenter;
    @FXML
    private ListView<FormattedComment> list;
    @FXML
    private TextArea ta_comm;
    @FXML
    private ToggleGroup x1;
    @FXML
    private Text lbnote;
    @FXML
    private RadioButton rd1;
    @FXML
    private RadioButton rd2;
    @FXML
    private RadioButton rd3;
    @FXML
    private RadioButton rd4;
    @FXML
    private RadioButton rd5;
    private int note;
    NoteDAO notDao = new NoteDAO();
    @FXML
    private HBox hbnote;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        charger();
        if (loginController.membre == null) {
            ta_comm.setDisable(true);
            btn_commenter.setDisable(true);
           hbnote.setDisable(true);
        }
        // TODO
    }

    @FXML
    private void commenter(ActionEvent event) {
        try {
            Commentaire c = new Commentaire();
            c.setEvenement(eventSelect);
            c.setMembre(loginController.membre);
            c.setTexte(ta_comm.getText());
            cdao.CommenterEvenement(c);
            list.setItems(cdao.ListerCommentairesById(eventSelect.getId_evenement()));
            System.out.println(ta_comm.getText());
        } catch (Exception ex) {
            System.out.println("erreur membre commentaire: " + ex.getMessage());
        }
    }

    public void charger() {
        lbnote.setText("Note : " + notDao.getNoteById(eventSelect.getId_evenement()) + " /5");

        CommentaireDAO cdao = new CommentaireDAO();
        // MembreDao mdao = new MembreDao();
        System.out.println(SoireeController.eventSelect.getTitre_event());
        lb_titre.setText(SoireeController.eventSelect.getTitre_event());
        System.out.println(SoireeController.eventSelect);
        list.setItems(cdao.ListerCommentairesById(SoireeController.eventSelect.getId_evenement()));
    }

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        sc = screenpage;

    }

    @FXML
    private void noter(ActionEvent event) {

        System.out.println();
        note = Integer.parseInt(((RadioButton) x1.getSelectedToggle()).getText());
        System.out.println(notDao.verifierNote(loginController.membre.getId_membre(),"evenement",eventSelect.getId_evenement()));
        if (! notDao.verifierNote(loginController.membre.getId_membre(),"evenement",eventSelect.getId_evenement())) {
         notDao.insererNote("evenement", note, loginController.membre.getId_membre(), eventSelect.getId_evenement());
        }
        else
        {
           
       notDao.Updatenote("evenement", note, loginController.membre.getId_membre(), eventSelect.getId_evenement());
  
        }
        lbnote.setText("Note : " + notDao.getNoteById(eventSelect.getId_evenement()) + " /5");

    }

}
