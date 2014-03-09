
package tn.esprit.projet.dao;

import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.projet.util.Connexion;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author Jawher
 */
public class CommonDAO {

    Statement stmt;
    Connection cnx;
    ResultSet rs;

    public ObservableList<Object[]> finAll(String tablename) {
        ObservableList<Object[]> liste = FXCollections.observableArrayList();
        Object[] row;
        try {
            cnx = Connexion.getInstance();
            stmt = cnx.createStatement();
            String req = "Select * from " + tablename;
            rs = stmt.executeQuery(req);
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                row = new Object[rsmd.getColumnCount()];
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row[i - 1] = rs.getObject(i);
                }
                liste.add(row);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }
        return liste;

    }

    public List<String> ColonneName(String nomtable) {
        ArrayList<String> nom = new ArrayList<>();
        try {
            cnx = Connexion.getInstance();
            Statement stm = cnx.createStatement();
            ResultSet res;
            res = stm.executeQuery("select * from " + nomtable);
            ResultSetMetaData rsMd = res.getMetaData();
            for (int i = 1; i <= rsMd.getColumnCount(); i++) {
                nom.add(rsMd.getColumnName(i).toString());
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Listage de colonnes impossible: " + e.getMessage());
        }
        return nom;
    }

    public void genererRapport(String table) {
        try {
            cnx = Connexion.getInstance();
            System.out.println(new File("").getAbsolutePath()+"\\tn\\esprit\\projet\\media\\jrxml\\"+table+".jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(new File("").getAbsolutePath()+"\\tn\\esprit\\projet\\media\\jrxml\\"+table+".jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            // - Paramètres à envoyer au rapport
            Map parameters = new HashMap();
            parameters.put("Title", "Title");
            // - Execution du rapport
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, cnx);
            // - Création du rapport au format PDF
            new File("C:\\JetSetMag_Report\\").mkdirs();
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\JetSetMag_Report\\"+table+"Report.pdf");
        } catch (JRException | SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
