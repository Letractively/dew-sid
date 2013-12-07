/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sid.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sid.modelo.Visita;
import sid.negocio.GestionVisita;
import sid.persistencia.DAOExcepcion;

/**
 *
 * @author uwe.mayo
 */
@WebServlet(name = "InsertarVisitaServlet", urlPatterns = {"/InsertarVisitaServlet"})
public class InsertarVisitaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertarVisitaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertarVisitaServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int dnivisita = Integer.parseInt(request.getParameter("dnivisita"));
        String nomvisita = request.getParameter("nomvisita");
        String fechvisita = request.getParameter("fechvisita");
        String horavisita = request.getParameter("horavisita");
        String fechavisita = fechvisita + " " + horavisita;
        int idvisitado = Integer.parseInt(request.getParameter("idvisitado"));
        
        PrintWriter ou = response.getWriter();        
        GestionVisita negocio = new GestionVisita();
		
        try {
		negocio.insertar(dnivisita, nomvisita, fechavisita, idvisitado);
                System.out.println("aqui llega");
                ou.print("ok");
		//response.sendRedirect(request.getContextPath()	+ "/ListarVisitaServlet");
		
        } catch (DAOExcepcion e) {
		RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
		rd.forward(request, response);		
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
