/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.util;

import java.util.Date;
import java.util.Objects;
import tn.esprit.projet.model.Production;

/**
 *
 * @author tasnim
 */
public class ProjectionUtil {
    
        int id_film;
	String synopsis;
	Date date_ajout;
        String nom_film;
        String duree;
        Production production;
        int id_salle;
	String adresse;
        String emplacement;
        String nom_salle;
	int id_projection;
	String date_projection;

    public ProjectionUtil() {
    }

    public ProjectionUtil( String synopsis, Date date_ajout, String titre, String duree, int id_salle, String adresse, String emplacement, String nom_salle, int id_projection, String date_projection) {
        this.synopsis = synopsis;
        this.date_ajout = date_ajout;
        this.nom_film = titre;
        this.duree = duree;
        this.id_salle = id_salle;
        this.adresse = adresse;
        this.emplacement = emplacement;
        this.nom_salle = nom_salle;
        this.id_projection = id_projection;
        this.date_projection = date_projection;
    }

    public ProjectionUtil(String date_sortie, String synopsis, Date date_ajout, String titre, String duree, Production production, int id_salle, String adresse, String emplacement, String nom_salle, int id_projection, String date_projection) {
        this.id_film = id_film;
        this.synopsis = synopsis;
        this.date_ajout = date_ajout;
        this.nom_film = titre;
        this.duree = duree;
        this.production = production;
        this.id_salle = id_salle;
        this.adresse = adresse;
        this.emplacement = emplacement;
        this.nom_salle = nom_salle;
        this.id_projection = id_projection;
        this.date_projection = date_projection;
    }

    public int getId_film() {
        return id_film;
    }

    public void setId_film(int id_film) {
        this.id_film = id_film;
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

    public String getNom_film() {
        return nom_film;
    }

    public void setNom_film(String titre) {
        this.nom_film = titre;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public int getId_salle() {
        return id_salle;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getNom_salle() {
        return nom_salle;
    }

    public void setNom_salle(String nom_salle) {
        this.nom_salle = nom_salle;
    }

    public int getId_projection() {
        return id_projection;
    }

    public void setId_projection(int id_projection) {
        this.id_projection = id_projection;
    }

    public String getDate_heure() {
        return date_projection;
    }

    public void setDate_heure(String date_projection) {
        this.date_projection = date_projection;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.id_film;
        hash = 11 * hash + Objects.hashCode(this.synopsis);
        hash = 11 * hash + Objects.hashCode(this.date_ajout);
        hash = 11 * hash + Objects.hashCode(this.nom_film);
        hash = 11 * hash + Objects.hashCode(this.duree);
        hash = 11 * hash + Objects.hashCode(this.production);
        hash = 11 * hash + this.id_salle;
        hash = 11 * hash + Objects.hashCode(this.adresse);
        hash = 11 * hash + Objects.hashCode(this.emplacement);
        hash = 11 * hash + Objects.hashCode(this.nom_salle);
        hash = 11 * hash + this.id_projection;
        hash = 11 * hash + Objects.hashCode(this.date_projection);
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
        final ProjectionUtil other = (ProjectionUtil) obj;
        if (this.id_film != other.id_film) {
            return false;
        }
      
        if (!Objects.equals(this.synopsis, other.synopsis)) {
            return false;
        }
        if (!Objects.equals(this.date_ajout, other.date_ajout)) {
            return false;
        }
        if (!Objects.equals(this.nom_film, other.nom_film)) {
            return false;
        }
        if (!Objects.equals(this.duree, other.duree)) {
            return false;
        }
        if (!Objects.equals(this.production, other.production)) {
            return false;
        }
        if (this.id_salle != other.id_salle) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.emplacement, other.emplacement)) {
            return false;
        }
        if (!Objects.equals(this.nom_salle, other.nom_salle)) {
            return false;
        }
        if (this.id_projection != other.id_projection) {
            return false;
        }
        if (!Objects.equals(this.date_projection, other.date_projection)) {
            return false;
        }
        return true;
    }
        
        
        

    
        
    
}
