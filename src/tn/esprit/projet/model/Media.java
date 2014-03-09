/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.model;

import java.util.Objects;

/**
 *
 * @author tasnim
 */
public class Media {
    int Id_Media;
    String Type_Media;
    String URL;

    public Media() {
    }

    public Media(int Id_Media) {
        this.Id_Media = Id_Media;
    }

    public Media(int Id_Media, String Type_Media, String URL) {
        this.Id_Media = Id_Media;
        this.Type_Media = Type_Media;
        this.URL = URL;
    }

    public Media(String Type_Media, String URL) {
        this.Type_Media = Type_Media;
        this.URL = URL;
    }

    
    public int getId_Media() {
        return Id_Media;
    }

    public void setId_Media(int Id_Media) {
        this.Id_Media = Id_Media;
    }

    public String getType_Media() {
        return Type_Media;
    }

    public void setType_Media(String Type_Media) {
        this.Type_Media = Type_Media;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "Media{" + "Id_Media=" + Id_Media + ", Type_Media=" + Type_Media + ", URL=" + URL + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.Id_Media;
        hash = 97 * hash + Objects.hashCode(this.Type_Media);
        hash = 97 * hash + Objects.hashCode(this.URL);
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
        final Media other = (Media) obj;
        if (this.Id_Media != other.Id_Media) {
            return false;
        }
        if (!Objects.equals(this.Type_Media, other.Type_Media)) {
            return false;
        }
        if (!Objects.equals(this.URL, other.URL)) {
            return false;
        }
        return true;
    }
    
    
    
}
