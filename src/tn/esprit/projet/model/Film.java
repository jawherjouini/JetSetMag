package tn.esprit.projet.model;

import java.util.Date;
import java.util.Objects;

public class Film {
	
	int id_film;
	String date_sortie;
	String synopsis;
	Date date_ajout;
        String titre;
        String duree;
       
    public Film() {
    }

    public Film(int id_film) {
        this.id_film = id_film;
    }

    public Film(String date_sortie, String synopsis, String titre, String duree) {
        this.date_sortie = date_sortie;
        this.synopsis = synopsis;
        this.titre = titre;
        this.duree = duree;
    }
    


    public Film(int id_film, String date_sortie, String synopsis, Date date_ajout, String titre, String duree) {
        this.id_film = id_film;
        this.date_sortie = date_sortie;
        this.synopsis = synopsis;
        this.date_ajout = date_ajout;
        this.titre = titre;
        this.duree = duree;
    }
    
    

    public int getId_film() {
        return id_film;
    }

    public void setId_film(int id_film) {
        this.id_film = id_film;
    }

    public String getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(String date_sortie) {
        this.date_sortie = date_sortie;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Date getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(Date date_ajout) {
        this.date_ajout = date_ajout;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "Film{" + "id_film=" + id_film + ", date_sortie=" + date_sortie + ", synopsis=" + synopsis + ", date_ajout=" + date_ajout + ", titre=" + titre + ", duree=" + duree + '}';
    }

        
	
	
	

	
	
	

}
