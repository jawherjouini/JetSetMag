/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.controler;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tn.esprit.projet.dao.ArticleDAO;
import tn.esprit.projet.dao.CinemaDao;
import tn.esprit.projet.dao.CommonDAO;
import tn.esprit.projet.dao.FilmDao;
import tn.esprit.projet.dao.MediaDao;
import tn.esprit.projet.dao.Media_Par_ElementDao;
import tn.esprit.projet.dao.ProjectionDao;
import tn.esprit.projet.model.Article;
import tn.esprit.projet.model.Cinema;
import tn.esprit.projet.model.Film;
import tn.esprit.projet.model.Media;
import tn.esprit.projet.model.Projection;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.ProjectionUtil;
import tn.esprit.projet.util.ProjectionUtilDao;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author tasnim
 */
public class GestionProjectionController implements Initializable , ControlledScreen {

    ScreensController screencontroller;
    @FXML
    private Tab onglet_consult;
    @FXML
    private Button btn_del;
    @FXML
    private Button btn_deltt;
    @FXML
    private VBox vb;
    @FXML
    private TableView<ProjectionUtil> tab;
    @FXML
    private Tab onglet_ajout;
    @FXML
    private AnchorPane anchpane_ajout;
    @FXML
    private TextField txtCinemaAj;
    @FXML
    private Button btnajouter;
    @FXML
    private TextField txtImage;
    @FXML
    private TextField txtDate;
    @FXML
    private TextField txtSalle;
    @FXML
    private TextField txtFilm;
    @FXML
    private TextArea txtSynop;
    @FXML
    private Button openpicbtn;
    @FXML
    private TextField txtDuree;
    @FXML
    private TextField txtAds;
    @FXML
    private Tab onglet_modif;
    @FXML
    private TextField txtCinemaMod;
    @FXML
    private TextField txtImageModif;
    @FXML
    private TextField txtDateModif;
    @FXML
    private TextField txtSalleModif;
    @FXML
    private TextField txtFilmmodif;
    @FXML
    private TextArea txtSynopModif;
    @FXML
    private TextField TxtDureeModif;
    @FXML
    private TextField txtAdsModif;
    @FXML
    private Button btnModif;

    CommonDAO cdao = new CommonDAO();
    ArticleDAO adao = new ArticleDAO();
    FilmDao Filmdao = new FilmDao();
    ProjectionUtilDao pdao = new ProjectionUtilDao();
    /**
     * Initializes the controller class.
     */
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        charger();
    }

    public void charger() {
        tab.getColumns().clear();
        String[] nomcolone= {"id_film","synopsis","date_ajout", "nom_film","duree","id_projection", "date_heure","id_salle","adresse","emplacement","nom_salle"};
        for (int i = 0; i < 11; i++) {
             TableColumn t = new TableColumn(nomcolone[i]);
                t.setCellValueFactory(new PropertyValueFactory(nomcolone[i]));
                t.setMinWidth(100);
                t.setMaxWidth(200);
                tab.getColumns().add(t);
            }      
            ObservableList<ProjectionUtil> items =FXCollections.observableArrayList();
            items = pdao.read();
            tab.setItems(items);
    }

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        screencontroller = screenpage;
    }

            ProjectionDao projectionDao= new ProjectionDao();
        CinemaDao cinemaDao = new CinemaDao();

    @FXML
    private void supprimerLigne(ActionEvent event) {
        TableView.TableViewFocusModel model = tab.getFocusModel();
        System.out.println(model.getFocusedItem());
        ProjectionUtil projectionutil= (ProjectionUtil)model.getFocusedItem();
        Film film = new Film(projectionutil.getId_film(), projectionutil.getSynopsis(),projectionutil.getDate_ajout(), projectionutil.getNom_film(),projectionutil.getDuree());
        Filmdao.delete(film);
        media_Par_ElementDao.deleteByFilm(film);
        Cinema cinema = new Cinema(projectionutil.getId_salle(),projectionutil.getAdresse(),projectionutil.getEmplacement(),projectionutil.getNom_salle());
        cinemaDao.delete(cinema);
        Projection projection= new Projection(projectionutil.getId_projection(), projectionutil.getDate_heure(), cinema, film);
        projectionDao.delete(projection);
        charger();
    }

    @FXML
    private void supprimerTout(ActionEvent event) {
       projectionDao.deleteAll();
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

   
    MediaDao mediaDao = new MediaDao();
    Media_Par_ElementDao media_Par_ElementDao = new Media_Par_ElementDao();

    int id_film=0;
    int id_cinema=0;
    private int ajouterFilm() {

        int id_film = Filmdao.create(new Film(txtDate.getText(), txtSynop.getText(), txtFilm.getText(), txtDuree.getText()));

        return id_film;
    }
    private int ajouterMedia(){
        int id_mediai = mediaDao.create(new Media("image", txtImage.getText().trim()));
        return id_mediai;
    }

     private int ajouterCinema() {

        int id_cinema= cinemaDao.create(new Cinema(txtAds.getText(), txtCinemaAj.getText(), txtDuree.getText()));
        return id_cinema;
    }
     
    
    
    private void modifierFilm() {
        Film film= new Film(id_film);
        film.setNom_film(txtFilmmodif.getText());
        film.setSynopsis(txtSynopModif.getText());
        film.setDate_sortie(txtDateModif.getText());
        film.setDuree(TxtDureeModif.getText());
        Filmdao.update(film);   
        charger();
    }
     private void modifierCinema() {
        Cinema cinema = new Cinema(id_film);
        cinema.setAdresse(txtAdsModif.getText());
        cinema.setEmplacement(txtCinemaMod.getText());
        cinema.setNomSalle(txtSalleModif.getText());
        cinemaDao.update(cinema);   
        charger();
    }

    @FXML
    private void remplir(MouseEvent event) {
        TableView.TableViewFocusModel model = tab.getFocusModel();
        System.out.println(model.getFocusedItem());
        try {
               
        System.out.println(model.getFocusedItem());
        ProjectionUtil projectionutil= (ProjectionUtil)model.getFocusedItem();
        Film film = new Film(projectionutil.getId_film(), projectionutil.getSynopsis(),projectionutil.getDate_ajout(), projectionutil.getNom_film(),projectionutil.getDuree());
        Cinema cinema = new Cinema(projectionutil.getId_salle(),projectionutil.getAdresse(),projectionutil.getEmplacement(),projectionutil.getNom_salle());
        id_film= projectionutil.getId_film();
        txtCinemaMod.setText(cinema.getEmplacement());
        txtAdsModif.setText(cinema.getAdresse());
        txtSalleModif.setText(cinema.getNomSalle());
        id_cinema=projectionutil.getId_salle();
      //  Media media= new Media("Image", projectionutil.get)
        Projection projection= new Projection(projectionutil.getId_projection(),projectionutil.getDate_heure(), cinema, film);
         txtDateModif.setText(projection.getDate_Projection());
            //System.out.println(projectionDao.readById(projectionutil.getId_projection()).getDate_Projection());
         txtFilmmodif.setText(film.getNom_film());
         TxtDureeModif.setText(film.getDuree());
          txtSynopModif.setText(film.getSynopsis());
        // txtImageModif.setText();
        charger();
        }catch (Exception e) {        
        }
    }

    @FXML
    private void ajouterProjection(ActionEvent event) {
         int id_cinema= ajouterCinema();
        int id_film=ajouterFilm();
        int id_mediai= ajouterMedia();        
        int id_proj= projectionDao.create(new Projection(txtDate.getText(), cinemaDao.readById(id_cinema) , Filmdao.readById(id_film)));
        
        media_Par_ElementDao.create(id_mediai, id_film,id_proj);  
 
        txtCinemaMod.clear();
        txtAdsModif.clear();
        txtSalleModif.clear();
          txtDateModif.clear();
         txtFilmmodif.clear();
         txtSynopModif.clear();
         TxtDureeModif.clear();
        charger();
    }

   

    @FXML
    private void modifierProjection(ActionEvent event) {
        modifierCinema();
        modifierFilm();
         txtCinemaMod.clear();
        txtAdsModif.clear();
        txtSalleModif.clear();
          txtDateModif.clear();
         txtFilmmodif.clear();
         txtSynopModif.clear();
         TxtDureeModif.clear();
        charger();
    }

}
