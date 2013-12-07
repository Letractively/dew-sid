/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sid.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sid.negocio.GestionJunta;
import sid.persistencia.DAOExcepcion;

/**
 *
 * @author uwe.mayo
 */
@WebServlet(name = "InsertarJuntaServlet", urlPatterns = {"/InsertarJuntaServlet"})
public class InsertarJuntaServlet extends HttpServlet {

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
            out.println("<title>Servlet InsertarJunta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertarJunta at " + request.getContextPath() + "</h1>");
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
        int idresidente = Integer.parseInt(request.getParameter("idresidente"));
        String expositor = request.getParameter("expositor");
        String tema = request.getParameter("tema");
        String date_ini = request.getParameter("fecha_ini");
        String hora_ini = request.getParameter("hora_ini");
        String fecha_ini = date_ini + " " + hora_ini;
        String date_fin = request.getParameter("fecha_fin");
        String hora_fin = request.getParameter("hora_fin");
        String fecha_fin = date_fin + " " + hora_fin;
        String acuerdo = request.getParameter("acuerdo");
        
        PrintWriter ou = response.getWriter();       
        GestionJunta negocio = new GestionJunta();
		
        try {
		negocio.insertar(idresidente, expositor, tema, fecha_ini, fecha_fin, acuerdo);                
                ou.print("ok");
				
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
