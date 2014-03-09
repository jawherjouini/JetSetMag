/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.projet.dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.mail.MessagingException;
import tn.esprit.projet.model.Article;
import tn.esprit.projet.model.Membre;
import tn.esprit.projet.util.Connexion;
import tn.esprit.projet.util.MailClass;

/**
 *
 * @author acer
 */
public class MembreDao {

    String s = "";

    public int authentification(String username, String pass) {
        Statement stmt;
        int result = 0;
        Connection cnx;
        ResultSet rs;
        String password = encryptPassword(pass);
        try {
            cnx = Connexion.getInstance();
            String query = "Select * from membre where username='" + username + "' and password='" + password + "'";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                result = rs.getInt("isAdministrateur") + 1;
            }
            System.out.println(result);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }
        return result;
    }

    public Membre FindMembreById(String username, String pass) {
        Statement stmt;
        Connection cnx;
        ResultSet rs;
        Membre membre = null;
        try {
            cnx = Connexion.getInstance();
            String query = "Select * from membre where username='" + username + "' and password='" + pass + "'";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                System.out.println(rs.getInt(1));
                membre = new Membre(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }
        return membre;
    }

    public int updateMembre(Membre membre) {
        Statement stmt;
        Connection cnx;
        int rs = 0;
        System.out.println(membre.toString());
        try {
            cnx = Connexion.getInstance();
            String query = "Update membre set username='" + membre.getUsername() + "', password='" + membre.getPassword() + "', nom='" + membre.getNom() + "',email='" + membre.getEmail() + "' where id_membre=" + membre.getId_membre();
            stmt = cnx.createStatement();
            rs = stmt.executeUpdate(query);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }
        return rs;

    }

    public ObservableList<Membre> ListerMembre() {
        Statement stmt;
        ObservableList<Membre> result = null;
        Connection cnx;
        ResultSet rs;
        try {
            result = FXCollections.observableArrayList();
            cnx = Connexion.getInstance();
            String query = "Select * from membre";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Membre a = new Membre();
                a.setId_membre(rs.getInt(1));
                a.setNom(rs.getString(2));
                a.setUsername(rs.getString(3));
                a.setPassword(rs.getString(4));
                a.setEmail(rs.getString(5));
                a.setIsAdministrateur(rs.getBoolean(6));
                result.add(a);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }
        return result;
    }

    public boolean deleteByElement(Membre a) {
        Statement stmt;
        boolean result = false;
        Connection cnx;
        int rs;
        try {
            cnx = Connexion.getInstance();
            String query = "delete from membre where id_membre=" + a.getId_membre();
            stmt = cnx.createStatement();
            rs = stmt.executeUpdate(query);
            if (rs > 0) {
                result = true;
            }
            System.out.println(result);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }
        return result;
    }

    public boolean AjouterMembre(String nom, String user_name, String email) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, MessagingException {
        Statement stmt;
        boolean result = false;
        Connection cnx;
        int rs;
        String pass = "";
        for (int x = 0; x <= 8; x++) {
            Random random = new Random();
            pass += String.valueOf(random.nextInt(10));
        }
        String password = encryptPassword(pass);
        System.out.println(pass + " = " + password);

        cnx = Connexion.getInstance();
        String query = "INSERT INTO membre (nom, username, password, email, isAdministrateur) VALUES ( '" + nom + "', '" + user_name + "', '" + password + "', '" + email + "',false);";
        System.out.println("");
        stmt = cnx.createStatement();
        rs = stmt.executeUpdate(query);
        if (rs > 0) {
            result = true;
        }
        System.out.println("tttttttttttttttttttttttthis " + result);
        MailClass a = new MailClass();
        a.Setmail("JetSetMag inscrit", "Votre mot de passe est: " + pass + "\n Votre User_name: " + user_name);
        a.SendMyMail("clientjetsetmag@gmail.com", email, "Administrateur", nom);
        this.s = "";

        return result;
    }

    public String returnMessage() {
        return this.s;
    }

    private static String encryptPassword(String password) {
        String passwordEncoded = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            passwordEncoded = new String(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            md.reset();
        }
        return passwordEncoded;
    }
}
