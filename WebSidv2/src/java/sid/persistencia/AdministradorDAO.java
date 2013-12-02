package sid.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.security.auth.login.LoginException;

import sid.modelo.Administrador;
import sid.persistencia.DAOExcepcion;
import sid.persistencia.ConexionDAO;

public class AdministradorDAO extends BaseDAO{

public Administrador validar(String email,String password,String perfil) throws DAOExcepcion, LoginException{
    String query   = "SELECT id,nombre,apellido,email,perfil,estado FROM administrador WHERE email=? AND password=? AND perfil=?";
    Connection con         = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Administrador vo = new Administrador();
    try{
        con = ConexionDAO.obtenerConexion();
        stmt= con.prepareStatement(query);
        //stmt.setInt(1, id);
        stmt.setString(1, email);
        stmt.setString(2, password);//
        stmt.setString(3, perfil);
        rs = stmt.executeQuery();
        
        if(rs.next()){
            vo.setId(rs.getInt("id"));
            vo.setNombre(rs.getString("nombre"));
            vo.setApellido(rs.getString("apellido"));
            vo.setEmail(rs.getString("email"));
            vo.setPerfil(rs.getString("perfil"));
            vo.setEstado(rs.getInt("estado"));
        }else{
            throw new LoginException("No existe");
        }
    }catch(LoginException e){
        System.err.println(e.getMessage());
        throw  new LoginException(e.getMessage());
    }catch(SQLException e){
        System.err.println(e.getMessage());
        throw new DAOExcepcion(e.getMessage());
    }finally{
        this.cerrarResultSet(rs);
        this.cerrarStatement(stmt);
        this.cerrarConexion(con);
    }
    return vo;
    
}
    
    //SELECT id,nombre,apellido,email,estado FROM administrador WHERE email='vflores_web@hotmail.com' AND password='654321' AND perfil=1
}
