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
public class Production {
    int id_production;
    String nom_production;

    public Production(int id_production, String nom_production) {
        this.id_production = id_production;
        this.nom_production = nom_production;
    }

    public Production() {
    }

    public int getId_production() {
        return id_production;
    }

    public void setId_production(int id_production) {
        this.id_production = id_production;
    }

    public String getNom_production() {
        return nom_production;
    }

    public void setNom_production(String nom_production) {
        this.nom_production = nom_production;
    }

    @Override
    public String toString() {
        return "Production{" + "id_production=" + id_production + ", nom_production=" + nom_production + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id_production;
        hash = 37 * hash + Objects.hashCode(this.nom_production);
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
        final Production other = (Production) obj;
        if (this.id_production != other.id_production) {
            return false;
        }
        if (!Objects.equals(this.nom_production, other.nom_production)) {
            return false;
        }
        return true;
    }
    
    
}
