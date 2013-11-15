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
import sid.modelo.Junta;
import sid.persistencia.DAOExcepcion;
import sid.persistencia.ConexionDAO;

/**
 *
 * @author Uwe.Mayo
 */
public class JuntaDAO extends BaseDAO{
    
        public Junta insertar(Junta vo) throws DAOExcepcion{
                String reserva = vo.getFecha_ini();
                if(this.buscar(reserva).size()>0){
                         System.out.println("La sala se encuentra separada - probar otra fecha y/o hora");
                } else{
                String query = "INSERT INTO junta(idresidente, expositor, tema, fecha_ini, fecha_fin, acuerdo) VALUES (?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con  = ConexionDAO.obtenerConexion();
			stmt = con.prepareStatement(query);
                        stmt.setInt(1, vo.getIdresidente());
			stmt.setString(2, vo.getExpositor());
                        stmt.setString(3, vo.getTema());
                        stmt.setString(4, vo.getFecha_ini());
                        stmt.setString(5, vo.getFecha_fin());
                        stmt.setString(6, vo.getAcuerdo());
                                              
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
                            vo.setIdjunta(id);
                        System.out.println("Se registro correctamente");
			
                } catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
                } finally {                        
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		 }		
              }                     
	    return vo;
	}
          
        public Collection<Junta> buscar(String reserva)
			throws DAOExcepcion {
		String query = "Select * from junta where ? between fecha_ini and fecha_fin";
		Collection<Junta> lista = new ArrayList<Junta>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionDAO.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, reserva);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Junta vo = new Junta();
				vo.setIdjunta(rs.getInt("idjunta"));
				vo.setTema(rs.getString("tema"));
				lista.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return lista;
	}
}
