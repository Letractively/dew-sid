package sid.negocio;

import java.sql.SQLException;
import java.util.Collection;

import sid.persistencia.ConexionDAO;
import sid.persistencia.DAOExcepcion;
import sid.modelo.Reserva;
import sid.persistencia.ReservaDAO;

public class GestionReserva {
 
  public Reserva insertar(String fecha,String hora,int idespaciocomun,int idresidente) throws DAOExcepcion{
      ReservaDAO dao = new ReservaDAO();
      Reserva vo = new Reserva();
      vo.setFecha(fecha);
      vo.setHora(hora);
      vo.setIdespaciocomun(idespaciocomun);
      vo.setIdresidente(idresidente);
      //
      Collection<Reserva> re = dao.buscarxfecha(fecha);
      if(re.size()>0){
          throw new DAOExcepcion("Reserva no disponible");
      }else{
        return dao.insertar(vo);
      }
  }
    



}