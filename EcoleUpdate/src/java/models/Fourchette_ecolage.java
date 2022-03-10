package models;

import services.tableBD;

public class Fourchette_ecolage extends tableBD{
    String id;
    String idNiveau;
    Number montant_mensuelle;

    public Fourchette_ecolage() {
    }

    public String getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(String idNiveau) {
        this.idNiveau = idNiveau;
    }

    public Number getMontant_mensuelle() {
        return montant_mensuelle;
    }

    public void setMontant_mensuelle(Number montant_mensuelle) {
        this.montant_mensuelle = montant_mensuelle;
    }
    
    
}
