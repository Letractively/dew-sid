/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sid.negocio;

import java.sql.SQLException;
import java.util.Collection;
import sid.modelo.Junta;
import sid.modelo.Visita;
import sid.persistencia.JuntaDAO;
import sid.persistencia.DAOExcepcion;
import sid.persistencia.ResidenteDAO;
import sid.persistencia.VisitaDAO;
/**
 *
 * @author Uwe.Mayo
 */
public class GestionJunta {
    
     public Junta insertar( int idresidente, String expositor, String tema, String fecha_ini, String fecha_fin , String acuerdo)throws DAOExcepcion {
        JuntaDAO dao = new JuntaDAO();
        Junta vo  = new Junta();
        vo.setIdresidente(idresidente);
        vo.setExpositor(expositor);
        vo.setTema(tema);
        vo.setFecha_ini(fecha_ini);
        vo.setFecha_fin(fecha_fin);
        vo.setAcuerdo(acuerdo);        
        return dao.insertar(vo);
        
     }
         
    public Collection<Junta> listar() throws DAOExcepcion{
      JuntaDAO dao = new JuntaDAO();
      return dao.listar();
    }
    
   public void eliminar(int idjunta) throws DAOExcepcion {  //Esto no es una funcion, es un procedimiento y no retorna nada, en este caso le envio un parametro
	JuntaDAO eli = new JuntaDAO();
	eli.eliminar(idjunta);
  }
    
    /* public Junta actualizar(int idjunta, int idresidente, String expositor, String tema, String fecha_ini, String fecha_fin , String acuerdo) throws DAOExcepcion{
     JuntaDAO re = new JuntaDAO();
     Junta vo = new Junta();
     vo.setIdjunta(idjunta);
     vo.setIdresidente(idresidente);
     vo.setExpositor(expositor);
     vo.setTema(tema);
     vo.setFecha_ini(fecha_ini);
     vo.setFecha_fin(fecha_fin);
     vo.setAcuerdo(acuerdo);     
     return re.actualizar(vo);
   }
     */
}
