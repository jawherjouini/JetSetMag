
package tn.esprit.projet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.projet.controler.loginController;
import tn.esprit.projet.model.Evenement;
import tn.esprit.projet.util.Connexion;

/**
 *
 * @author Chaker
 */
public class EvenementDAO {
    
    public ObservableList<Evenement> ListerBonsPlans() {
        Statement stmt;
        ObservableList<Evenement> result = null;
        Connection cnx;
        ResultSet rs;
        try {
            
            result = FXCollections.observableArrayList();
            cnx = Connexion.getInstance();
            String query = "SELECT * FROM evenement WHERE bon_plan=TRUE ORDER BY date_deb_event LIMIT 6";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Evenement e = new Evenement();
                e.setId_evenement(rs.getInt("id_evenement"));
                e.setTitre_event(rs.getString("titre_event"));
                e.setBon_plan(rs.getBoolean("bon_plan"));
                e.setDate_deb_event(rs.getString("date_deb_event"));
                e.setDate_fin_event(rs.getString("date_fin_event"));
                e.setType_event(rs.getString("type_event"));
                e.setDescription(rs.getString("description"));
                
                result.add(e);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }
        return result;
    }
    
    
    public ObservableList<Evenement> ListerEvenements() {
        Statement stmt;
        ObservableList<Evenement> result = null;
        Connection cnx;
        ResultSet rs;
        try {
            
            result = FXCollections.observableArrayList();
            cnx = Connexion.getInstance();
            String query = "Select * from evenement";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Evenement e = new Evenement();
                e.setId_evenement(rs.getInt("id_evenement"));
                e.setTitre_event(rs.getString("titre_event"));
                e.setBon_plan(rs.getBoolean("bon_plan"));
                e.setDate_deb_event(rs.getString("date_deb_event"));
                e.setDate_fin_event(rs.getString("date_fin_event"));
                e.setType_event(rs.getString("type_event"));
                e.setDescription(rs.getString("description"));
                
                result.add(e);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }
        return result;
    }
    
    public ObservableList<Evenement> ListerEvenementsByType(String type) {
        Statement stmt;
        ObservableList<Evenement> result = null;
        Connection cnx;
        ResultSet rs;
        try {
            
            result = FXCollections.observableArrayList();
            cnx = Connexion.getInstance();
            String query = "Select * from evenement where type_event='"+type+"'";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Evenement e = new Evenement();
                e.setId_evenement(rs.getInt("id_evenement"));
                e.setTitre_event(rs.getString("titre_event"));
                e.setDate_deb_event(rs.getString("date_deb_event"));
                e.setDate_fin_event(rs.getString("date_fin_event"));
                e.setDescription(rs.getString("description"));
                
                result.add(e);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }
        return result;
    }
    
    public ObservableList<Evenement> ListerEvenementsByTitre(String titre) {
        Statement stmt;
        ObservableList<Evenement> result = null;
        Connection cnx;
        ResultSet rs;
        try {
            
            result = FXCollections.observableArrayList();
            cnx = Connexion.getInstance();
            String query = "Select * from evenement where titre_event='"+titre+"'";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Evenement e = new Evenement();
                e.setId_evenement(rs.getInt("id_evenement"));
                e.setTitre_event(rs.getString("titre_event"));
                e.setDate_deb_event(rs.getString("date_deb_event"));
                e.setDate_fin_event(rs.getString("date_fin_event"));
                e.setDescription(rs.getString("description"));
                
                result.add(e);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }
        return result;
    }
    
    public void ajouterEvenement(Evenement evenement){
        Statement stmt;
        ObservableList<Evenement> result = null;
        Connection cnx;
        try{
            int bp = evenement.isBon_plan() ? 1 : 0;
            cnx = Connexion.getInstance();
            String query = "INSERT INTO evenement "
                    + "(date_deb_event, date_fin_event, type_event, bon_plan, "
                    + "titre_event, description) "
                    + "VALUES ('"+evenement.getDate_deb_event()+"','"
                    + evenement.getDate_fin_event()+"','"
                    + evenement.getType_event()+"',"
                    + bp +",'"
                    + evenement.getTitre_event()+"','"
                    + evenement.getDescription()+"');";
            stmt = cnx.createStatement();
            int rs = stmt.executeUpdate(query);
        } catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());        }
    }
    
    public void supprimerTous(){
        Statement stmt;
        Connection cnx;
        try{
            cnx = Connexion.getInstance();
            String query = "DELETE * FROM EVENEMENT";
            System.out.println(query);
            stmt = cnx.createStatement();
            int executeUpdate = stmt.executeUpdate(query);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimerEvenement(int id){
        Statement stmt;
        Connection cnx;
        int result;
        try{
            cnx = Connexion.getInstance();
            String query = "DELETE FROM evenement WHERE id_evenement="+id;
            stmt = cnx.createStatement();
            
            result = stmt.executeUpdate(query);
            if (result>0){
                System.out.println("Suppression réussie");
            }
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Suppression impossible: " + ex.getMessage());
        }
    }
    
    public void modifierEvenement(Evenement evenement){
        Statement stmt;
        Connection cnx;
        int bp = evenement.isBon_plan() ? 1 : 0;
        String query = "UPDATE evenement SET "
                + "titre_event='"+evenement.getTitre_event()
                + "', date_deb_event= '"
                    +evenement.getDate_deb_event().toString()
                + "', date_fin_event= '"
                    +evenement.getDate_fin_event().toString()
                + "', type_event= '"+evenement.getType_event()
                + "', description= '"+evenement.getDescription()
                + "', bon_plan= "+ bp
                + " WHERE id_evenement= "+evenement.getId_evenement()+" ;";
        try {
            cnx = Connexion.getInstance();
            stmt = cnx.createStatement();
            int rs = stmt.executeUpdate(query);
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
     public ObservableList<Evenement> findEventsByID(){
        Statement stmt;
        ObservableList<Evenement> result = null;
        Connection cnx;
        ResultSet rs;
        try {
            
            result = FXCollections.observableArrayList();
            cnx = Connexion.getInstance();
            String query = "Select * from evenement where id_membre="+loginController.membre.getId_membre();
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Evenement e = new Evenement();
                e.setId_evenement(rs.getInt("id_evenement"));
                e.setTitre_event(rs.getString("titre_event"));
                e.setBon_plan(rs.getBoolean("bon_plan"));
                e.setDate_deb_event(rs.getString("date_deb_event"));
                e.setDate_fin_event(rs.getString("date_fin_event"));
                e.setType_event(rs.getString("type_event"));
                e.setDescription(rs.getString("description"));
                result.add(e);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }
        return result;
        
    }
    
}

