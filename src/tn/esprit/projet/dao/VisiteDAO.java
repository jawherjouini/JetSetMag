/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.dao;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.projet.model.Article;
import tn.esprit.projet.model.Membre;
import tn.esprit.projet.model.Visite;
import tn.esprit.projet.util.Connexion;

/**
 *
 * @author acer
 */
public class VisiteDAO {
    
    public ObservableList<Visite> getNombrevisite() {
        Statement stmt;
        ObservableList<Visite> result = null;
        Connection cnx;
        ResultSet rs;
        try {
            result = FXCollections.observableArrayList();
            cnx = Connexion.getInstance();
            String query = "Select extract(month from date_entree), count(*) from visite group by extract(month from date_entree)";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
               Visite a = new Visite();
                        a.setMois(rs.getString(1));
                        a.setNbr_visiteurs(rs.getInt(2));
                       System.out.println(a.getMois()+a.getNbr_visiteurs()); 
                
                result.add(a);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }
        return result;
    }

    
}
