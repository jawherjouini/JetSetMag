
package tn.esprit.projet.model;

/**
 *
 * @author acer
 */
public class Visite {

    private int id_visiteur;
    private String date_entree;
    private int id_membre;
    private String mois;
    private int nbr_visiteurs;

    @Override
    public String toString() {
        return "Visite{" + "id_visiteur=" + id_visiteur + ", date_entree=" + date_entree + ", id_membre=" + id_membre + ", mois=" + mois + ", nbr_visiteurs=" + nbr_visiteurs + '}';
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public int getNbr_visiteurs() {
        return nbr_visiteurs;
    }

    public void setNbr_visiteurs(int nbr_visiteurs) {
        this.nbr_visiteurs = nbr_visiteurs;
    }

    public Visite() {
    }

    public int getId_visiteur() {
        return id_visiteur;
    }

    public void setId_visiteur(int id_visiteur) {
        this.id_visiteur = id_visiteur;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public String getDate_entree() {
        return date_entree;
    }

    public void setDate_entree(String date_entree) {
        this.date_entree = date_entree;
    }

}
