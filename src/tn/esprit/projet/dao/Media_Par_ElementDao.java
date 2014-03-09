/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.projet.model.Film;
import tn.esprit.projet.model.Media;
import tn.esprit.projet.model.Media_Par_Element;
import tn.esprit.projet.util.Connexion;

/**
 *
 * @author tasnim
 */
public class Media_Par_ElementDao implements IJetSet<Media_Par_Element>{

        
    public Connection connexion;
    public String req;
    //public Statement stmt;
    public ResultSet rs;
    public int resultat;
    PreparedStatement ps;
    

    public int create(int media, int film) {
        try {
           
            connexion = Connexion.getInstance();          
                req = "INSERT INTO Media_Par_Element(id_media,id_film) VALUES (?,?)";
                ps = connexion.prepareStatement(req);
                ps.setInt(1, media);
                  ps.setInt(2, film);
                  System.out.println("aaaaaaaaaaaa");
                  System.out.println(req);
                resultat = ps.executeUpdate();
                if (resultat != 0) {
                    System.out.println("Ajout réussi !!");
                }
            } catch (Exception e) {
                System.out.println("Ajout échoué: " + e.getMessage());
            }
            return resultat;
    }

    
     public int create(int media, int film,int projection) {
        try {
           
            connexion = Connexion.getInstance();
            
           
                req = "INSERT INTO Media_Par_Element(id_media,id_film,id_projection) VALUES (?,?,?)";
                ps = connexion.prepareStatement(req);
                ps.setInt(1, media);
                  ps.setInt(2, film);
                  ps.setInt(3, projection);
                  System.out.println("aaaaaaaaaaaa");
                  System.out.println(req);
                resultat = ps.executeUpdate();
                if (resultat != 0) {
                    System.out.println("Ajout réussi !!");
                }
            } catch (Exception e) {
                System.out.println("Ajout échoué: " + e.getMessage());
            }
            return resultat;
    }

    @Override
    public int update(Media_Par_Element obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Media_Par_Element obj) {
          try {
            connexion = Connexion.getInstance();
            req = "DELETE FROM Media_Par_Element WHERE Id_Media_Page=?";
            ps = connexion.prepareStatement(req);
            ps.setInt(1, obj.getId_Media_Page());
            resultat = ps.executeUpdate();
            if (resultat != 0) {
                System.out.println("suppression réussite !!");
            }
        } catch (Exception e) {
            System.out.println("suppression échouée: " + e.getMessage());
        }
        return resultat;
    }
    
    public int deleteByFilm(Film obj) {
          try {
            connexion = Connexion.getInstance();
            req = "DELETE FROM Media_Par_Element WHERE Id_Film=?";
            ps = connexion.prepareStatement(req);
            ps.setInt(1, obj.getId_film());
            resultat = ps.executeUpdate();
            if (resultat != 0) {
                System.out.println("suppression réussite !!");
            }
        } catch (Exception e) {
            System.out.println("suppression échouée: " + e.getMessage());
        }
        return resultat;
    }
public int deleteAll() {
          try {
            connexion = Connexion.getInstance();
            req = "DELETE FROM Media_Par_Element";
            ps = connexion.prepareStatement(req);

            resultat = ps.executeUpdate();
            if (resultat != 0) {
                System.out.println("suppression réussite !!");
            }
        } catch (Exception e) {
            System.out.println("suppression échouée: " + e.getMessage());
        }
        return resultat;
}

    @Override
    public ObservableList<Media_Par_Element> read() {
           ObservableList<Media_Par_Element> medias = null;
        try {
            medias=FXCollections.observableArrayList();
            connexion = Connexion.getInstance();
            req = "Select * from Media_Par_Element";
            ps = connexion.prepareStatement(req);
            rs = ps.executeQuery();
            while (rs.next()) {
                Media_Par_Element media_Par_Element= new Media_Par_Element();
                MediaDao mediaDao = new MediaDao();
                FilmDao filmDao = new FilmDao();
                ProjectionDao projectionDao = new ProjectionDao();
                media_Par_Element.setId_Media_Page(rs.getInt(1));
                media_Par_Element.setMedia(mediaDao.readById(rs.getInt(2)));
                media_Par_Element.setFilm(filmDao.readById(rs.getInt(4))); 
                media_Par_Element.setProjection(projectionDao.readById(rs.getInt(6))); 
                Film film = new Film();
                film= filmDao.readById(rs.getInt(3));
                Media media = new Media();
                media = mediaDao.readById(rs.getInt(2));
                medias.add(media_Par_Element);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("Affichage impossible: " + e.getMessage());
        }
        return medias;
    }

    @Override
    public Media_Par_Element readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int create(Media_Par_Element obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
