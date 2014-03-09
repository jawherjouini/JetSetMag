/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.projet.controler;

import com.sun.scenario.effect.impl.Renderer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import tn.esprit.projet.dao.MembreDao;
import tn.esprit.projet.main.MainApp;
import tn.esprit.projet.model.Membre;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author Jawher
 */
public class loginController implements Initializable, ControlledScreen {

    public static Membre membre = null;
    MembreDao cdao = new MembreDao();
    ScreensController screencontroller;
    @FXML
    private Button btn;
    @FXML
    private TextField tfuser;
    @FXML
    private PasswordField tfpassword;
    @FXML
    private Label verif;
    @FXML
    private ImageView logo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void processLogin(ActionEvent event) {
        membre = cdao.FindMembreById(tfuser.getText(), tfpassword.getText());

        if (membre != null) {
            if (membre.isIsAdministrateur()) {
                screencontroller.setScreen(MainApp.g_gestionallID);

            } else {
                AccueilController.page=5;
                MainApp.mainCantainer.loadscreen(MainApp.screen5ID, MainApp.screen5File);
                screencontroller.setScreen(MainApp.screen5ID);
            }
        } else {
            verif.setText("Username or password is incorrect !!!!");
        }

    }

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        screencontroller = screenpage;
    }

    @FXML
    private void goToHome(MouseEvent event) {
        screencontroller.setScreen(MainApp.screen1ID);
    }

}
