/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.projet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.projet.util.Connexion;

/**
 *
 * @author Jawher
 */
public class CommonDAO {

    Statement stmt;
    Connection cnx;
    ResultSet rs;

    public ObservableList<Object[]> finAll(String tablename) {
        ObservableList<Object[]> liste = FXCollections.observableArrayList();
        Object[] row;
        try {

            cnx = Connexion.getInstance();
            stmt = cnx.createStatement();
            String req = "Select * from " + tablename;
            rs = stmt.executeQuery(req);
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                row = new Object[rsmd.getColumnCount()];
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row[i - 1] = rs.getObject(i);

                }
                liste.add(row);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }
        return liste;

    }

    public List<String> ColonneName(String nomtable) {
        ArrayList<String> nom = new ArrayList<>();
        try {
            cnx = Connexion.getInstance();
            Statement stm = cnx.createStatement();
            ResultSet res;
            res = stm.executeQuery("select * from " + nomtable);
            ResultSetMetaData rsMd = res.getMetaData();
            for (int i = 1; i <= rsMd.getColumnCount(); i++) {
                nom.add(rsMd.getColumnName(i).toString());
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Listage de colonnes impossible: " + e.getMessage());
        }
        return nom;
    }
}
