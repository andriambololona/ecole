package services;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Infoeleve;
import models.Noteeleve;
import models.Note;
import models.Trimestre;

public class NoteService {

    public NoteService() {
    }

    public void insertNote(String matricule, String idMatiere, Number note) throws Exception {
        MonConnection con = new MonConnection();
        Connection connection  = con.getConnection();
        Note n = new Note(matricule,idMatiere,note,"1");
        n.insertToTable(connection);
    }

    public List getAllNoteAnneScolaire(String ideleve, String idniveau) throws Exception {
        MonConnection con = new MonConnection();
        Connection connection = con.getConnection();
        Noteeleve ne = new Noteeleve();
        List listNote = new ArrayList();
        String sqlRequest = "select * from noteeleve where nummatricule='" + ideleve + "' and niveau='" + idniveau + "'";
        tableBD[] infoNote = ne.selectToTable(connection, sqlRequest);
        String idTrim = ((Noteeleve) infoNote[0]).getIdtrimestre();

        if (infoNote.length == 0) {
            System.out.println("Tsy misy");
            return listNote;
        }

        Infoeleve ie = new Infoeleve();
        String sqlRequest0 = "select * from infoeleve where ideleve='" + ideleve + "'";
        tableBD[] infoEleve = ie.selectToTable(connection, sqlRequest0);

        listNote.add(infoNote);
        listNote.add(infoEleve);
        if (infoNote != null) {
            double moy = moyenneEleve(ideleve, idniveau, idTrim);
            String mention = MeriteMoyenne(moy);
            listNote.add(moy);
            listNote.add(mention);
        }
        return listNote;
    }

    public double moyenneEleve(String id, String idniveau, String idtrimestre) throws Exception {

        MonConnection con = new MonConnection();
        Connection connection = con.getConnection();
        Noteeleve ne = new Noteeleve();

        String sqlRequest0 = "select * from noteeleve where nummatricule='" + id + "' and niveau='" + idniveau + "'";
        //String sqlRequest = "select (AVG((noteeleve)*noteeleve.coefficient))/"
          //      + "count(nom_matiere) as moyenne from noteeleve where nummatricule='" + id + "' and niveau='" + idniveau + "' and idtrimestre='" + idtrimestre + "'";

        tableBD[] l = ne.selectToTable(connection, sqlRequest0);
        int somme = 0;
        for (tableBD l1 : l) {
            String no = "" + ((Noteeleve) l1).getNoteeleve();
            int note = Integer.parseInt(no);
            String co = "" + ((Noteeleve) l1).getCoefficient();
            int coefficient = Integer.parseInt(co);
            somme += note * coefficient;
        }
        double m = somme / l.length;
        double moyenne = m / l.length;
        System.out.println("moyenne : " + moyenne);
        return moyenne;
    }
    
    public String MeriteMoyenne(double moyenne){
        String mention = "";
        if(moyenne>=10 && moyenne<12){
            mention = mention.concat("Passable");
        }else if(moyenne>=12 && moyenne<14){
            mention = mention.concat("Assez Bien");
        }else if(moyenne>=14 && moyenne<16){
            mention = mention.concat("Bien");            
        }else if(moyenne>16 && moyenne<18){
            mention = mention.concat("Tres Bien");
        }else if(moyenne <8){
            mention = mention.concat("Redouble");
    }else{
            mention = mention.concat("Excelent");
        }
        return mention;
    }
    
    public double moyenneAnneScolaire(String ideleve, String idniveau) throws Exception{
        MonConnection con = new MonConnection();
        Connection connection = con.getConnection();
        Trimestre tr = new Trimestre();
        double moyenne =0;
        
        tableBD[] trim = tr.selectToTable(connection);
        for(int i = 0; i < trim.length; i++) {
            String nomTrimestre = ((Trimestre) trim[i]).getNom();
            moyenne += moyenneEleve(ideleve, idniveau, nomTrimestre);
        }
        return moyenne;
    }
    
    public String meriteAnneeScolaire(String ideleve, String idniveau) throws Exception{
        double moyenne = moyenneAnneScolaire(ideleve, idniveau);
        String merite = MeriteMoyenne(moyenne);
        return merite;
    }

    public List getAllNoteEleve(String ideleve, String idniveau,String idtrimestre) throws Exception{
        MonConnection con = new MonConnection();
        Connection connection = con.getConnection();
        String sqlRequest = "select * from noteeleve where nummatricule='" + ideleve + "' and niveau= '" + idniveau + "' and idtrimestre = '" + idtrimestre + "'";
        Noteeleve ne = new Noteeleve();
        List listRetour = new ArrayList();
        tableBD[] listNote = ne.selectToTable(connection, sqlRequest);
        
        Infoeleve ie = new Infoeleve();
        String sqlRequest0 = "select * from infoeleve where ideleve='" + ideleve + "'";
        tableBD[] infoEleve = ie.selectToTable(connection, sqlRequest0);
        
        listRetour.add(listNote);
        listRetour.add(infoEleve);
        
        if (listNote != null) {
            double moy = moyenneEleve(ideleve, idniveau, idtrimestre);
            String mention = MeriteMoyenne(moy);
            listRetour.add(moy);
            listRetour.add(mention);
        }
        
        return listRetour;
    }
    
}
