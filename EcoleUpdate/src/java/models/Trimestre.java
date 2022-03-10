
package models;

import services.tableBD;

public class Trimestre extends tableBD{

    String id;
    String nom;
    
    public Trimestre() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
