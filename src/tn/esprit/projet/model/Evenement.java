package tn.esprit.projet.model;

import java.util.Date;

public class Evenement {
	
	int Id_Event;
	Date Date_Debut;
	Date Date_Fin;
	String Type_Event;
	String Description;
	
	
	
	
	public Evenement() {
		super();
	}
	public Evenement(int id_Event) {
		super();
		Id_Event = id_Event;
	}
	public Evenement(int id_Event, Date date_Debut, Date date_Fin,
			String type_Event, String description) {
		super();
		Id_Event = id_Event;
		Date_Debut = date_Debut;
		Date_Fin = date_Fin;
		Type_Event = type_Event;
		Description = description;
	}
	public int getId_Event() {
		return Id_Event;
	}
	public void setId_Event(int id_Event) {
		Id_Event = id_Event;
	}
	public Date getDate_Debut() {
		return Date_Debut;
	}
	public void setDate_Debut(Date date_Debut) {
		Date_Debut = date_Debut;
	}
	public Date getDate_Fin() {
		return Date_Fin;
	}
	public void setDate_Fin(Date date_Fin) {
		Date_Fin = date_Fin;
	}
	public String getType_Event() {
		return Type_Event;
	}
	public void setType_Event(String type_Event) {
		Type_Event = type_Event;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Override
	public String toString() {
		return "Evenement [Id_Event=" + Id_Event + ", Date_Debut=" + Date_Debut
				+ ", Date_Fin=" + Date_Fin + ", Type_Event=" + Type_Event
				+ ", Description=" + Description + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Date_Debut == null) ? 0 : Date_Debut.hashCode());
		result = prime * result
				+ ((Date_Fin == null) ? 0 : Date_Fin.hashCode());
		result = prime * result
				+ ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + Id_Event;
		result = prime * result
				+ ((Type_Event == null) ? 0 : Type_Event.hashCode());
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
		Evenement other = (Evenement) obj;
		if (Date_Debut == null) {
			if (other.Date_Debut != null)
				return false;
		} else if (!Date_Debut.equals(other.Date_Debut))
			return false;
		if (Date_Fin == null) {
			if (other.Date_Fin != null)
				return false;
		} else if (!Date_Fin.equals(other.Date_Fin))
			return false;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (Id_Event != other.Id_Event)
			return false;
		if (Type_Event == null) {
			if (other.Type_Event != null)
				return false;
		} else if (!Type_Event.equals(other.Type_Event))
			return false;
		return true;
	}
	
	
	
	

}
