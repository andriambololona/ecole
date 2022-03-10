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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Infoeleve;
import services.Ecolage;
import services.MonConnection;
import services.tableBD;

public class EtudiantsControler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();        
        HttpSession list = request.getSession(true);
        RequestDispatcher dispat = null;
        try {
            processRequest(request, response);
            MonConnection con = new MonConnection();
            Connection connection = con.getConnection();
            Infoeleve ie = new Infoeleve();
            tableBD[] listComplet = ie.selectToTable(connection);
            list.setAttribute("listComplet", listComplet);
            dispat = request.getRequestDispatcher("home.jsp");
            dispat.forward(request, response);
            
        } catch (Exception ex) {
            out.print(ex.getStackTrace());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        RequestDispatcher dispat = null;
        HttpSession session = request.getSession(true);
        Ecolage e = new Ecolage();

        // Critere de recherche
        String nivea = request.getParameter("niveau");
        String matricule = request.getParameter("matricule");
        String annee = request.getParameter("annee");
        String mois = request.getParameter("mois");
        
        if (!"null".equals(nivea) || !"null".equals(annee) || !"null".equals(mois) || !"null".equals(matricule)) {
            try {
                ArrayList avecCritere = e.findMulticritereElevePaiementNonRegle(nivea, matricule, annee);
                tableBD[] critere = (tableBD[]) avecCritere.get(0);
                if (critere.length == 0) {
                    MonConnection con = new MonConnection();
                    Connection connection = con.getConnection();
                    Infoeleve ie = new Infoeleve();
                    tableBD[] listComplet = ie.selectToTable(connection);
                    String size = "empty";
                    session.setAttribute("size", size);
                    session.setAttribute("listComplet", listComplet);
                    dispat = request.getRequestDispatcher("home.jsp");
                    dispat.forward(request, response);
                } else {                    
                    session.setAttribute("listCritere", critere);
                    dispat = request.getRequestDispatcher("home.jsp");
                    dispat.forward(request, response);
                }
            } catch (Exception ex) {
                Logger.getLogger(EtudiantsControler.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            dispat = request.getRequestDispatcher("home.jsp");
            dispat.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
