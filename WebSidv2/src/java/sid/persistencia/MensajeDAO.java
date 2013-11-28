package sid.persistencia;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sid.modelo.Mensaje;
import sid.persistencia.ConexionDAO;
import sid.persistencia.DAOExcepcion;

public class MensajeDAO extends BaseDAO{
    
    public Mensaje insertar(Mensaje obj) throws DAOExcepcion{
        String query = "INSERT INTO mensaje(titulo,descripcion,fecha,estado)VALUES(?,?,?,?)";
        Connection con         = null;
        PreparedStatement stmt = null;
        ResultSet rs           = null;
        try{
            con = ConexionDAO.obtenerConexion();
            stmt= con.prepareStatement(query);
            stmt.setString(1,obj.getTitulo());
            stmt.setString(2, obj.getDescripcion());
            stmt.setString(3, obj.getFecha());
            stmt.setInt(4, obj.getEstado());
            
            int longitud = obj.getDescripcion().length();  
            if(longitud<140){
                 int i = stmt.executeUpdate();
            }else{
                throw new DAOExcepcion("El contenido debe ser menor a 140"); 
            }
            
            /*if(i!=1){
                throw new SQLException("Error, no se pudo insertar mensaje");
            }*/
            int id=0;
            query = "select last_insert_id()";
            stmt  = con.prepareStatement(query);
            rs    = stmt.executeQuery();
            if (rs.next()) {
		id = rs.getInt(1);
            }
            obj.setCod(id);
        }catch(SQLException e){
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
        }finally{
            this.cerrarResultSet(rs);
            this.cerrarConexion(con);
            this.cerrarStatement(stmt);
        }
           
            String cont = obj.getDescripcion();
           
        return obj;    
    }
    
    public Collection<Mensaje> listado() throws DAOExcepcion{
        Collection<Mensaje> msj = new ArrayList<Mensaje>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            con = ConexionDAO.obtenerConexion();
            String query = "SELECT cod,titulo,descripcion,fecha FROM mensaje";
            stmt = con.prepareStatement(query);
            rs   = stmt.executeQuery();
            while(rs.next()){
                Mensaje vo = new Mensaje(); 
                vo.setCod(rs.getInt("cod"));
                vo.setTitulo(rs.getString("titulo"));
                vo.setDescripcion(rs.getString("descripcion"));
                vo.setFecha(rs.getString("fecha"));
                msj.add(vo);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }finally{
            this.cerrarConexion(con);
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
        }
        
        return msj;
    }
    
}
