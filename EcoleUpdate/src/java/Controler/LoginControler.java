package Controler;

import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import services.LoginResponsable;


public class LoginControler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        

        RequestDispatcher dispat = null;
        String nom = request.getParameter("id");
        String password = request.getParameter("password");
        LoginResponsable responsable = new LoginResponsable();

        try {
            boolean log = responsable.verificationLogin(nom, password);
            if (log) {
                response.sendRedirect("EtudiantsControler");
            } else {
                dispat = request.getRequestDispatcher("index.jsp");
                dispat.forward(request, response);
            }
        } catch (Exception ex) {
            out.print(ex.getCause());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
