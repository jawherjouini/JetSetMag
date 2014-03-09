package tn.esprit.projet.dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.mail.MessagingException;
import tn.esprit.projet.model.Membre;
import tn.esprit.projet.util.Connexion;
import tn.esprit.projet.util.MailClass;

/**
 *
 * @author acer
 */
public class MembreDAO {

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
    
    public Membre getMembre(String username) {
        Statement stmt;
        Membre result = null;
        Connection cnx;
        ResultSet rs;
        try {
            cnx = Connexion.getInstance();
            String query = "Select * from membre where username='"+username+"'";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                result = new Membre();
                result.setId_membre(rs.getInt(1));
                result.setUsername(rs.getString("username"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }
        return result;
        
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

    public boolean AjouterMembre(String nom, String user_name, String email) {
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
        try {
            cnx = Connexion.getInstance();
            String query = "INSERT INTO membre (nom, username, password, email, isAdministrateur) VALUES ( '" + nom + "', '" + user_name + "', '" + password + "', '" + email + "',false);";
            System.out.println("");
            stmt = cnx.createStatement();
            rs = stmt.executeUpdate(query);
            if (rs > 0) {
                result = true;
            }
            System.out.println(result);
            MailClass a = new MailClass();
            a.Setmail("JetSetMag inscrit", "Votre mot de passe est: " + pass + "\n Votre User_name: " + user_name);
            a.SendMyMail("clientjetsetmag@gmail.com", email, "Administrateur", nom);
            this.s = "";
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            this.s = "Ce user name est déja utilisé  ";
        } catch (UnsupportedEncodingException | MessagingException ex) {
            System.out.println("erreur mailing: "+ex.getMessage());
        }
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
