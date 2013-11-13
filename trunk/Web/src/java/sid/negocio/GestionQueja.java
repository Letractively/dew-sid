package sid.negocio;

import java.sql.SQLException;
import java.util.Collection;
import sid.persistencia.ResidenteDAO;
import sid.persistencia.DAOExcepcion;
import sid.modelo.Queja;
import sid.persistencia.QuejaDAO;

public class GestionQueja { //aqui va la regla de negocio
    
    public Queja insertQueja(String tipo_queja,String motivo,String fech_queja,int idresidente, String estado)throws DAOExcepcion {
        QuejaDAO dao = new QuejaDAO();
        Queja    vo  = new Queja();
        vo.setTipo_queja(tipo_queja);
        vo.setMotivo(motivo);
        vo.setFech_queja(fech_queja);
        vo.setIdresidente(idresidente);
        vo.setEstado(estado);
        return dao.insertar(vo);    
     }
    
    
 
   
   public Collection<Queja> Listaquejas(int idresidente) throws DAOExcepcion{
      QuejaDAO dao = new QuejaDAO();
      return dao.Listarquejas(idresidente);
  }
       
}
