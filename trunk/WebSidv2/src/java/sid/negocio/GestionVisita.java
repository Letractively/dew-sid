/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sid.negocio;

import java.sql.SQLException;
import java.util.Collection;
import sid.modelo.Residente;
import sid.persistencia.VisitaDAO;
import sid.persistencia.DAOExcepcion;
import sid.modelo.Visita;
import sid.persistencia.ResidenteDAO;
/**
 *
 * @author Uwe.Mayo
 */
public class GestionVisita {
    
    public Visita insertar(int dni_visita, String nombre, String fech_visita, int idresidente)throws DAOExcepcion {
        VisitaDAO dao = new VisitaDAO();
        Visita vo  = new Visita();
        vo.setDni_visita(dni_visita);
        vo.setNombre(nombre);
        vo.setFech_visita(fech_visita);
        vo.setIdresidente(idresidente);
        
        return dao.insertar(vo);    
        
     }
    
     public Visita actualizar(int idvisita, int dni_visita, String nombre, String fech_visita, int idresidente) throws DAOExcepcion{
     VisitaDAO re = new VisitaDAO();
     Visita vo = new Visita();
     vo.setIdvisita(idvisita);
     vo.setDni_visita(dni_visita);
     vo.setNombre(nombre);
     vo.setFech_visita(fech_visita);
     vo.setIdresidente(idresidente);
     
     return re.actualizar(vo);
   }
     
     public void eliminar(int idvisita) throws DAOExcepcion {
     VisitaDAO eli = new VisitaDAO();
     eli.eliminar(idvisita);
   }
     
  public Collection<Visita> listar(int idresidente) throws DAOExcepcion{
      VisitaDAO dao = new VisitaDAO();
      return dao.listar(idresidente);
  }
         
}
