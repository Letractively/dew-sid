/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sid.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.catalina.Session;
import org.apache.catalina.connector.Response;
import sid.negocio.GestionCuota;
import sid.modelo.Cuota;
import sid.persistencia.DAOExcepcion;
/**
 *
 * @author proyecto
 */
@WebServlet(name = "CuotaServlet", urlPatterns = {"/CuotaServlet"})
public class CuotaServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet  {

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

//        try {
//            String accion   = request.getParameter("accion").toString();
//            if ("1".equals(accion)){
//                 int idresidente    = Integer.parseInt(request.getParameter("idresidente"));
//                 HttpSession sesion = request.getSession();
//                 sesion.setAttribute("vidresidente", idresidente);
//                 
//                 
//              }
//             
//            
//         
//            
//            
//        }
//        catch (Exception e) {
//            
//            
//         }
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
        
        //aca registro el pago
       String accion   = request.getParameter("accion");
       
       if ("1".equals(accion)){
                 int idresidente    = Integer.parseInt(request.getParameter("idresidente"));
                 String nombre_residente    = request.getParameter("nombres");
                 HttpSession sesion = request.getSession();
                 sesion.setAttribute("sidresidente", idresidente);
                 sesion.setAttribute("snombre_residente", nombre_residente);
                 
                 PrintWriter ou = response.getWriter();
                 ou.print("ok");
        
       }
       else if ("2".equals(accion)){
                 String idvivienda    = request.getParameter("vidvivienda");
                 String vivienda    = request.getParameter("vdireccion");
                 HttpSession sesion = request.getSession();
                 //request.getSession().removeAttribute("sidvivienda");
                 sesion.setAttribute("sidvivienda", idvivienda);
                 sesion.setAttribute("svivienda", vivienda);
             } 
       else if ("3".equals(accion)){
            int idcuota    = Integer.parseInt(request.getParameter("idcuotas"));
            String tipopago = request.getParameter("identificacions");

            GestionCuota cuota = new GestionCuota();

            try{
                Cuota objcuota = new Cuota();
                objcuota = cuota.actualizarpago(tipopago,idcuota);
                
                //obtenemos la fecha de pago
                HttpSession sesion = request.getSession();
                 request.getSession().removeAttribute("vidresidente");
                 sesion.setAttribute("fecha_pago", objcuota.getfech_pago());

                PrintWriter ou = response.getWriter();
                ou.print("ok" + ";" + objcuota.getfech_pago() );
                

            }catch(DAOExcepcion e){
               //RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
               //rd.forward(request, response);
                 PrintWriter ou = response.getWriter();
                ou.print("error" );
            }
        }
       //registrar las cuotas a generar
       else if ("4".equals(accion)){
            int anio    = Integer.parseInt(request.getParameter("vanio"));
            String importe = request.getParameter("vimporte");
            String fechavenc = request.getParameter("vfechavenc");
            String identificacion = request.getParameter("videntificacion");
            String desde = request.getParameter("vdesde");
            String hasta = request.getParameter("vhasta");
            
            String idvivienda = "";
            HttpSession sesion = request.getSession();
            if (sesion.getAttribute("sidvivienda") != null){
                idvivienda = sesion.getAttribute("sidvivienda").toString().trim()  ;
            }
            else{
                PrintWriter ou = response.getWriter();
                ou.print("nose ha seleccionado el residente o la vivienda");
                return;
            }
                
            GestionCuota cuota = new GestionCuota();

            try{
                Cuota objcuota = new Cuota();
                int x = 0;
                for(x=Integer.parseInt(desde); x<=Integer.parseInt(hasta); x=x+1)
                {
                    objcuota = cuota.insertar(Integer.parseInt(idvivienda), String.format("%02d", Integer.parseInt(String.valueOf(x))), anio, Double.parseDouble(importe), fechavenc, "P", null, null, identificacion);
                }
                //obtenemos la fecha de pago

                PrintWriter ou = response.getWriter();
                ou.print("ok");
                

            }catch(DAOExcepcion e){
               //RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
               //rd.forward(request, response);
                 PrintWriter ou = response.getWriter();
                ou.print("error al grabar" );
            }
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
