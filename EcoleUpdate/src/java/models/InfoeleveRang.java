/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import services.MonConnection;
import services.tableBD;

/**
 *
 * @author a
 */
public class InfoeleveRang extends Infoeleve {

    public InfoeleveRang() {
        super();
    }
    
    public List getNiveauEleve(String annee) throws Exception{
        MonConnection con = new MonConnection();
        Connection connection = con.getConnection();
        Infoeleve ie = new Infoeleve();
        String sqlRequest = "select * from infoeleve where anne_scolaire='" + annee + "'";
        tableBD[] list = ie.selectToTable(connection, sqlRequest);
        List retour = new ArrayList();
        retour.add(list);
        return retour   ;     
    }

}
