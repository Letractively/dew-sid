package sid.negocio;

import java.sql.SQLException;
import java.util.Collection;
import sid.modelo.Vivienda;
import sid.persistencia.ViviendaDAO;
import sid.persistencia.DAOExcepcion;

public class GestionVivienda{
    
public Vivienda insertar(String zona,String edificio,String numero,double metraje,String tipo,String direccion,int idresidente) throws DAOExcepcion{
    ViviendaDAO dao = new ViviendaDAO();
    Vivienda     vo = new Vivienda();
    vo.setZona(zona);
    vo.setEdificio(edificio);
    vo.setNumero(numero);
    vo.setMetraje(metraje);
    vo.setTipo(tipo);
    vo.setDireccion(direccion);
    vo.setIdresidente(idresidente);
    Collection<Vivienda> rs = dao.buscarxnumero(numero);
    if(rs.size()>0){
        throw new DAOExcepcion("vivienda registrada");
    }else{       
    return dao.insertar(vo);
    }
}    
    
}