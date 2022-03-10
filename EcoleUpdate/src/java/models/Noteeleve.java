package models;

import services.tableBD;

public class Noteeleve extends tableBD{

    String nummatricule;
    String nom_eleve;
    String prenom_eleve;
    Number noteeleve;
    String niveau;
    String idmatiere;
    String nom_matiere;
    Number coefficient;
    String idtrimestre;
    String trimestre;
    String nom;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public Noteeleve() {
    }

    public String getNummatricule() {
        return nummatricule;
    }

    public void setNummatricule(String nummatricule) {
        this.nummatricule = nummatricule;
    }

    public String getNom_eleve() {
        return nom_eleve;
    }

    public void setNom_eleve(String nom_eleve) {
        this.nom_eleve = nom_eleve;
    }

    public String getPrenom_eleve() {
        return prenom_eleve;
    }

    public void setPrenom_eleve(String prenom_eleve) {
        this.prenom_eleve = prenom_eleve;
    }

    public Number getNoteeleve() {
        return noteeleve;
    }

    public void setNoteeleve(Number noteeleve) {
        this.noteeleve = noteeleve;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getIdmatiere() {
        return idmatiere;
    }

    public void setIdmatiere(String idmatiere) {
        this.idmatiere = idmatiere;
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

    public String getIdtrimestre() {
        return idtrimestre;
    }

    public void setIdtrimestre(String idtrimestre) {
        this.idtrimestre = idtrimestre;
    }

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }
    
    
}
