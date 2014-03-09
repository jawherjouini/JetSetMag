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
public class Media_Par_Element {
    
    int Id_Media_Page;
    Media media;
    Film film;
    Article article;
    Evenement evenement;
    Projection projection;
    Cinema cinema;

    public Media_Par_Element() {
    }

    public Media_Par_Element(int Id_Media_Page, Media media, Film film, Article article, Evenement evenement, Projection projection, Cinema cinema) {
        this.Id_Media_Page = Id_Media_Page;
        this.media = media;
        this.film = film;
        this.article = article;
        this.evenement = evenement;
        this.projection = projection;
        this.cinema = cinema;
    }

    public Media_Par_Element(int Id_Media_Page) {
        this.Id_Media_Page = Id_Media_Page;
    }

    public int getId_Media_Page() {
        return Id_Media_Page;
    }

    public void setId_Media_Page(int Id_Media_Page) {
        this.Id_Media_Page = Id_Media_Page;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public Projection getProjection() {
        return projection;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public String toString() {
        return "Media_Par_Element{" + "Id_Media_Page=" + Id_Media_Page + ", media=" + media + ", film=" + film + ", article=" + article + ", evenement=" + evenement + ", projection=" + projection + ", cinema=" + cinema + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.Id_Media_Page;
        hash = 89 * hash + Objects.hashCode(this.media);
        hash = 89 * hash + Objects.hashCode(this.film);
        hash = 89 * hash + Objects.hashCode(this.article);
        hash = 89 * hash + Objects.hashCode(this.evenement);
        hash = 89 * hash + Objects.hashCode(this.projection);
        hash = 89 * hash + Objects.hashCode(this.cinema);
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
        final Media_Par_Element other = (Media_Par_Element) obj;
        if (this.Id_Media_Page != other.Id_Media_Page) {
            return false;
        }
        if (!Objects.equals(this.media, other.media)) {
            return false;
        }
        if (!Objects.equals(this.film, other.film)) {
            return false;
        }
        if (!Objects.equals(this.article, other.article)) {
            return false;
        }
        if (!Objects.equals(this.evenement, other.evenement)) {
            return false;
        }
        if (!Objects.equals(this.projection, other.projection)) {
            return false;
        }
        if (!Objects.equals(this.cinema, other.cinema)) {
            return false;
        }
        return true;
    }
    
    
}
