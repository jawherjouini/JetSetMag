/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.projet.controler;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tn.esprit.projet.dao.ArticleDAO;
import tn.esprit.projet.dao.CommonDAO;
import tn.esprit.projet.dao.FilmDao;
import tn.esprit.projet.dao.MediaDao;
import tn.esprit.projet.dao.Media_Par_ElementDao;
import tn.esprit.projet.model.Article;
import tn.esprit.projet.model.Film;
import tn.esprit.projet.model.Media;
import tn.esprit.projet.model.Media_Par_Element;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author tasnim
 */
public class GestionFilmController implements Initializable, ControlledScreen {

    ScreensController screencontroller;
    @FXML
    private Button btn_del;
    @FXML
    private Button btn_deltt;
    @FXML
    private VBox vb;
    @FXML
    private TableView<Film> tab;

    //private DatePicker birthdayDatePicker;
    CommonDAO cdao = new CommonDAO();
    ArticleDAO adao = new ArticleDAO();
    FilmDao Filmdao = new FilmDao();

    /**
     * Initializes the controller class.
     */
    private TextField tf_titre;
    private HTMLEditor html_text;
    @FXML
    private Button openpicbtn;
    @FXML
    private Button openvidbtn;
    @FXML
    private TextField txtTitre;
    @FXML
    private TextField txtImage;
    @FXML
    private TextField txtDuree;
    @FXML
    private TextField txtFilm;
    @FXML
    private TextField txtDate;
    @FXML
    private TextArea txtSynop;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnModif;
    @FXML
    private TextField titreMod;
    @FXML
    private TextField DureeModif;
    @FXML
    private TextField dateSortieMod;
    @FXML
    private TextArea synopMod;
    @FXML
    private TabPane tabpane_evenement;
    @FXML
    private Tab tabconsult_event;
    @FXML
    private Tab tabajout_event;
    @FXML
    private AnchorPane validerAjout;
    @FXML
    private Tab tabmodif_event;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        charger();
    }

    public void charger() {
        tab.getColumns().clear();
        for (String s : cdao.ColonneName("film")) {
            TableColumn t = new TableColumn(s);
            t.setCellValueFactory(new PropertyValueFactory(s));
            t.setMinWidth(100);
            t.setMaxWidth(200);
            tab.getColumns().add(t);
        }
//         for (String s : cdao.ColonneName("Media")) {
//            TableColumn t = new TableColumn(s);
//            t.setCellValueFactory(new PropertyValueFactory(s));
//            t.setMinWidth(100);
//            t.setMaxWidth(200);
//            tab.getColumns().add(t);
//        }
//          for (String s : cdao.ColonneName("production")) {
//            TableColumn t = new TableColumn(s);
//            t.setCellValueFactory(new PropertyValueFactory(s));
//            t.setMinWidth(100);
//            t.setMaxWidth(200);
//            tab.getColumns().add(t);
//        }
//          ObservableList<Film> films =FXCollections.observableArrayList();;
//           ObservableList<Media> medias =FXCollections.observableArrayList();
        ObservableList<Film> items =FXCollections.observableArrayList();
          items = Filmdao.read();
//        for (int i = 0; i < items.size(); i++) {
//            films.add(items.get(i).getFilm());
//            medias.add(items.get(i).getMedia());
//        }
//        tab.setItems(medias);
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
        Filmdao.delete((Film) model.getFocusedItem());
        media_Par_ElementDao.deleteByFilm((Film) model.getFocusedItem());
        charger();
    }

    @FXML
    private void supprimerTout(ActionEvent event) {
        Filmdao.deleteAll();
        media_Par_ElementDao.deleteAll();
        charger();
    }


    @FXML
    private void choisirImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        configureFileChooserImage(fileChooser);
        fileChooser.setTitle("Open Resource File");
        Stage stage = new Stage();
        File file = fileChooser.showOpenDialog(stage);
        String image = file.getAbsolutePath();
        txtImage.setText(image);
        System.out.println(file.getAbsolutePath());
    }

    private static void configureFileChooserImage(
            final FileChooser fileChooser) {
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
    }

    private static void configureFileChooserVideo(
            final FileChooser fileChooser) {
        fileChooser.setTitle("View Films");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Videos", "*.*"),
                new FileChooser.ExtensionFilter("MP4", "*.mp4"),
                new FileChooser.ExtensionFilter("FLV", "*.flv")
        );
    }

    @FXML
    private void choisirVodeo(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        configureFileChooserVideo(fileChooser);
        Stage stage = new Stage();
        File file = fileChooser.showOpenDialog(stage);
        String film = file.getAbsolutePath();
        txtFilm.setText(film);
    }

    MediaDao mediaDao = new MediaDao();
    Media_Par_ElementDao media_Par_ElementDao = new Media_Par_ElementDao();

    @FXML
    private void ajouterFilm(ActionEvent event) {

        int id_film = Filmdao.create(new Film(txtDate.getText(), txtSynop.getText(), txtTitre.getText(), txtDuree.getText()));
        int id_mediai = mediaDao.create(new Media("image", txtImage.getText().trim()));
        int id_mediaf = mediaDao.create(new Media("Video", txtFilm.getText().trim()));

        media_Par_ElementDao.create(id_mediai, id_film);
        media_Par_ElementDao.create(id_mediaf, id_film);
        
        charger();
    }

    int id_film=0;
    @FXML
    private void modifierFilm(ActionEvent event) {
        System.out.println("aaaaaaaaa");
        Film film= new Film(id_film);
        film.setNom_film(titreMod.getText());
        film.setSynopsis(synopMod.getText());
        film.setDate_sortie(dateSortieMod.getText());
        film.setDuree(DureeModif.getText());
        System.out.println("aaaaaaaaa");
        Filmdao.update(film);   
        System.out.println("aaaaaaaaa");
        charger();
    }

    @FXML
    private void remplir(MouseEvent event) {
        TableView.TableViewFocusModel model = tab.getFocusModel();
        System.out.println(model.getFocusedItem());
        try {
             id_film=((Film) model.getFocusedItem()).getId_film();
             titreMod.setText(((Film) model.getFocusedItem()).getNom_film());
             DureeModif.setText(((Film) model.getFocusedItem()).getDuree());
             dateSortieMod.setText(((Film) model.getFocusedItem()).getDate_sortie());
             synopMod.setText(((Film) model.getFocusedItem()).getSynopsis());   
            
        }catch (Exception e) {        
        }
    }
}
