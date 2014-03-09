/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.projet.main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tn.esprit.projet.util.*;

/**
 *
 * @author oukhay
 */
public class MainApp extends Application {
    
 
    //*****Administrateur*******//
    public static String g_commentaireID = "commentaire";
    public static String g_commentaireFile = "/tn/esprit/projet/view/admin/GestionCommentaire.fxml";
  
    public static String g_evenementID = "evenement";
    public static String g_evenementFile = "/tn/esprit/projet/view/admin/GestionEvenements.fxml";
  
    public static String g_membreID = "membre";
    public static String g_membreFile = "/tn/esprit/projet/view/admin/GestionMembre.fxml";
  
    public static String g_newsID = "news";
    public static String g_newsFile = "/tn/esprit/projet/view/admin/GestionNews.fxml";
  
    public static String g_sallecinemaID = "sallecinema";
    public static String g_sallecinemmaFile = "/tn/esprit/projet/view/admin/GestionSalleCinema.fxml";
  
    public static String g_gestionallID = "gestionall";
    public static String g_gestionallFile = "/tn/esprit/projet/view/admin/GestionAll.fxml";

    public static String g_statistiqueID = "statistique";
    public static String g_statistiqueFile = "/tn/esprit/projet/view/admin/Statistique.fxml";
  
    public static String g_filmID = "film";
    public static String g_filmFile = "/tn/esprit/projet/view/admin/GestionFilm.fxml";
  
    public static String g_projectionID = "projection";
    public static String g_projectionFile = "/tn/esprit/projet/view/admin/GestionProjection.fxml";
  
   //************Client************************//
    
    public static String c_newsID = "news";
    public static String c_newsFile =  "/tn/esprit/projet/view/client/News.fxml";
    
    public static String c_paccueilID = "consulterpaccueil";
    public static String c_paccueilFile =  "/tn/esprit/projet/view/client/ConsulterPAccueil.fxml";
    
    public static String c_boxofficeID = "boxoffice";
    public static String c_boxofficeFile =  "/tn/esprit/projet/view/client/BoxOffice.fxml";
    
    public static String c_regarderfilmID = "regarderfilm";
    public static String c_regarderfilmFile =  "/tn/esprit/projet/view/client/RegarderFilm.fxml";
    
    
    
    public static String c_notercommenterID = "notercommenter";
    public static String c_notercommenterFile= "/tn/esprit/projet/view/client/CommentNote.fxml";
    
    
    
    public static String screen1ID = "Accueil";
    public static String screen1File = "/tn/esprit/projet/view/client/Accueil.fxml";
    public static String screen2ID = "login";
    public static String screen2File = "/tn/esprit/projet/view/client/login.fxml";
  
    public static String screen4ID = "map";
    public static String screen4File = "/tn/esprit/projet/view/client/Map.fxml";
    public static String screen5ID = "profil";
    public static String screen5File = "/tn/esprit/projet/view/client/AccueilClient.fxml";
    public static String screen9ID = "Accueilprofil";
    public static String screen9File = "/tn/esprit/projet/view/client/Accueilprofil.fxml";
    public static String screen6ID = "inscription";
    public static String screen6File = "/tn/esprit/projet/view/client/inscription.fxml";
    public static String screen7File = "/tn/esprit/projet/view/client/soiree.fxml";
    public static String screen7ID = "soiree";
    public static String screen8File = "/tn/esprit/projet/view/client/CommentNote.fxml";
    public static String screen8ID = "CommentNote";
    public static String screen10File = "/tn/esprit/projet/view/client/ConsulterArticle.fxml";
    public static String screen10ID = "ConsulterArticle";
 
    public static String screen12File = "/tn/esprit/projet/view/client/InterfacedesProjections.fxml";
    public static String screen12ID = "InterfacesProjections";
    

    
       public static ScreensController  mainCantainer;
    

    @Override
    public void start(Stage primaryStage) {

         mainCantainer = new ScreensController();
         mainCantainer.loadscreen(screen1ID, screen1File);
         mainCantainer.loadscreen(g_gestionallID, g_gestionallFile);
     mainCantainer.loadscreen(screen2ID, screen2File);
     // mainCantainer.loadscreen(screen3ID, screen3File);
//   //    mainCantainer.loadscreen(screen4ID, screen4File);
mainCantainer.loadscreen(screen5ID, screen5File);
mainCantainer.loadscreen(screen7ID, screen7File);
//       mainCantainer.loadscreen(screen10ID, screen10File);
       
     //  mainCantainer.loadscreen(g_gestionallID,g_gestionallFile);
     //  mainCantainer.loadscreen(g_sallecinemaID,g_sallecinemmaFile);
       
     mainCantainer.loadscreen(screen1ID, screen1File);
 
        mainCantainer.setScreen(MainApp.screen1ID);
        Group root = new Group();
        root.getChildren().addAll(mainCantainer);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
