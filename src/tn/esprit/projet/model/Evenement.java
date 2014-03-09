package tn.esprit.projet.model;

public class Evenement {
	
    int id_evenement;
    String titre_event;
    String date_deb_event;
    String date_fin_event;
    String type_event;
    boolean bon_plan;
    String description;
    int id_membre;

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }
    public Evenement() {
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_evenement=" + id_evenement + ", titre_event=" + titre_event + ", date_deb_event=" + date_deb_event + ", date_fin_event=" + date_fin_event + ", type_event=" + type_event + ", bon_plan=" + bon_plan + ", description=" + description + '}';
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public String getTitre_event() {
        return titre_event;
    }

    public void setTitre_event(String titre_event) {
        this.titre_event = titre_event;
    }

    public String getDate_deb_event() {
        return date_deb_event;
    }

    public void setDate_deb_event(String date_deb_event) {
        this.date_deb_event = date_deb_event;
    }

    public String getDate_fin_event() {
        return date_fin_event;
    }

    public void setDate_fin_event(String date_fin_event) {
        this.date_fin_event = date_fin_event;
    }

    public String getType_event() {
        return type_event;
    }

    public void setType_event(String type_event) {
        this.type_event = type_event;
    }

    public boolean isBon_plan() {
        return bon_plan;
    }

    public void setBon_plan(boolean bon_plan) {
        this.bon_plan = bon_plan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
