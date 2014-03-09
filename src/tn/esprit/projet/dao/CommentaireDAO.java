package tn.esprit.projet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.projet.model.Commentaire;
import tn.esprit.projet.util.Connexion;
import tn.esprit.projet.util.FormattedComment;

/**
 *
 * @author Chaker
 */
public class CommentaireDAO {

    public ObservableList<FormattedComment> ListerCommentairesById(int id) {
        Statement stmt;
        ObservableList<FormattedComment> result = null;
        Connection cnx;
        ResultSet rs;
        try {
            result = FXCollections.observableArrayList();
            cnx = Connexion.getInstance();
            String query = "Select * from commentaire where id_evenement=" + id + " OR id_article=" + id + " OR id_film=" + id + " OR id_projection=" + id;
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                FormattedComment c = new FormattedComment();
                c.id = rs.getInt(1);
                /* Si le commentaire corresspond à un */
                /* Film */
                if (rs.getInt(2) > 0) {
                    Statement stmt2 = cnx.createStatement();
                    String query2 = "Select film.nom_film from film,commentaire"
                            + " where film.id_film=commentaire.id_film";
                    ResultSet rs2 = stmt2.executeQuery(query2);
                    while (rs2.next()) {
                        c.publication = rs2.getString(1);
                    }
                } /* Article */ else if (rs.getInt(3) > 0) {
                    Statement stmt2 = cnx.createStatement();
                    String query2 = "Select article.titre from article,commentaire"
                            + " where article.id_article=commentaire.id_article";
                    ResultSet rs2 = stmt2.executeQuery(query2);
                    while (rs2.next()) {
                        c.publication = rs2.getString(1);
                    }
                } /* Evenement */ else if (rs.getInt(4) > 0) {
                    Statement stmt2 = cnx.createStatement();
                    String query2 = "Select evenement.titre_event "
                            + "from evenement,commentaire"
                            + " where evenement.id_evenement=commentaire.id_evenement";
                    ResultSet rs2 = stmt2.executeQuery(query2);
                    while (rs2.next()) {
                        c.publication = rs2.getString(1);
                    }
                } /* Projection */ else if (rs.getInt(6) > 0) {
//                    Statement stmt2 = cnx.createStatement();
//                    String query2 = "Select projection.titre_event "
//                            + "from evenement,commentaire"
//                            + " where evenement.id_evenement
//                                    =commentaire.id_evenement";
//                    ResultSet rs2 = stmt2.executeQuery(query2);
//                    while(rs2.next()){
//                        c.publication = rs2.getString(1);
//                    }
                }

                /* Si le commentaire est crée par un membre */
                int idMembre = rs.getInt("id_membre");
                System.out.println("Iddd "+idMembre);
                if (idMembre > 0) {
                    Statement stmt2 = cnx.createStatement();
                    String query2 = "Select membre.username "
                            + "from membre"
                            + " where membre.id_membre="+idMembre+";";
                    ResultSet rs2 = stmt2.executeQuery(query2);
                    while (rs2.next()) {
                        c.membre = rs2.getString(1);
                    }
                }
                c.dateCommentaire = rs.getString(7);
                c.texte = rs.getString(8);
                result.add(c);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }

        return result;
    }

    public ObservableList<FormattedComment> ListerCommentaires() {
        Statement stmt;
        ObservableList<FormattedComment> result = null;
        Connection cnx;
        ResultSet rs;
        try {
            result = FXCollections.observableArrayList();
            cnx = Connexion.getInstance();
            String query = "Select * from commentaire";
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                FormattedComment c = new FormattedComment();
                c.id = rs.getInt(1);
                /* Si le commentaire corresspond à un */
                /* Film */
                if (rs.getInt(2) > 0) {
                    Statement stmt2 = cnx.createStatement();
                    String query2 = "Select film.nom_film from film,commentaire"
                            + " where film.id_film=commentaire.id_film";
                    ResultSet rs2 = stmt2.executeQuery(query2);
                    while (rs2.next()) {
                        c.publication = rs2.getString(1);
                    }
                } /* Article */ else if (rs.getInt(3) > 0) {
                    Statement stmt2 = cnx.createStatement();
                    String query2 = "Select article.titre from article,commentaire"
                            + " where article.id_article=commentaire.id_article";
                    ResultSet rs2 = stmt2.executeQuery(query2);
                    while (rs2.next()) {
                        c.publication = rs2.getString(1);
                    }
                } /* Evenement */ else if (rs.getInt(4) > 0) {
                    Statement stmt2 = cnx.createStatement();
                    String query2 = "Select evenement.titre_event "
                            + "from evenement,commentaire"
                            + " where evenement.id_evenement=commentaire.id_evenement";
                    ResultSet rs2 = stmt2.executeQuery(query2);
                    while (rs2.next()) {
                        c.publication = rs2.getString(1);
                    }
                } /* Projection */ else if (rs.getInt(6) > 0) {
//                    Statement stmt2 = cnx.createStatement();
//                    String query2 = "Select projection.titre_event "
//                            + "from evenement,commentaire"
//                            + " where evenement.id_evenement
//                                    =commentaire.id_evenement";
//                    ResultSet rs2 = stmt2.executeQuery(query2);
//                    while(rs2.next()){
//                        c.publication = rs2.getString(1);
//                    }
                }

               /* Si le commentaire est crée par un membre */
                int idMembre = rs.getInt("id_membre");;
                if (idMembre > 0) {
                    Statement stmt2 = cnx.createStatement();
                    String query2 = "Select membre.username "
                            + "from membre"
                            + " where membre.id_membre="+idMembre+";";
                    ResultSet rs2 = stmt2.executeQuery(query2);
                    while (rs2.next()) {
                        c.membre = rs2.getString(1);
                    }
                }

                c.dateCommentaire = rs.getString(7);
                c.texte = rs.getString(8);
                result.add(c);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }

        return result;
    }

    public void supprimerCommentaire(int id) {
        Statement stmt;
        Connection cnx;
        int result;
        try {
            cnx = Connexion.getInstance();
            String query = "DELETE FROM commentaire WHERE id_com=" + id;
            stmt = cnx.createStatement();

            result = stmt.executeUpdate(query);
            if (result > 0) {
                System.out.println("Suppression réussie");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Listage impossible: " + ex.getMessage());
        }
    }

    public void CommenterEvenement(Commentaire comment) {
        Statement stmt;
        Connection cnx;
        String query = "INSERT INTO commentaire (id_evenement,id_membre,texte) VALUES ("
                + comment.getEvenement().getId_evenement() + "," + comment.getMembre().getId_membre() + ",'" + comment.getTexte() + "')";
        try {
            cnx = Connexion.getInstance();
            stmt = cnx.createStatement();
            int rs = stmt.executeUpdate(query);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void CommenterProjection(Commentaire comment) {
        Statement stmt;
        Connection cnx;
        String query = "INSERT INTO commentaire (id_projection,id_membre,texte) VALUES ("
                + comment.getProjection().getId_projection() + "," + comment.getMembre().getId_membre() + ",'" + comment.getTexte() + "')";
        try {
            cnx = Connexion.getInstance();
            stmt = cnx.createStatement();
            int rs = stmt.executeUpdate(query);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void CommenterArticle(Commentaire comment) {
        Statement stmt;
        Connection cnx;
        String query = "INSERT INTO commentaire (id_article,id_membre,texte) VALUES ("
                + comment.getArticle().getId_article() + "," + comment.getMembre().getId_membre() + ",'" + comment.getTexte() + "')";
        try {
            cnx = Connexion.getInstance();
            stmt = cnx.createStatement();
            int rs = stmt.executeUpdate(query);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void CommenterFilm(Commentaire comment) {
        Statement stmt;
        Connection cnx;
        String query = "INSERT INTO commentaire (id_film,id_membre,texte) VALUES ("
                + comment.getFilm().getId_film() + "," + comment.getMembre().getId_membre() + ",'" + comment.getTexte() + "')";
        try {
            cnx = Connexion.getInstance();
            stmt = cnx.createStatement();
            int rs = stmt.executeUpdate(query);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifierCommentaire(FormattedComment comment) {
        Statement stmt;
        Connection cnx;
        String query = "UPDATE commentaire SET "
                + "texte='" + comment.getTexte() + "'"
                + " WHERE id_com= " + comment.getId() + " ;";
        try {
            cnx = Connexion.getInstance();
            stmt = cnx.createStatement();
            int rs = stmt.executeUpdate(query);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}