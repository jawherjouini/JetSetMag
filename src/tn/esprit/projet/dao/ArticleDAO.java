
package tn.esprit.projet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.projet.model.Article;
import tn.esprit.projet.util.Connexion;

/**
 *
 * @author Jawher
 */
public class ArticleDAO {

    public ObservableList<Article> ListerArticles() {
        Statement stmt;
        ObservableList<Article> result = null;
        Connection cnx;
        ResultSet rs;
        try {
            result = FXCollections.observableArrayList();
            cnx = Connexion.getInstance();
            String query = "Select * from article";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Article a = new Article();
                a.setId_article(rs.getInt(1));
                a.setTitre(rs.getString(2));
                a.setTexte(rs.getString(3));
                a.setNote_moy(rs.getInt(4));
                a.setNbr_visite(rs.getInt(5));
                a.setDate_redaction(rs.getString(6));
                result.add(a);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }
        return result;
    }

    public boolean deleteByElement(Article a) {
        Statement stmt;
        boolean result = false;
        Connection cnx;
        int rs;
        try {
            cnx = Connexion.getInstance();
            String query = "delete from article where id_article=" + a.getId_article();
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

    public boolean delete() {
        Statement stmt;
        boolean result = false;
        Connection cnx;
        int rs;
        try {
            cnx = Connexion.getInstance();
            String query = "delete from article";
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

    public boolean add(Article a) {
        Statement stmt;
        boolean result = false;
        Connection cnx;
        int rs;
        try {
            cnx = Connexion.getInstance();
            String titre=a.getTitre();
            String texte= a.getTexte();
            int note = a.getNote_moy();
            int nbr = a.getNbr_visite();
            String query = "insert into article (titre,texte,note_moy,nbr_visite) values ('"+titre+ "','" + texte + "'," + note + "," + nbr + ")";
            stmt = cnx.createStatement();
            rs = stmt.executeUpdate(query);

            if (rs > 0) {
                result = true;
            }
            System.out.println(result);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Ajout impossible: " + ex.getMessage());
        }
        return result;
    }

    public boolean update(Article a) {
        Statement stmt;
        boolean result = false;
        Connection cnx;
        int rs;
        try {
            cnx = Connexion.getInstance();
            String titre=a.getTitre();
            String texte= a.getTexte();
            int id = a.getId_article();
            String query = "update article set titre='"+titre+"', texte= '"+texte+"' where id_article="+id;
            System.out.println(query);
            stmt = cnx.createStatement();
            rs = stmt.executeUpdate(query);
            if (rs > 0) {
                result = true;
            }
            System.out.println(result);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Modification impossible: " + ex.getMessage());
        }
        return result;
    }
}
