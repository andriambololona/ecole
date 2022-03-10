package services;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.ArrayList;
import models.Eleve;
import models.Infoeleve;
import models.Paiement_ecolage;

public class Ecolage {

    public Ecolage() {
    }

    public ArrayList findMulticritereElevePaiementNonRegle(String nivea, String matricule, String annee) throws Exception {
        ArrayList<Object[]> retour = new ArrayList<>();
        String sqlRequest = "select * from infoeleve where 1=1 ";
        if (nivea != null) {
            sqlRequest = sqlRequest.concat(" and niveau = '" + nivea + "' ");
        }
        if (matricule != null) {
            sqlRequest = sqlRequest.concat("and ideleve= '" + matricule + "' ");
        }
        if (annee != null) {
            sqlRequest = sqlRequest.concat("and annee_scolaire = '" + annee + "'");
        }
        MonConnection con = new MonConnection();
        Connection connection = con.getConnection();
        Infoeleve ie = new Infoeleve();

        tableBD[] resultat = null;
        try {
            resultat = ie.selectToTable(connection, sqlRequest);
            
        } catch (Exception z) {
        }
        retour.add(resultat);
        return retour;
    }

    public void paiementEcolage(String montant, String nomP, String moisP) throws Exception {
        MonConnection con = new MonConnection();
        Connection connection = con.getConnection();

        String sqlRequest = "select * from eleve where prenom ='" + nomP + "'";
        Eleve e = new Eleve();
        tableBD[] eleve = e.selectToTable(connection,sqlRequest);
        String id = ((Eleve) eleve[0]).getId();
        
        Infoeleve ie = new Infoeleve();
        String sqlRequest0 = "select * from infoeleve where ideleve='" + id + "'";
        tableBD[] info = ie.selectToTable(connection, sqlRequest0);
        String annescolaire = ((Infoeleve) info[0]).getAnnee_scolaire();
        String classe = ((Infoeleve) info[0]).getNiveau();
        String idfourcette;
        if("Terminale".equalsIgnoreCase(classe)){
            idfourcette = "3";
        }else if("Seconde".equalsIgnoreCase(classe)){
            idfourcette = "2";
        }else{
            idfourcette = "1";
        }
        
        Paiement_ecolage nouveau = new Paiement_ecolage(id, idfourcette, 1  , annescolaire, moisP);
        nouveau.insertToTable(connection);
        
    }
}
