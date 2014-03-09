/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.model;

/**
 *
 * @author oukhay
 */
public class Note {
    int id_note;
    int id_film;
    int id_evenement;
    int id_projection;
    int nbr_etoiles;
    int id_article;

    public Note() {
    }
    

    public int getId_note() {
        return id_note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    public int getId_film() {
        return id_film;
    }

    public void setId_film(int id_film) {
        this.id_film = id_film;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public int getId_projection() {
        return id_projection;
    }

    public void setId_projection(int id_projection) {
        this.id_projection = id_projection;
    }

    public int getNbr_etoiles() {
        return nbr_etoiles;
    }

    public void setNbr_etoiles(int nbr_etoiles) {
        this.nbr_etoiles = nbr_etoiles;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }
    
    
    
    
    
}
