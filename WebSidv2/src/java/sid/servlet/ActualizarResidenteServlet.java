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
        PrintWriter ou = response.getWriter();
        
        String codigo   = request.getParameter("codeupdate"); //Aqui esta el problema, que nose porq no me esta convirtiendo la data
        String cod      = codigo.replace("\r\n", "");
        //ou.print(codigo);
        int code = Integer.parseInt(cod);
        String nom   = request.getParameter("nomupdate");
        String ape   = request.getParameter("apeupdate");
        String pwd   = request.getParameter("pwdupdate");
        String doc   = request.getParameter("idenupdate");
        String nrodoc= request.getParameter("numdocupdate");
        String mail  = request.getParameter("mailupdate");
        String fech  = request.getParameter("fecupdate");
        
        GestionResidente residente = new GestionResidente();
        try{
            residente.actualizar(code, nom, ape, doc, nrodoc, fech, mail, pwd); //residente.actualizar(code, nom, ape, doc, fech, mail, pwd);
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

    private String trim(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
