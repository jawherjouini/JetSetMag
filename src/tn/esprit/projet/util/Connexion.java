/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.projet.util;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Med
 */
public class Connexion {

    String url = "jdbc:mysql://sql3.freemysqlhosting.net/sql330528";
    String user = "sql330528";
    String pwd = "dJ2*wX8%";

    static Connection cnx;

    private Connexion() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver"); // pour charger le driver
        cnx = DriverManager.getConnection(url, user, pwd); // etablir une connexion
        System.out.println("connexion etablie ");
    }

    public static Connection getInstance() throws SQLException, ClassNotFoundException {
        if (cnx == null) {
            new Connexion();
        }
        return (cnx);
    }
}
