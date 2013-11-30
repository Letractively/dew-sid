/*
 * To change this template, choose Tools | Templates
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

import sid.negocio.GestionResidente;
import sid.persistencia.DAOExcepcion;

/**
 *
 * @author proyecto
 */
@WebServlet(name = "ActualizarResidenteServlet", urlPatterns = {"/ActualizarResidenteServlet"})
public class ActualizarResidenteServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

    /** 
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // processRequest(request, response);
        
        String id   = request.getParameter("codeupdate");
        //System.out.println(id);
        int     code = Integer.parseInt(id);                     //request.getParameter("codeupdate");
        String nom   = request.getParameter("nomupdate");
        String ape   = request.getParameter("apeupdate");
        String pwd   = request.getParameter("pwdupdate");
        String doc   = request.getParameter("idenupdate");
        String mail  = request.getParameter("mailupdate");
        String fech  = request.getParameter("fecupdate");
        
        GestionResidente residente = new GestionResidente();
        try{
            residente.actualizar(code, nom, ape, doc, fech, mail, pwd);
            PrintWriter ou = response.getWriter();
            ou.print("okis");
        }catch(DAOExcepcion e){
           RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
           rd.forward(request, response);
        }
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
