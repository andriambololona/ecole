
package models;

import services.tableBD;

public class Matiere extends tableBD{
    String id;
    String nom_matiere;
    Number coefficient;
    Number idNiveau;

    public Matiere() {
    }
    
    public Matiere(String nom_matiere, Number coefficient, Number idNiveau) {
        this.nom_matiere = nom_matiere;
        this.coefficient = coefficient;
        this.idNiveau = idNiveau;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom_matiere() {
        return nom_matiere;
    }

    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }

    public Number getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Number coefficient) {
        this.coefficient = coefficient;
    }

    public Number getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Number idNiveau) {
        this.idNiveau = idNiveau;
    }
    
    
}
