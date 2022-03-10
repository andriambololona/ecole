/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import models.Responsable;
import services.MonConnection;
import services.tableBD;

/**
 *
 * @author a
 */
public class LoginResponsable{

    public LoginResponsable() {
        super();
    }
    
    public boolean verificationLogin(String id, String password) throws Exception {
        MonConnection con = new MonConnection();
        Connection connection = con.getConnection();
        Responsable r = new Responsable();
        
        String sqlRequest0 = "SELECT * FROM responsable where id = '" + id + "' and mot_de_passe = '" + password + "'";
        tableBD[] listResponsable = null;
        try {
            System.out.println("mandalo eto");
            listResponsable = r.selectToTable(connection, sqlRequest0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (listResponsable.length == 0) {
            System.out.println("length false: " + listResponsable.length);
            return false;
        } else {
            System.out.println("length : " + listResponsable.length);
            String idLogin = ((Responsable) listResponsable[0]).getId();
            String passwordLogin = ((Responsable) listResponsable[0]).getMot_de_passe();
            System.out.println("idLogin : " + idLogin);
            System.out.println("password : " + passwordLogin);
            if (idLogin.equals(id) && passwordLogin.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
