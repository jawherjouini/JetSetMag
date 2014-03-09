/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.projet.model.Film;
import tn.esprit.projet.model.Projection;

/**
 *
 * @author tasnim
 */
public class ProjectionUtilDao {
    
    public Connection connexion;
    public String req;
    //public Statement stmt;
    public ResultSet rs;
    public int resultat;
    PreparedStatement ps;
    
    public ObservableList<ProjectionUtil> read() {
        ObservableList<ProjectionUtil> projections = null;
        try {
            projections=FXCollections.observableArrayList();
            connexion = Connexion.getInstance();
            req = "SELECT f.id_film, f.date_sortie,f.synopsis, f.date_ajout, f.nom_film, f.duree,p.id_projection, p.date_heure,c.id_salle,c.adresse,c.emplacement,c.nom_salle FROM film f,projection p,cinema c WHERE f.id_film=p.id_film AND c.id_salle=p.id_salle";
            ps = connexion.prepareStatement(req);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProjectionUtil projection = new ProjectionUtil();
                projection.setId_film(rs.getInt(1));
                projection.setDate_sortie(rs.getString(2));
                projection.setSynopsis(rs.getString(3));               
                projection.setDate_ajout(rs.getDate(4));
                projection.setNom_film(rs.getString(5));
                projection.setDuree(rs.getString(6));
               projection.setId_projection(rs.getInt(7));
               projection.setDate_projection(rs.getString(8));
               projection.setId_salle(rs.getInt(9));
               projection.setAdresse(rs.getString(10));
               projection.setEmplacement(rs.getString(11));
               projection.setNom_salle(rs.getString(12));
               projections.add(projection);
            }
            rs.close();

        } catch (Exception e) {
            System.out.println("Affichage impossible: " + e.getMessage());
        }
        return projections;
    }

    
}
