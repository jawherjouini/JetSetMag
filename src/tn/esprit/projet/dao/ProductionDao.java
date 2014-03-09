/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import tn.esprit.projet.model.Media;
import tn.esprit.projet.model.Production;
import tn.esprit.projet.util.Connexion;
/**
 *
 * @author tasnim
 */
public class ProductionDao implements IJetSet<Production>{

    
    
    public Connection connexion;
    public String req;
    //public Statement stmt;
    public ResultSet rs;
    public int resultat;
    PreparedStatement ps;
    
    @Override
    public int create(Production obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Production obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Production obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Production> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Production readById(int id) {
          List<Production> prod = new ArrayList<Production>();
        try {
            connexion = Connexion.getInstance();
            req = "Select * from production where id_production=?";
            ps.setInt(1, id);
            ps = connexion.prepareStatement(req);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_Production = rs.getInt("id_production");
                String nom_production = rs.getString("nom_production");
                
                prod.add(new Production(id_Production,nom_production));
            }
            rs.close();

        } catch (Exception e) {
            System.out.println("Affichage impossible: " + e.getMessage());
        }
         System.out.println(prod);
        return prod.get(0);  
    }
    
}
