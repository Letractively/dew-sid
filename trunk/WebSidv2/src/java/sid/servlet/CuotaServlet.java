/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sid.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sid.negocio.GestionCuota;
import sid.modelo.Cuota;
import sid.persistencia.DAOExcepcion;
/**
 *
 * @author proyecto
 */
@WebServlet(name = "CuotaServlet", urlPatterns = {"/CuotaServlet"})
public class CuotaServlet extends HttpServlet {

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
/*
        try {
            HttpSession sesion = request.getSession();
            Collection<Cuota> arraycuota;
            arraycuota = new GestionCuota().listarvencidas();
            sesion.setAttribute("id", arraycuota);
        } catch (DAOExcepcion ex) {
            Logger.getLogger(CuotaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
		*/
               
                	

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
       
        int idvivienda = Integer.parseInt(request.getParameter("idvivienda")) ;
        int idcuota    = Integer.parseInt(request.getParameter("idcuota"));
        String tipopago = request.getParameter("identificacion");
        
        GestionCuota cuota = new GestionCuota();
        Cuota objcuota = new Cuota();
        objcuota.setIdCuotas(idcuota);
        objcuota.setidvivienda(idvivienda);
       
        
        try{
            cuota.actualizarpago(tipopago, idvivienda,idcuota);
           
            PrintWriter ou = response.getWriter();
            ou.print("ok");
          
            
        }catch(DAOExcepcion e){
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
