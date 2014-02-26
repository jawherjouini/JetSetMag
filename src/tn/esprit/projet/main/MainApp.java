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
   boolean trouve;

    public static String screen1ID = "Accueil";
    public static String screen1File = "/tn/esprit/projet/view/client/Accueil.fxml";
    public static String screen2ID = "login";
    public static String screen2File = "/tn/esprit/projet/view/client/login.fxml";

    @Override
    public void start(Stage primaryStage) {

        ScreensController mainCantainer = new ScreensController();
        mainCantainer.loadscreen(screen1ID, screen1File);
        mainCantainer.loadscreen(screen2ID, screen2File);
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
