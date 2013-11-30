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
import sun.swing.PrintColorUIResource;

/**
 *
 * @author vladimir
 */
@WebServlet(name = "InsertarResidenteServlet", urlPatterns = {"/InsertarResidenteServlet"})
public class InsertarResidenteServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

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
        //processRequest(request, response);
       
        String nom = request.getParameter("nombre");
        String ape = request.getParameter("apellido");
        String pwd = request.getParameter("contrasena");
        String doc = request.getParameter("identificacion");
        String mail= request.getParameter("email");
        String fech= request.getParameter("fechanac");
        
        GestionResidente residente = new GestionResidente();
        
        try{
            residente.insertar(nom, ape, doc, fech, mail, pwd);
            //response.sendRedirect(request.getContextPath() + "/PortadaServlet");
            PrintWriter ou = response.getWriter();
            ou.print("ok");
          
            
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
