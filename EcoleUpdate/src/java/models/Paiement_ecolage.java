package models;

import java.time.LocalDate;
import services.tableBD;

public class Paiement_ecolage extends tableBD{
    String id;
    String idElevee;
    String idFourchette_ecolage;
    Number etat_paiement;
    String annee_scolaire;
    String mois;

    public Paiement_ecolage() {
    }

    public Paiement_ecolage(String idEleve, String idFourchette_ecolage, Number etat_paiement, String annee_scolaire, String mois) {
        this.idElevee = idEleve;
        this.idFourchette_ecolage = idFourchette_ecolage;
        this.etat_paiement = etat_paiement;
        this.annee_scolaire = annee_scolaire;
        this.mois = mois;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdElevee() {
        return idElevee;
    }

    public void setIdElevee(String idEleve) {
        this.idElevee = idEleve;
    }

    public String getIdFourchette_ecolage() {
        return idFourchette_ecolage;
    }

    public void setIdFourchette_ecolage(String idFourchette_ecolage) {
        this.idFourchette_ecolage = idFourchette_ecolage;
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

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }
    
    
}
