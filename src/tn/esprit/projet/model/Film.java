package tn.esprit.projet.model;

import java.util.Date;

public class Film {
	
	int Id_Film;
	Date Date_Sortie;
	String Synopsis;
	Date Date_Ajout;
	
	
	public Film() {
		super();
	}


	public Film(int id_Film) {
		super();
		Id_Film = id_Film;
	}


	public Film(int id_Film, Date date_Sortie, String synopsis, Date date_Ajout) {
		super();
		Id_Film = id_Film;
		Date_Sortie = date_Sortie;
		Synopsis = synopsis;
		Date_Ajout = date_Ajout;
	}


	public int getId_Film() {
		return Id_Film;
	}


	public void setId_Film(int id_Film) {
		Id_Film = id_Film;
	}


	public Date getDate_Sortie() {
		return Date_Sortie;
	}


	public void setDate_Sortie(Date date_Sortie) {
		Date_Sortie = date_Sortie;
	}


	public String getSynopsis() {
		return Synopsis;
	}


	public void setSynopsis(String synopsis) {
		Synopsis = synopsis;
	}


	public Date getDate_Ajout() {
		return Date_Ajout;
	}


	public void setDate_Ajout(Date date_Ajout) {
		Date_Ajout = date_Ajout;
	}


	@Override
	public String toString() {
		return "Film [Id_Film=" + Id_Film + ", Date_Sortie=" + Date_Sortie
				+ ", Synopsis=" + Synopsis + ", Date_Ajout=" + Date_Ajout + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Date_Ajout == null) ? 0 : Date_Ajout.hashCode());
		result = prime * result
				+ ((Date_Sortie == null) ? 0 : Date_Sortie.hashCode());
		result = prime * result + Id_Film;
		result = prime * result
				+ ((Synopsis == null) ? 0 : Synopsis.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (Date_Ajout == null) {
			if (other.Date_Ajout != null)
				return false;
		} else if (!Date_Ajout.equals(other.Date_Ajout))
			return false;
		if (Date_Sortie == null) {
			if (other.Date_Sortie != null)
				return false;
		} else if (!Date_Sortie.equals(other.Date_Sortie))
			return false;
		if (Id_Film != other.Id_Film)
			return false;
		if (Synopsis == null) {
			if (other.Synopsis != null)
				return false;
		} else if (!Synopsis.equals(other.Synopsis))
			return false;
		return true;
	}
	
	

}
