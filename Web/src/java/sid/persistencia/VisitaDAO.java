/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sid.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;
import sid.modelo.Visita;
import sid.persistencia.DAOExcepcion;
import sid.persistencia.ConexionDAO;

/**
 *
 * @author Uwe.Mayo
 */
public class VisitaDAO extends BaseDAO{
    
    public Visita insertar(Visita vo) throws DAOExcepcion{
		String query = "INSERT INTO visita(idvisita, dni_visita, nombre, fech_visita, idresidente) VALUES (?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con  = ConexionDAO.obtenerConexion();
			stmt = con.prepareStatement(query);
                        stmt.setInt(1, vo.getIdvisita());
			stmt.setInt(2, vo.getDni_visita());
                        stmt.setString(3, vo.getNombre());
                        stmt.setString(4, vo.getFech_visita());
                        stmt.setInt(5, vo.getIdresidente());
                                              
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
                            vo.setIdvisita(id);
                        System.out.println("Se registró correctamente");
			
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
    
      public Visita actualizar(Visita vo) throws DAOExcepcion{
           String query = "UPDATE visita SET dni_visita=?, nombre=?, fech_visita=?, idresidente=? WHERE idvisita=?";
           Connection con = null;
           PreparedStatement stmt = null;
           try{
               con = ConexionDAO.obtenerConexion();
               stmt= con.prepareStatement(query);
               stmt.setInt(1, vo.getDni_visita());
	       stmt.setString(2, vo.getNombre());
               stmt.setString(3, vo.getFech_visita());
               stmt.setInt(4, vo.getIdresidente());
               stmt.setInt(5, vo.getIdvisita());
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
    
             public void eliminar(int idvisita) throws DAOExcepcion {
		String query = "DELETE FROM Visita WHERE idvisita=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionDAO.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idvisita);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar - registro no existe");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
      }
             
        public Collection<Visita> listar(int idresidente) throws DAOExcepcion{
           Collection<Visita> c = new ArrayList<Visita>();
           Connection con = null;
           PreparedStatement stmt = null;
           ResultSet rs = null;           
           try{
               con = ConexionDAO.obtenerConexion();
               String query = "SELECT idvisita,dni_visita,nombre,fech_visita,idresidente FROM visita WHERE idresidente=?";
               stmt = con.prepareStatement(query);
               stmt.setInt(1, idresidente);
               rs   = stmt.executeQuery();
               while(rs.next()){
                   Visita vo = new Visita();
                   vo.setIdvisita(rs.getInt("idvisita"));
                   vo.setDni_visita(rs.getInt("dni_visita"));
                   vo.setNombre(rs.getString("nombre"));
                   vo.setFech_visita(rs.getString("fech_visita"));
                   vo.setIdresidente(rs.getInt("idresidente"));
                   c.add(vo);
              }
           }catch(SQLException e){
               System.err.println(e.getMessage()+"Usuario no fue visitado");
           }finally{
               this.cerrarStatement(stmt); 
               this.cerrarResultSet(rs);   
               this.cerrarConexion(con);    
           }
           return c;
       }
     
             
}
