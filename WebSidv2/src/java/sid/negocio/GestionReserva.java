package sid.negocio;

import java.sql.SQLException;
import java.util.Collection;

import sid.persistencia.ConexionDAO;
import sid.persistencia.DAOExcepcion;
import sid.modelo.Reserva;
import sid.persistencia.ReservaDAO;

public class GestionReserva {
 
  public Reserva insertar(String fecha,String hora,int tiempo,int idespaciocomun,int idresidente,int estado) throws DAOExcepcion{
      ReservaDAO dao = new ReservaDAO();
      Reserva vo = new Reserva();
      vo.setFecha(fecha);
      vo.setHora(hora);
      vo.setTiempo(tiempo);
      vo.setIdespaciocomun(idespaciocomun);
      vo.setIdresidente(idresidente);
      vo.setEstado(estado);
      //
      Collection<Reserva> re = dao.buscarxfecha(fecha, hora);   //dao.buscarxfecha(fecha);
      if(re.size()>0){
          throw new DAOExcepcion("Reserva no disponible");
      }else{
        return dao.insertar(vo);
      }
  }
  
  public Collection<Reserva> listar() throws DAOExcepcion{
      ReservaDAO dao = new ReservaDAO();
      return dao.listareservas();
  }
  
  public Collection<Reserva> misreservas(int cod) throws DAOExcepcion{
      ReservaDAO dao = new ReservaDAO();
      return dao.misreservas(cod);
  }
  
  public Collection<Reserva> buscaxfecha(String fecha,String hora) throws DAOExcepcion{
      ReservaDAO dao = new ReservaDAO();
      return dao.buscarxfecha(fecha, hora);
  }
  
  public void eliminar(int idReserva) throws DAOExcepcion{
      ReservaDAO del = new ReservaDAO();
      del.eliminar(idReserva);
  }
    
}