
package tn.esprit.projet.model;

/**
 *
 * @author acer
 */
public class Rubrique {
   private String rubrique ;
   
   public Rubrique(){
   }

    @Override
    public String toString() {
        return "Rubrique{" + "rubrique=" + rubrique + ", Nombre_visite=" + Nombre_visite + '}';
    }

    public String getRubrique() {
        return rubrique;
    }

    public void setRubrique(String rubrique) {
        this.rubrique = rubrique;
    }

    public int getNombre_visite() {
        return Nombre_visite;
    }

    public void setNombre_visite(int Nombre_visite) {
        this.Nombre_visite = Nombre_visite;
    }
    private int Nombre_visite;
}
