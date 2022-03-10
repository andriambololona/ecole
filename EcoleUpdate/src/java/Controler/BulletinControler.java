package Controler;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import services.NoteService;
import services.tableBD;

public class BulletinControler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String matricule = request.getParameter("matricule");
        String niveau = request.getParameter("niveau");
        HttpSession session = request.getSession();
        NoteService ns = new NoteService();

        try {
            List listNoteEleve = new ArrayList();
            List list = new ArrayList();
            String trimestre = request.getParameter("trimestre");
            if (!trimestre.equalsIgnoreCase("null")) {
                if (trimestre.equalsIgnoreCase("premier")) {
                    //session.setAttribute("premier", trimestre);
                    listNoteEleve = ns.getAllNoteEleve(matricule, niveau, "1");
                    tableBD[] premiere = (tableBD[]) listNoteEleve.get(0);
                    tableBD[] infoEleve = (tableBD[]) listNoteEleve.get(1);
                    /*double mo = (double) list.get(2);
                    String mention = (String) list.get(3);
                    String moyenne = "" + mo;*/
                    if (premiere.length == 0) {
                        session.setAttribute("listNote", null);
                        RequestDispatcher dispat = request.getRequestDispatcher("bulletin.jsp");
                        dispat.forward(request, response);
                    }
                    session.setAttribute("listNote", null);
                    //session.setAttribute("listPremier", listNoteEleve);
                    session.setAttribute("premiere", premiere);
                    session.setAttribute("InfoEleve", infoEleve);
                    session.setAttribute("moyenne", null);
                    session.setAttribute("mention", null);
                    RequestDispatcher dispat = request.getRequestDispatcher("bulletin.jsp");
                    dispat.forward(request, response);
                } else if (trimestre.equalsIgnoreCase("deuxieme")) {

                    listNoteEleve = ns.getAllNoteEleve(matricule, niveau, "2");
                    tableBD[] deuxieme = (tableBD[]) listNoteEleve.get(0);
                    tableBD[] infoEleve = (tableBD[]) listNoteEleve.get(1);
                    /*double mo = (double) list.get(2);
                    String mention = (String) list.get(3);
                    String moyenne = "" + mo;*/
                    if (deuxieme.length == 0) {
                        session.setAttribute("listNote", null);
                        RequestDispatcher dispat = request.getRequestDispatcher("bulletin.jsp");
                        dispat.forward(request, response);
                    }
                    session.setAttribute("listNote", null);
                    //session.setAttribute("listDeuxieme", listNoteEleve);
                    session.setAttribute("deuxieme", deuxieme);
                    session.setAttribute("InfoEleve", infoEleve);
                    session.setAttribute("moyenne", null);
                    session.setAttribute("mention", null);
                    RequestDispatcher dispat = request.getRequestDispatcher("bulletin.jsp");
                    dispat.forward(request, response);
                } else {

                    listNoteEleve = ns.getAllNoteEleve(matricule, niveau, "3");
                    tableBD[] troisieme = (tableBD[]) listNoteEleve.get(0);
                    tableBD[] infoEleve = (tableBD[]) listNoteEleve.get(1);
                    /*double mo = (double) list.get(2);
                    String mention = (String) list.get(3);
                    String moyenne = "" + mo;*/
                    if (troisieme.length == 0) {
                        session.setAttribute("listNote", null);
                        RequestDispatcher dispat = request.getRequestDispatcher("bulletin.jsp");
                        dispat.forward(request, response);
                    }
                    session.setAttribute("listNote", null);
                    //session.setAttribute("listTroisieme", listNoteEleve);
                    session.setAttribute("troisieme", troisieme);
                    session.setAttribute("InfoEleve", infoEleve);
                    session.setAttribute("moyenne", null);
                    session.setAttribute("mention", null);
                    RequestDispatcher dispat = request.getRequestDispatcher("bulletin.jsp");
                    dispat.forward(request, response);
                }
            } else {
                list = ns.getAllNoteAnneScolaire(matricule, niveau);
                tableBD[] listNote = (tableBD[]) list.get(0);
                tableBD[] infoEleve = (tableBD[]) list.get(1);
                double mo = (double) list.get(2);
                String mention = (String) list.get(3);
                String moyenne = "" + mo;
                if (listNote.length != 0) {
                    session.setAttribute("listNote", listNote);
                    session.setAttribute("InfoEleve", infoEleve);
                    session.setAttribute("moyenne", moyenne);
                    session.setAttribute("mention", mention);
                    RequestDispatcher dispat = request.getRequestDispatcher("bulletin.jsp");
                    dispat.forward(request, response);
                } else {
                    RequestDispatcher dispat = request.getRequestDispatcher("bulletin.jsp");
                    dispat.forward(request, response);
                }
            }

        } catch (Exception e) {
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
