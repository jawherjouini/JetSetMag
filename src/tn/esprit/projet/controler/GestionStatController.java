
package tn.esprit.projet.controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import tn.esprit.projet.dao.RubriqueDAO;
import tn.esprit.projet.dao.VisiteDAO;
import tn.esprit.projet.model.Rubrique;
import tn.esprit.projet.model.Visite;
import tn.esprit.projet.util.ControlledScreen;
import tn.esprit.projet.util.ScreensController;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class GestionStatController implements Initializable ,ControlledScreen {
   
    final  CategoryAxis xAxis = new CategoryAxis();
        final CategoryAxis yAxis = new CategoryAxis();
        VisiteDAO a = new VisiteDAO();
        RubriqueDAO b = new RubriqueDAO();
        String Mm="";
   
    @FXML
    private Button visite;
    private ScreensController screencontroller;
    
    @FXML
    private LineChart<String,  String> linechart;
       XYChart.Series series ;
    @FXML
    private PieChart pie;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
      
    }    

    @Override
    public void SetScreenParent(ScreensController screenpage) {
        screencontroller=screenpage;
    }

        private void appercu(ActionEvent event) {
     
       
          
    }

    @FXML
    private void visiteapplication(ActionEvent event) {
        
      
       linechart.setTitle("Nombre de visites par mois");
      
       ObservableList<Visite> items = a.getNombrevisite();
        System.out.println(items);
       xAxis.setLabel("Mois");
       yAxis.setLabel("Nombres de visite");
      
        ObservableList<XYChart.Series<String, String>> lineChartData = FXCollections.observableArrayList();
        
        LineChart.Series<String,  String> series1 = new LineChart.Series<String, String>();
        series1.setName("2014");
       for (int i=0;i<items.size();i++){
           
           
            String y=String.valueOf(items.get(i).getNbr_visiteurs());
              int x=Integer.parseInt(items.get(i).getMois());
              System.out.println(y);
              String [] Mois ={ "Janvier","Fevriér","Mars","Avril","Mai","juin","juillet","aout","September","October","Novembre"};
              if(x!=0){
               Mm =Mois[x-1];
             }
                  series1.getData().add(new XYChart.Data<String,  String>(Mm, y));
                  
       }
      
    
//        series1.getData().add(new XYChart.Data<Number, Number>(2, 5));
//        series1.getData().add(new XYChart.Data<Number, Number>(6, 9));
//        series1.getData().add(new XYChart.Data<Number, Number>(12, 7));
//        series1.getData().add(new XYChart.Data<Number, Number>(13, 4));
        
        lineChartData.add(series1);
//        
//        LineChart.Series<Double, Double> series2 = new LineChart.Series<Double, Double>();
//        series2.setName("Series 2");
//        series2.getData().add(new XYChart.Data<Double, Double>(0.0, 1.6));
//        series2.getData().add(new XYChart.Data<Double, Double>(0.8, 0.4));
//        series2.getData().add(new XYChart.Data<Double, Double>(1.4, 2.9));
//        series2.getData().add(new XYChart.Data<Double, Double>(2.1, 1.3));
//        series2.getData().add(new XYChart.Data<Double, Double>(2.6, 0.9));
//        
//        lineChartData.add(series2);
//        
        linechart.setData(lineChartData);
        linechart.createSymbolsProperty();
    }

    @FXML
    private void Visiterubrique(ActionEvent event) {
         ObservableList<PieChart.Data> po =
               
                FXCollections.observableArrayList();
           pie.setData(po);
          ObservableList<Rubrique> items = b.getNombrevisite();
                 for (int i=0;i<items.size();i++){
          System.out.println(items.get(i).getNombre_visite());}
          
         ObservableList<PieChart.Data> piu =
                FXCollections.observableArrayList(
                new PieChart.Data("Box Office", items.get(0).getNombre_visite()),
                new PieChart.Data("News", items.get(1).getNombre_visite()),
                new PieChart.Data("Concert", items.get(2).getNombre_visite()),
                new PieChart.Data("Théâtre", items.get(3).getNombre_visite()),
                new PieChart.Data("Projection", items.get(4).getNombre_visite()),
                new PieChart.Data("Sorties", items.get(5).getNombre_visite()),
                new PieChart.Data("Soirées", items.get(6).getNombre_visite()));
         pie.getData().addAll(piu);
    }
      
}
