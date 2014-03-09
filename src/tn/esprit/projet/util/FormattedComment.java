
package tn.esprit.projet.util;

/**
 *
 * @author Chaker
 */
public class FormattedComment {
    public int id;
    public String texte;
    public String dateCommentaire;
    public String publication;
    public String membre;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(String dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getMembre() {
        return membre;
    }

    public void setMembre(String membre) {
        this.membre = membre;
    }

    @Override
    public String toString() {
        //return "FormattedComment{" + "id=" + id + ", texte=" + texte + ", dateCommentaire=" + dateCommentaire + ", publication=" + publication + ", membre=" + membre + '}';
        return membre+" a écrit le "+dateCommentaire.substring(0, 16)+": "+texte;
    }

    
}
