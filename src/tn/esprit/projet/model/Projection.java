package tn.esprit.projet.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Projection {
	
	int id_projection;
	Date date_Projection;
	List<Cinema> cinemas = new ArrayList<Cinema>();
	Film film = new Film();
	
	
	
	
	public Projection(int id_projection) {
		super();
		this.id_projection = id_projection;
	}
	
	public Projection(int id_projection, Date date_Projection,
			List<Cinema> cinemas, Film film) {
		super();
		this.id_projection = id_projection;
		this.date_Projection = date_Projection;
		this.cinemas = cinemas;
		this.film = film;
	}
	public int getId_projection() {
		return id_projection;
	}
	public void setId_projection(int id_projection) {
		this.id_projection = id_projection;
	}
	public Date getDate_Projection() {
		return date_Projection;
	}
	public void setDate_Projection(Date date_Projection) {
		this.date_Projection = date_Projection;
	}
	public List<Cinema> getCinemas() {
		return cinemas;
	}
	public void setCinemas(List<Cinema> cinemas) {
		this.cinemas = cinemas;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}

	@Override
	public String toString() {
		return "Projection [id_projection=" + id_projection
				+ ", date_Projection=" + date_Projection + ", cinemas="
				+ cinemas + ", film=" + film + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cinemas == null) ? 0 : cinemas.hashCode());
		result = prime * result
				+ ((date_Projection == null) ? 0 : date_Projection.hashCode());
		result = prime * result + ((film == null) ? 0 : film.hashCode());
		result = prime * result + id_projection;
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
		Projection other = (Projection) obj;
		if (cinemas == null) {
			if (other.cinemas != null)
				return false;
		} else if (!cinemas.equals(other.cinemas))
			return false;
		if (date_Projection == null) {
			if (other.date_Projection != null)
				return false;
		} else if (!date_Projection.equals(other.date_Projection))
			return false;
		if (film == null) {
			if (other.film != null)
				return false;
		} else if (!film.equals(other.film))
			return false;
		if (id_projection != other.id_projection)
			return false;
		return true;
	}
	
	
	
	
	
}
