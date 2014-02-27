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

}
