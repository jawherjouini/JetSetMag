/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.projet.model.Article;
import tn.esprit.projet.model.Film;
import tn.esprit.projet.model.Production;
import tn.esprit.projet.util.Connexion;

/**
 *
 * @author tasnim
 */
public class FilmDao implements IJetSet<Film>{

    public Connection connexion;
    public String req;
    //public Statement stmt;
    public ResultSet rs;
    public int resultat;
    PreparedStatement ps;
    
    
    @Override
    public int create(Film obj) {
        int id=0;
        try {
                connexion = Connexion.getInstance();

                req = "INSERT INTO film(Date_Sortie,Synopsis,nom_film,duree) VALUES (?,?,?,?)";
                ps = connexion.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
               
                ps.setString(1, obj.getDate_sortie());
                ps.setString(2, obj.getSynopsis());
              
                 ps.setString(3, obj.getDuree());
                  ps.setString(4, obj.getTitre());
                  //System.out.println("aaaaaaaaaaaa");
                  //System.out.println(req);
                resultat = ps.executeUpdate();
                rs = ps.getGeneratedKeys();
                
                while(rs.next()){
                    id = rs.getInt(1);
                    //System.out.println(id);
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
    public int update(Film obj) {
         
        try {
                connexion = Connexion.getInstance();
                req = "UPDATE film SET Date_Sortie=?,Synopsis=?, nom_film=? , duree=? where Id_Film=?;";
                ps = connexion.prepareStatement(req);
                ps.setInt(5, obj.getId_film());
                ps.setString(1, obj.getDate_sortie());
                ps.setString(2, obj.getSynopsis());
                ps.setString(3, obj.getTitre());
                ps.setString(4, obj.getDuree().trim());
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
    public int delete(Film obj) {
          try {
            connexion = Connexion.getInstance();
            req = "DELETE FROM film WHERE Id_Film=?";
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
            req = "DELETE FROM film";
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
    public ObservableList<Film> read() {
        ObservableList<Film> films = null;
        try {
            films=FXCollections.observableArrayList();
            connexion = Connexion.getInstance();
            req = "Select * from film";
            ps = connexion.prepareStatement(req);
            rs = ps.executeQuery();
            while (rs.next()) {
                 Film a = new Film();
                a.setId_film(rs.getInt(1));
                a.setDate_sortie(rs.getString(2));
           
                a.setSynopsis(rs.getString(4));
                
                a.setDate_ajout(rs.getDate(5));
                a.setTitre(rs.getString(6));
                a.setDuree(rs.getString(7));
                films.add(a);
//                int id_Film = rs.getInt("id_Film");
//                int id_production = rs.getInt("id_production");
//                String Date_Sortie = rs.getString("Date_Sortie");
//                String Synopsis = rs.getString("Synopsis");
//                Date Date_Ajout = rs.getDate("Date_Ajout");
//                String Titre = rs.getString("nom_film");
//                String Duree = rs.getString("duree");
//                ProductionDao productionDao = new ProductionDao();
//                films.add(new Film(id_Film , Date_Sortie,/*productionDao.readById(id_production)*/null,Synopsis, Date_Ajout,Titre,Duree));
            }
            rs.close();

        } catch (Exception e) {
            System.out.println("Affichage impossible: " + e.getMessage());
        }
        return films;
    }

    @Override
    public Film readById(int id) {
        Film film = new Film();
        try {
             connexion = Connexion.getInstance();
            req = "Select * FROM film WHERE Id_Film=?";
            ps = connexion.prepareStatement(req);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
        
         
            while (rs.next()) {
                
                 Film a = new Film();
                a.setId_film(rs.getInt(1));
                a.setDate_sortie(rs.getString(2));
              
                a.setSynopsis(rs.getString(4));
                
                a.setDate_ajout(rs.getDate(5));
                a.setTitre(rs.getString(6));
                a.setDuree(rs.getString(7));
               film=a;
            }
            rs.close();

        } catch (Exception e) {
            System.out.println("Affichage impossible: " + e.getMessage());
        }
       // System.out.println(film);
        return film;    
    }  
}
