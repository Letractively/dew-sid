package sid.negocio;
import java.sql.SQLException;
import java.util.Collection;
import sid.persistencia.ResidenteDAO;
import sid.persistencia.DAOExcepcion;
import sid.modelo.EspacioComun;
import sid.persistencia.EspacioComunDAO;

public class GestionEspacioComun{
    public Collection<EspacioComun> listado() throws DAOExcepcion{
      EspacioComunDAO dao = new EspacioComunDAO();
      return dao.listado();
  }
    
}
