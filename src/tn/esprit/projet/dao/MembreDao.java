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
import tn.esprit.projet.model.Article;
import tn.esprit.projet.util.Connexion;

/**
 *
 * @author acer
 */
public class MembreDao {

    public boolean authentification(String username, String pass) {
        Statement stmt;
        boolean result = false;
        Connection cnx;
        ResultSet rs;

        try {
            cnx = Connexion.getInstance();
            String query = "Select * from membre where username='"+username+"' and password='"+pass+"'";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                result = true;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }
        return result;
    }
}

