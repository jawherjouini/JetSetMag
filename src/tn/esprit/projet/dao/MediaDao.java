/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.ObservableList;
import tn.esprit.projet.model.Film;
import tn.esprit.projet.model.Media;
import tn.esprit.projet.util.Connexion;

/**
 *
 * @author tasnim
 */
public class MediaDao implements IJetSet<Media>{

    
    public Connection connexion;
    public String req;
    //public Statement stmt;
    public ResultSet rs;
    public int resultat;
    PreparedStatement ps;
    
    @Override
    public int create(Media obj) {
        int id = 0;
 try {
                connexion = Connexion.getInstance();

                req = "INSERT INTO Media(type_media,url) VALUES (?,?)";
                ps = connexion.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, obj.getType_Media().trim());
                  ps.setString(2, obj.getURL().trim());
                  //System.out.println("aaaaaaaaaaaa");
                  //System.out.println(req);
                resultat = ps.executeUpdate();
//                ResultSet rs = ps.getGeneratedKeys();
//                int idAuto_increment = 0;
//                if( rs.next() ) {
//                idAuto_increment = rs.getInt(1);
//                }
                rs = ps.getGeneratedKeys();
                
                while(rs.next()){
                    id = rs.getInt(1);
                    System.out.println(id);
                }
                if (resultat != 0) {
                    System.out.println("Ajout réussi !!");
                }
            } catch (Exception e) {
                System.out.println("Ajout échoué: " + e.getMessage());
            }
            return id;
    }

    @Override
    public int update(Media obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Media obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Media> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Media readById(int id) {
         List<Media> medias = new ArrayList<Media>();
        try {
            connexion = Connexion.getInstance();
            req = "Select * from Media where id_media=?";

            ps = connexion.prepareStatement(req);
                        ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_Media = rs.getInt("id_media");
                String type_media = rs.getString("type_media");
                String url = rs.getString("url");
                //System.out.println(id_Media+" "+type_media+" "+url);
                medias.add(new Media(id_Media, type_media, url));
            }
            rs.close();

        } catch (Exception e) {
            System.out.println("Affichage impossible: " + e.getMessage());
        }
        // System.out.println(medias);
        return medias.get(0);  
    }
    
  
    
}
