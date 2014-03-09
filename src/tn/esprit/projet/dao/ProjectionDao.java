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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.projet.model.Cinema;
import tn.esprit.projet.model.Projection;
import tn.esprit.projet.util.Connexion;

/**
 *
 * @author tasnim
 */
public class ProjectionDao implements IJetSet<Projection>{

    
    public Connection connexion;
    public String req;
    public ResultSet rs;
    public int resultat;
    PreparedStatement ps;
    
    @Override
    public int create(Projection obj) {
         int id=0;
        try {
                connexion = Connexion.getInstance();

                req = "INSERT INTO projection (id_film,id_salle,date_heure) VALUES (?,?,?)";
                ps = connexion.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
               
                ps.setInt(1, obj.getFilm().getId_film());
                System.out.println(":"+obj.getFilm().getId_film()+":");
                System.out.println(":"+obj.getCinemas().getId_Salle()+":");
                ps.setInt(2, obj.getCinemas().getId_Salle());
                ps.setString(3, obj.getDate_Projection());
                  System.out.println("aaaaaaaaaaaa");
                  System.out.println(req);
                resultat = ps.executeUpdate();
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
    public int update(Projection obj) {
            try {
                connexion = Connexion.getInstance();
                req = "UPDATE projection SET id_film=?,id_salle=?,date_heure=? where id_projection=?;";
                ps = connexion.prepareStatement(req);
            
                ps.setInt(1, obj.getFilm().getId_film());
                ps.setInt(2, obj.getCinemas().getId_Salle());
                ps.setString(3, obj.getDate_Projection());
                ps.setInt(4, obj.getId_projection());
               
                resultat = ps.executeUpdate();
                if (resultat != 0) {
                    System.out.println("Ajout réussi !!");
                }
            } catch (Exception e) {
                System.out.println("Modification échoué: " + e.getMessage());
            }
            return resultat;
    
    }

    @Override
    public int delete(Projection obj) {
            try {
            connexion = Connexion.getInstance();
            req = "DELETE FROM projection WHERE id_projection=?";
            ps = connexion.prepareStatement(req);
            ps.setInt(1, obj.getId_projection());
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
            req = "DELETE FROM projection";
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
    public ObservableList<Projection> read() {
         ObservableList<Projection> projections = null;
        try {
            projections=FXCollections.observableArrayList();
            connexion = Connexion.getInstance();
            req = "Select * from projection";
            ps = connexion.prepareStatement(req);
            rs = ps.executeQuery();
            while (rs.next()) {
                Projection a = new Projection();
              
                CinemaDao cinemaDao = new CinemaDao();
                FilmDao filmDao = new FilmDao();
                
                a.setId_projection(rs.getInt(1));
               a.setFilm(filmDao.readById(rs.getShort(2)));
                a.setCinemas(cinemaDao.readById(rs.getInt(3)));
               
               
                projections.add(a);
            }
            rs.close();

        } catch (Exception e) {
           // System.out.println("Affichage impossible: " + e.getMessage());
        }
        return projections ;
    }

    @Override
    public Projection readById(int id) {
        Projection projection= new Projection();

        try {
            connexion = Connexion.getInstance();
            req = "Select * from projection where id_projection=?";
            ps.setInt(1, id);
            ps = connexion.prepareStatement(req);
            rs = ps.executeQuery();
            while (rs.next()) {
                Projection a = new Projection();
              
                CinemaDao cinemaDao = new CinemaDao();
                FilmDao filmDao = new FilmDao();
                
                a.setId_projection(rs.getInt(1));
               a.setFilm(filmDao.readById(rs.getShort(2)));
                a.setCinemas(cinemaDao.readById(rs.getInt(3)));
                              
               projection=a;
            }
            rs.close();

        } catch (Exception e) {
            //System.out.println("Affichage impossible: " + e.getMessage());
        }
        return projection ;    }
    
    
}
