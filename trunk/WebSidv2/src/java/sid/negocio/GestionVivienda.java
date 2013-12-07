package sid.negocio;

import java.sql.SQLException;
import java.util.Collection;
import sid.modelo.Vivienda;
import sid.persistencia.ViviendaDAO;
import sid.persistencia.DAOExcepcion;

public class GestionVivienda{
    
public Vivienda insertar(String tipoVivienda,String tipoUbicacion, String ubicacion, String numero,double metraje,int idresidente) throws DAOExcepcion{
    ViviendaDAO dao = new ViviendaDAO();
    Vivienda     vo = new Vivienda();
    
    vo.setTipoVivienda(tipoVivienda);
    vo.setTipoUbicacion(tipoUbicacion);
    vo.setUbicacion(ubicacion);
    vo.setNumero(numero);
    vo.setMetraje(metraje);
    vo.setIdresidente(idresidente);
    Collection<Vivienda> rs = dao.buscarxnumero(numero);
    if(rs.size()>0){
        throw new DAOExcepcion("Vivienda Registrada");
    }else{       
    return dao.insertar(vo);
    }
}    

public Collection<Vivienda> listarViviendas() throws DAOExcepcion{
    ViviendaDAO dao = new ViviendaDAO();
    return dao.listarViviendas();
}
 public Collection<Vivienda> listarviviendaporresidente(int idresidente) throws DAOExcepcion{
      ViviendaDAO dao = new ViviendaDAO();
      return dao.listarviviendaporresidente(idresidente);
  }
    
 public void eliminarVivienda(int idresidente, int idvivienda) throws DAOExcepcion{
     ViviendaDAO dao = new ViviendaDAO();
     dao.eliminarVivienda(idresidente, idvivienda);
 }
 
}