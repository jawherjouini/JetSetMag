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
import tn.esprit.projet.model.Film;
import tn.esprit.projet.util.Connexion;

/**
 *
 * @author tasnim
 */
public class CinemaDao implements IJetSet<Cinema>{

    
      public Connection connexion;
    public String req;
    //public Statement stmt;
    public ResultSet rs;
    public int resultat;
    PreparedStatement ps;
    
    @Override
    public int create(Cinema obj) {
 int id=0;
        try {
                connexion = Connexion.getInstance();

                req = "INSERT INTO cinema (adresse,emplacement,nom_salle) VALUES (?,?,?)";
                ps = connexion.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
               
                ps.setString(1, obj.getAdresse());
                ps.setString(2, obj.getEmplacement());
              
                 ps.setString(3, obj.getNomSalle());
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
    public int update(Cinema obj) {
  try {
                connexion = Connexion.getInstance();
                req = "UPDATE cinema SET adresse=?,emplacement=?,nom_salle=? where id_salle=?;";
                ps = connexion.prepareStatement(req);
            
                ps.setString(1, obj.getAdresse());
                ps.setString(2, obj.getEmplacement());
                ps.setString(3, obj.getNomSalle());
                ps.setInt(4, obj.getId_Salle());
               
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
    public int delete(Cinema obj) {
        try {
            connexion = Connexion.getInstance();
            req = "DELETE FROM cinema WHERE id_salle=?";
            ps = connexion.prepareStatement(req);
            ps.setInt(1, obj.getId_Salle());
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
            req = "DELETE FROM cinema";
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
    public ObservableList<Cinema> read() {
        
     ObservableList<Cinema> cinemas = null;
        try {
            cinemas=FXCollections.observableArrayList();
            connexion = Connexion.getInstance();
            req = "Select * from cinema";
            ps = connexion.prepareStatement(req);
            rs = ps.executeQuery();
            while (rs.next()) {
                 Cinema a = new Cinema();
                a.setId_Salle(rs.getInt(1));
                a.setAdresse(rs.getString(2));
               
                a.setEmplacement(rs.getString(3));
                
                a.setNomSalle(rs.getString(4));
               
                cinemas.add(a);
            }
            rs.close();

        } catch (Exception e) {
            System.out.println("Affichage impossible: " + e.getMessage());
        }
        return cinemas ;
    }

    @Override
    public Cinema readById(int id) {
    Cinema cinema = new Cinema();
        try {
            
            connexion = Connexion.getInstance();
            req = "Select * from cinema where id_salle=?";
            ps = connexion.prepareStatement(req);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cinema a = new Cinema();
                a.setId_Salle(rs.getInt(1));
                a.setAdresse(rs.getString(2));
               
                a.setEmplacement(rs.getString(3));
                
                a.setNomSalle(rs.getString(4));
               
                cinema=a;
            }
            rs.close();

        } catch (Exception e) {
            System.out.println("Affichage impossible: " + e.getMessage());
        }
        return cinema ;    }

      
}
