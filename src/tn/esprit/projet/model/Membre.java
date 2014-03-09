/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.projet.model;

/**
 *
 * @author acer
 */
public class Membre {

    private int id_membre;
      private String nom;
    private String username;
    private String password;
    private String email;
    private Boolean isAdministrateur;
   

    @Override
    public String toString() {
        return "Membre{" + "id_membre=" + id_membre + ", nom=" + nom + ", username=" + username + ", password=" + password + ", email=" + email + ", isAdministrateur=" + isAdministrateur + '}';
    }

    public Membre() {
    }

    public Membre(int id_membre, String nom, String username, String password, String email, Boolean isAdministrateur) {
        this.id_membre = id_membre;
        this.nom = nom;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isAdministrateur = isAdministrateur;
    }
  

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isIsAdministrateur() {
        return isAdministrateur;
    }

    public void setIsAdministrateur(Boolean isAdministrateur) {
        this.isAdministrateur = isAdministrateur;
    }

}