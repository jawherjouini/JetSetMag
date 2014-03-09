package tn.esprit.projet.controler;

import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import tn.esprit.projet.main.MainApp;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.GraphReaderExample;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author Jawher
 */
public class InscriptionController implements Initializable, ControlledScreen {

    ScreensController screencontroller;
    @FXML
    private Button btn;

    public static String API_KEY = "499327573449818";
    public static String SECRET = "9f70757512e49e4262d7e8df08dbc5b8";

    public static String firstRequest = "https://graph.facebook.com/oauth/authorize?"
            + "client_id="
            + API_KEY
            + "&redirect_uri=http://www.facebook.com/connect/login_success.html&"
            + "scope=publish_stream,offline_access,create_event,read_stream,email,user_birthday";

    public static String secondRequest = "https://graph.facebook.com/oauth/access_token?"
            + "client_id="
            + API_KEY
            + "&redirect_uri=http://www.facebook.com/connect/login_success.html&"
            + "client_secret=" + SECRET + "&code=";

    public static String access_token = "";
    public static boolean firstRequestDone = false;
    public static boolean secondRequestDone = false;
    @FXML
    private WebView wv;
    WebEngine webEngine;
    Label message = new Label("A confirmation email has been sent to your email address with the password to your account in JetSet Mag App");
    @FXML
    private AnchorPane ap;

    int i = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
     
        loadFbPage();
    }

    @FXML
    private void RetrieveInformation(ActionEvent event) {
        String tmp = "CAAHGIsKkXFoBAHVyfbqSVlL2PVDcxHBugDD5KzXrjskySYT1uAXJuzhK8R8g3Wb2hPZAYKXoZC0XvhIeXcI5ykfJNHiZCOEZB8fvwUO1kZC51HDDjhqjfKri2dbbDIha02EH7lVl1kVZAmGSAgMw7LHdwk4xNVd1pyCjryNTPraKJIwrMLS7j2";
        if (access_token.length() != tmp.length()) {

            try {
              
                    new GraphReaderExample(access_token).runEverything();
                    System.out.println("ffffffffffffffffffffffffffffffffffffffff=>");
                    ap.getChildren().remove(wv);
                    message.setStyle("-fx-text-fill:white;");
                    System.out.println("sssssssssssssssssssssssssssssssssssssssss=>");
                    ap.getChildren().add(message);
                  
                 
                }
            catch (Exception e) {
                ap.getChildren().remove(wv);
                System.out.println("erreur en récupérant les infos: " + e.getMessage());
                message.setText("Erreur lors de l'inscription !");
                ap.getChildren().add(message);
            }

        } 

}

@Override
        public void SetScreenParent(ScreensController screenpage) {
        screencontroller = screenpage;
    }

    public void loadFbPage() {
        webEngine = wv.getEngine();
        webEngine.load(firstRequest);
        webEngine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<Worker.State>() {
                    @Override
        public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
                        if (newState == Worker.State.SUCCEEDED) {
                            if (webEngine.getLocation().contains("http://www.facebook.com/connect/login_success.html?code=")) {
                                String[] splits = webEngine.getLocation().split("=");
                                String stage2temp = secondRequest + splits[1];
                                webEngine.load(stage2temp);
                                firstRequestDone = true;
                            } else {
                                if (!secondRequestDone) {
                                    String html = (String) webEngine.executeScript("document.documentElement.innerHTML");
                                    StringReader readerSTR = new StringReader(html);
                                    HTMLEditorKit.ParserCallback callback
                                    = new HTMLEditorKit.ParserCallback() {
                                        @Override
        public void handleText(char[] data, int pos) {
                                            try {
                                                String string = new String(data);
                                                String[] temp1 = string.split("&");
                                                String[] temp2 = temp1[0].split("=");
                                                System.out.println("Access token=" + temp2[1]);
                                                access_token = temp2[1];
                                                webEngine.load("http://www.facebook.com");
                                            } catch (Exception e) {
                                                System.out.println("erreur facebook: " + e.getMessage());
                                            }
                                        }
                                    };
                                    try {
                                        new ParserDelegator().parse(readerSTR, callback, false);
                                    } catch (IOException e1) {
                                        e1.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                });

    }

    @FXML
        private void goToHome(MouseEvent event) {

        screencontroller.setScreen(MainApp.screen1ID);
    }
}
