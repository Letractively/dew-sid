package sid.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sid.modelo.Residente;
import sid.persistencia.DAOExcepcion;
import sid.persistencia.ConexionDAO;

public class ResidenteDAO extends BaseDAO {
    

    public Residente insertar(Residente vo) throws DAOExcepcion{
		String query = "INSERT INTO residente(nombre,apellidos,tipodoc,nro,fecha_nac,email,password) VALUES (?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con  = ConexionDAO.obtenerConexion();
			stmt = con.prepareStatement(query);
                        stmt.setString(1, vo.getNombres());
			stmt.setString(2, vo.getApellidos());
                        stmt.setString(3, vo.getTipodoc());
                        stmt.setString(4, vo.getNro());
                        stmt.setString(5, vo.getFech_nac());
                        stmt.setString(6, vo.getEmail());
                        stmt.setString(7, vo.getPassword());
                        
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
			// Obtener el ultimo id
			int id = 0;
			query = "select last_insert_id()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
                            vo.setIdresidente(id);
			
                } catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
                } finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
    
          
    public Residente actualizar(Residente vo) throws DAOExcepcion{
           String query = "UPDATE residente SET nombre=?,apellidos=?,tipodoc=?,nro=?,fecha_nac=?,email=?,password=? WHERE idresidente=?";
           Connection con = null;
           PreparedStatement stmt = null;
           try{
               con = ConexionDAO.obtenerConexion();
               stmt= con.prepareStatement(query);
               stmt.setString(1, vo.getNombres());
               stmt.setString(2, vo.getApellidos());
               stmt.setString(3, vo.getTipodoc());
               stmt.setString(4, vo.getNro());
               stmt.setString(5, vo.getFech_nac());
               stmt.setString(6, vo.getEmail());
               stmt.setString(7, vo.getPassword());
               stmt.setInt(8, vo.getIdresidente());
               int i = stmt.executeUpdate();
               if(i!=1){
                   throw new SQLException("No se pudo actualizar");
               }
           }catch(SQLException e){
               System.err.println(e.getMessage());
               throw new DAOExcepcion(e.getMessage());
           }finally{
               this.cerrarStatement(stmt);
               this.cerrarConexion(con);
           }
           return vo;
       }
       
       /*public Residente eliminar(Residente vo) throws DAOExcepcion{
           String query = "DELETE FROM Residente WHERE idResidente=?";
           Connection con = null;
           PreparedStatement stmt = null;
           try{
               con = ConexionDAO.obtenerConexion();
               stmt=con.prepareStatement(query);
               stmt.setInt(1, vo.getIdresidente()); //Aqui obtengo el valor (GET)
               int i = stmt.executeUpdate();
               if(i!=1){
                   throw new SQLException("No se pudo eliminar,que pena");
               }
           }catch(SQLException e){
               System.err.println(e.getMessage());
               throw new DAOExcepcion(e.getMessage());
           }finally{
               this.cerrarStatement(stmt);
               this.cerrarConexion(con);
           }
           return vo;
       }*/
       
       public void eliminar(int idResidente) throws DAOExcepcion {
		String query = "DELETE FROM Residente WHERE idresidente=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionDAO.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idResidente);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
      }
       
      public Collection<Residente> buscarporcorreo(String correo) throws DAOExcepcion{
           String query = "SELECT idresidente,nombre,apellidos,email FROM residente WHERE email=?";
           Collection<Residente> lista = new ArrayList<Residente>();
           Connection con = null;
           PreparedStatement stmt = null;
           ResultSet rs = null;
           try{
               con = ConexionDAO.obtenerConexion();
               stmt= con.prepareStatement(query);
               stmt.setString(1, correo);
               rs  = stmt.executeQuery();
               while(rs.next()){
                   Residente vo = new Residente();
                   vo.setIdresidente(rs.getInt("idresidente"));
                   vo.setNombres(rs.getString("nombre"));
                   vo.setApellidos(rs.getString("apellidos"));
                   vo.setEmail(rs.getString("email"));
                   lista.add(vo);
               }
           }catch(SQLException e){
               System.err.println(e.getMessage());
               throw new DAOExcepcion(e.getMessage());
           }finally{
               this.cerrarStatement(stmt);
               this.cerrarResultSet(rs);
               this.cerrarConexion(con);
           }
           
           int num = lista.size();
           //System.out.println(num);
           if(num!=0){
               System.out.println("¡Error...!, no se registro, el correo ya esta registrado");
           }else{
               System.out.println("Datos Grabados exitosamente");
           }
           
           return lista; 
       }
       
       /*public Residente obtener(String correo) throws DAOExcepcion {
		Residente vo = new Residente();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT idresidente,nombre,apellidos,email FROM residente WHERE email=?";
			con = ConexionDAO.obtenerConexion();
			stmt = con.prepareStatement(query);
			//stmt.setInt(1, correo);
                        stmt.setString(1, correo);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdresidente(rs.getInt(1));
				vo.setNombres(rs.getString(2));
				vo.setApellidos(rs.getString(3));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}*/

       
       public Collection<Residente> listar() throws DAOExcepcion{
           Collection<Residente> c = new ArrayList<Residente>();
           Connection con = null;
           PreparedStatement stmt = null;
           ResultSet rs = null;
           try{
               con = ConexionDAO.obtenerConexion();
               String query = "SELECT idresidente,nombre,apellidos,tipodoc,nro,fecha_nac,email,password FROM residente";
               stmt = con.prepareStatement(query);
               rs   = stmt.executeQuery();
               while(rs.next()){
                   Residente vo = new Residente();
                   vo.setIdresidente(rs.getInt("idresidente"));
                   vo.setNombres(rs.getString("nombre"));
                   vo.setApellidos(rs.getString("apellidos"));
                   vo.setTipodoc(rs.getString("tipodoc"));
                   vo.setNro(rs.getString("nro"));
                   vo.setFech_nac(rs.getString("fecha_nac"));
                   vo.setEmail(rs.getString("email"));
                   vo.setPassword(rs.getString("password"));
                   c.add(vo);
              }
           }catch(SQLException e){
               System.err.println(e.getMessage());
           }finally{
               this.cerrarStatement(stmt);  //que es esto?
               this.cerrarResultSet(rs);    //Este es el recordset (pero porq lo cierra?)
               this.cerrarConexion(con);    //Esta es la conexion
           }
           return c;
       }
       
}