
package tn.esprit.projet.model;

import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author Chaker
 */
public class Commentaire {
    public int id;
    public String texte;
    public Timestamp dateCommentaire;
    public Article article;
    public Evenement evenement;
    public Projection projection;
    public Membre membre; 
    public Film film;

    public Commentaire() {
    }

    /* Constructeur d'un commentaire sur Article */
    public Commentaire(String texte, Timestamp dateCommentaire, Article article) {
        this.texte = texte;
        this.dateCommentaire = dateCommentaire;
        this.article = article;
    }

    /* Constructeur d'un commentaire sur Evenement */
    public Commentaire(String texte, Timestamp dateCommentaire, Evenement evenement) {
        this.texte = texte;
        this.dateCommentaire = dateCommentaire;
        this.evenement = evenement;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    /* Constructeur d'un commentaire sur Projection */
    public Commentaire(String texte, Timestamp dateCommentaire, Projection projection) {
        this.texte = texte;
        this.dateCommentaire = dateCommentaire;
        this.projection = projection;
    }

    /* Constructeur d'un commentaire sur Film */
    public Commentaire(String texte, Timestamp dateCommentaire, Film film) {
        this.texte = texte;
        this.dateCommentaire = dateCommentaire;
        this.film = film;
    }

    /*  Getters  */
    public int getId() {
        return id;
    }

    public String getTexte() {
        return texte;
    }

    public Timestamp getDateCommentaire() {
        return dateCommentaire;
    }

    public Article getArticle() {
        return article;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public Projection getProjection() {
        return projection;
    }

    public Film getFilm() {
        return film;
    }
    
    /* Setters */
    public void setId(int id) {
        this.id = id;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void setDateCommentaire(Timestamp dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
    
    /* toString hashCode Equals */
    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", texte=" + texte + ", dateCommentaire=" + dateCommentaire + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commentaire other = (Commentaire) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.texte, other.texte)) {
            return false;
        }
        return true;
    }
    
    
}
