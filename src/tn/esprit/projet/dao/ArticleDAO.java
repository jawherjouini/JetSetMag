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

    Statement stmt;
    ObservableList<Article> result;
    Connection cnx;
    ResultSet rs;

    public ObservableList<Article> ListerArticles() {

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

}
