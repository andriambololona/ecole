
package models;

import services.tableBD;
import java.time.LocalDate;


public class Eleve extends tableBD{
    String id;
    String nom;
    String prenom;
    String sexe;
    LocalDate birth;

    public Eleve() {
    }
    
    public Eleve(String nom, String prenom, String sexe, LocalDate birth) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.birth = birth;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
    
    
}
