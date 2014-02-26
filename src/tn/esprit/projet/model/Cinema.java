package tn.esprit.projet.model;

public class Cinema {
	
	
	int id_Salle;
	String Adresse;
	
	
	
	public Cinema() {
		super();
	}

	public Cinema(int id_Salle) {
		super();
		this.id_Salle = id_Salle;
	}

	public Cinema(int id_Salle, String adresse) {
		super();
		this.id_Salle = id_Salle;
		Adresse = adresse;
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
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	@Override
	public String toString() {
		return "Cinema [id_Salle=" + id_Salle + ", Adresse=" + Adresse + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Adresse == null) ? 0 : Adresse.hashCode());
		result = prime * result + id_Salle;
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
		Cinema other = (Cinema) obj;
		if (Adresse == null) {
			if (other.Adresse != null)
				return false;
		} else if (!Adresse.equals(other.Adresse))
			return false;
		if (id_Salle != other.id_Salle)
			return false;
		return true;
	}
	
	
	
	
	
	

}
