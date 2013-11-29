package sid.negocio;

import java.sql.SQLException;
import java.util.Collection;
import javax.security.auth.login.LoginException;
import sid.persistencia.AdministradorDAO;
import sid.persistencia.DAOExcepcion;
import sid.modelo.Administrador;

public class GestionAdministrador{

public Administrador validar(String email,String password) throws DAOExcepcion,LoginException{
   AdministradorDAO dao = new AdministradorDAO();
   return dao.validar(email, password);
}
    
    
}
