package sid.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sid.modelo.Reserva;

import sid.negocio.GestionReserva;
import sid.persistencia.DAOExcepcion;

/**
 *
 * @author vladimir
 */
@WebServlet(name = "RealizarReservaServlet", urlPatterns = {"/RealizarReservaServlet"})
public class RealizarReservaServlet extends HttpServlet {

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
        //processRequest(request, response);
        String fecha  = request.getParameter("fechar");
        String hora   = request.getParameter("horar");
        String tpo    = request.getParameter("nhoras");     //int
        int tiempo  = Integer.parseInt(tpo);
        String idesp  = request.getParameter("espaciocomun");//int
        String id_esp = idesp.replace("\r\n", "");
        int codesp    = Integer.parseInt(id_esp);
        String idres  = request.getParameter("codresidente");
        int codres    = Integer.parseInt(idres);
        int state = 1;
        
        GestionReserva reserva = new GestionReserva();
        PrintWriter out = response.getWriter();
        try{
            reserva.insertar(fecha, hora, tiempo, codesp, codres, state);
            out.print("ok");
        }catch(DAOExcepcion e){
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
            out.print("errores");
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
