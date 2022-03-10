/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Infoeleve;
import services.Ecolage;
import services.MonConnection;
import services.tableBD;

/**
 *
 * @author a
 */
public class PaiementEcolage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        HttpSession session = request.getSession();
        RequestDispatcher dispat = null;
        String nom = null;
        String nomC = null;
        if (request.getParameter("nomPaiement") != null || request.getParameter("nomCPaiement") != null) {
            nom = request.getParameter("nomPaiement");
            nomC = request.getParameter("nomCPaiement");

            if (nom != null) {
                session.setAttribute("nomPaiement", nom);
                dispat = request.getRequestDispatcher("paiementecolage.jsp");
                dispat.forward(request, response);
            } else {
                session.setAttribute("nomCPaiement", nomC);
                response.sendRedirect("paiementecolage.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        HttpSession session = request.getSession();
        Ecolage e = new Ecolage();
        String montant = request.getParameter("montant");
        String mois = request.getParameter("mois");
        System.out.println("montant : " + montant);
        RequestDispatcher dispat = null;
        if (montant != null) {
            if (session.getAttribute("nomPaiement") != null || session.getAttribute("nomCPaiement") != null) {
                if (session.getAttribute("nomPaiement") != null) {
                    String nom = (String) session.getAttribute("nomPaiement");
                    try {
                        e.paiementEcolage(montant, nom, mois);
                        Infoeleve ie = new Infoeleve();
                        MonConnection con = new MonConnection();
                        Connection connection = con.getConnection();
                        tableBD[] listComplet = ie.selectToTable(connection);
                        session.setAttribute("listComplet", listComplet);
                        dispat = request.getRequestDispatcher("home.jsp");
                        dispat.forward(request, response);
                    } catch (Exception ex) {
                        Logger.getLogger(EtudiantsControler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    String nomC = (String) session.getAttribute("nomCPaiement");
                    try {
                        e.paiementEcolage(montant, nomC, mois);
                        dispat = request.getRequestDispatcher("home.jsp");
                        dispat.forward(request, response);
                    } catch (Exception ex) {
                        Logger.getLogger(EtudiantsControler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
