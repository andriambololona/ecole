package models;

import services.tableBD;

public class Infoeleve extends tableBD {

    String ideleve;
    String niveau;
    String nom;
    String prenom;
    String sexe;
    Number montant_total;
    Number etat_paiement;
    String annee_scolaire;
    String mois;

    public Infoeleve() {
    }

    public String getIdeleve() {
        return ideleve;
    }

    public void setIdeleve(String ideleve) {
        this.ideleve = ideleve;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
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

    public Number getMontant_total() {
        return montant_total;
    }

    public void setMontant_total(Number montant_total) {
        this.montant_total = montant_total;
    }
    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public Number getEtat_paiement() {
        return etat_paiement;
    }

    public void setEtat_paiement(Number etat_paiement) {
        this.etat_paiement = etat_paiement;
    }

    public String getAnnee_scolaire() {
        return annee_scolaire;
    }

    public void setAnnee_scolaire(String annee_scolaire) {
        this.annee_scolaire = annee_scolaire;
    }
    
}
