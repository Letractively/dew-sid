/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sid.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sid.persistencia.DAOExcepcion;
import javax.security.auth.login.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import sid.modelo.Residente;
import sid.negocio.GestionResidente;

/**
 *
 * @author vladimir
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String correo = request.getParameter("email");
        String pass   = request.getParameter("password");
        String perfl= request.getParameter("perfil");
        
        GestionResidente negocio = new GestionResidente();  
        try{
            Residente vo = negocio.validar(correo, pass, perfl);
            HttpSession session = request.getSession();
            session.setAttribute("USUARIO_ACTUAL", vo);
            
            response.sendRedirect("PortadaServlet");
            return;
        }catch (DAOExcepcion e){
            request.setAttribute("MENSAJE","Hubo un error al procesar la operacion: " + e.getMessage());
        }catch(LoginException e){
            request.setAttribute("MENSAJE","Email y/o password incorrectos");
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
        
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
