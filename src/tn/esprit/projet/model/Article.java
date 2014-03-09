
package tn.esprit.projet.model;

/**
 *
 * @author Jawher
 */
public class Article {
    private int id_article;
    private String titre;
    private String texte;
    private float note_moy;
    private int nbr_visite;
    private String date_redaction;

    public Article() {
    }

    @Override
    public String toString() {
        return date_redaction.substring(0, 10)+ " | lu : "+ nbr_visite+ " fois et noté: "+note_moy+"/5 | "+titre;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public float getNote_moy() {
        return note_moy;
    }

    public void setNote_moy(float note_moy) {
        this.note_moy = note_moy;
    }

    public int getNbr_visite() {
        return nbr_visite;
    }

    public void setNbr_visite(int nbr_visite) {
        this.nbr_visite = nbr_visite;
    }

    public String getDate_redaction() {
        return date_redaction;
    }

    public void setDate_redaction(String date_redaction) {
        this.date_redaction = date_redaction;
    }
    
    
    
}
