
package tn.esprit.projet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.projet.model.Rubrique;


import tn.esprit.projet.util.Connexion;

/**
 *
 * @author acer
 */
public class RubriqueDAO {

    public ObservableList<Rubrique> getNombrevisite() {
        Statement stmt;
        ObservableList<Rubrique> result = null;
        Connection cnx;
        ResultSet rs;
        try {
            result = FXCollections.observableArrayList();
            cnx = Connexion.getInstance();
            String query = "Select * From Rubriquestat ";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
               Rubrique a = new Rubrique();
                    
                     a.setRubrique(rs.getString(2));
                      a.setNombre_visite(rs.getInt(3));
                      // System.out.println(a.getMois()+a.getNbr_visiteurs()); 
                
                result.add(a);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }
        return result;
    }

    
}

    

