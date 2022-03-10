package models;

import services.tableBD;

public class Note extends tableBD{
    String id;
    String idEleve;
    String idMatiere;
    Number noteeleve;
    String idtrimestre;

    public Note(String idEleve, String idMatiere, Number noteeleve, String idtrimestre) {
        this.idEleve = idEleve;
        this.idMatiere = idMatiere;
        this.noteeleve = noteeleve;
        this.idtrimestre = idtrimestre;
    }        

    public Number getNoteeleve() {
        return noteeleve;
    }

    public void setNoteeleve(Number noteeleve) {
        this.noteeleve = noteeleve;
    }

    public String getIdtrimestre() {
        return idtrimestre;
    }

    public void setIdtrimestre(String idtrimestre) {
        this.idtrimestre = idtrimestre;
    }

    public Note() {
    }

    public Note(String idEleve, String idMatiere) {
        this.idEleve = idEleve;
        this.idMatiere = idMatiere;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(String idEleve) {
        this.idEleve = idEleve;
    }

    public String getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(String idMatiere) {
        this.idMatiere = idMatiere;
    }
    
    
}
