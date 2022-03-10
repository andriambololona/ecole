package models;

import services.tableBD;
import java.sql.Connection;
import java.sql.SQLException;
import services.MonConnection;

public class Responsable extends tableBD {

    String id;
    String mot_de_passe;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }
}
