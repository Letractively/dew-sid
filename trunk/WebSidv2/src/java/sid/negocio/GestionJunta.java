/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sid.negocio;

import java.sql.SQLException;
import java.util.Collection;
import sid.modelo.Junta;
import sid.persistencia.JuntaDAO;
import sid.persistencia.DAOExcepcion;
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
