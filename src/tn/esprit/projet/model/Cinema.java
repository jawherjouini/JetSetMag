package tn.esprit.projet.model;

import java.util.Objects;

public class Cinema {
	
	
	int id_Salle;
	String Adresse;
        String emplacement;
        String nomSalle;

    public Cinema() {
    }

    public Cinema(int id_Salle) {
        this.id_Salle = id_Salle;
    }

    public Cinema(int id_Salle, String Adresse, String emplacement, String nomSalle) {
        this.id_Salle = id_Salle;
        this.Adresse = Adresse;
        this.emplacement = emplacement;
        this.nomSalle = nomSalle;
    }

    public Cinema(String Adresse, String emplacement, String nomSalle) {
        this.Adresse = Adresse;
        this.emplacement = emplacement;
        this.nomSalle = nomSalle;
    }
        
    
        

    public int getId_Salle() {
        return id_Salle;
    }

    public void setId_Salle(int id_Salle) {
        this.id_Salle = id_Salle;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id_Salle;
        hash = 83 * hash + Objects.hashCode(this.Adresse);
        hash = 83 * hash + Objects.hashCode(this.emplacement);
        hash = 83 * hash + Objects.hashCode(this.nomSalle);
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
        final Cinema other = (Cinema) obj;
        if (this.id_Salle != other.id_Salle) {
            return false;
        }
        if (!Objects.equals(this.Adresse, other.Adresse)) {
            return false;
        }
        if (!Objects.equals(this.emplacement, other.emplacement)) {
            return false;
        }
        if (!Objects.equals(this.nomSalle, other.nomSalle)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cinema{" + "id_Salle=" + id_Salle + ", Adresse=" + Adresse + ", emplacement=" + emplacement + ", nomSalle=" + nomSalle + '}';
    }
	
	
	
	
	
	

}
