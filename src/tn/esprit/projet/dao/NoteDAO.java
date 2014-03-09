/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.projet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static org.omg.IOP.CodecPackage.InvalidTypeForEncodingHelper.id;
import tn.esprit.projet.model.Note;
import tn.esprit.projet.util.Connexion;

/**
 *
 * @author oukhay
 */
public class NoteDAO {

    public float getNoteById(int id) {

        Statement stmt;
        float result = 0;
        Connection cnx;
        ResultSet rs;
        try {

            cnx = Connexion.getInstance();
            String query = "Select avg (nbr_etoiles) from note where id_evenement=" + id + " OR id_article=" + id + " OR id_film=" + id + " OR id_projection=" + id;
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                result = rs.getFloat(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(NoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public boolean insererNote(String type, int note, int id_membre, int id_type) {
        Statement stmt;
        boolean result = false;
        Connection cnx;
        int rs;
        try {

            cnx = Connexion.getInstance();
            String query = "Insert into note  (id_membre,id_" + type + ",nbr_etoiles) values (" + id_membre + "," + id_type + "," + note + ")";
            stmt = cnx.createStatement();
            rs = stmt.executeUpdate(query);
            if (rs > 0) {
                result = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(NoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }

    public boolean verifierNote(int id_membre, String type, int id_type) {
        Statement stmt;
        boolean result = false;
        Connection cnx;
        ResultSet rs;
        try {

            cnx = Connexion.getInstance();
            String query = "select * from note where id_membre=" + id_membre + " and id_" + type + "=" + id_type;
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                result = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(NoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }

    public boolean Updatenote(String type, int note, int id_membre, int id_type) {
        Statement stmt;
        boolean result = false;
        Connection cnx;
        int rs;
        try {

            cnx = Connexion.getInstance();
            String query = "Update note set nbr_etoiles=" +note+ " where id_membre=" + id_membre + " and id_" + type + " = " + id_type;
            stmt = cnx.createStatement();
            rs = stmt.executeUpdate(query);
            if (rs > 0) {
                result = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(NoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

}
