/*
 * To change this template, choose Tools | Templates
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
import sid.modelo.Cuota;
import sid.modelo.Residente;
import sid.modelo.Vivienda;
import sid.persistencia.DAOExcepcion;
import sid.persistencia.ConexionDAO;
/**
 *
 * @author proyecto
 */
public class CuotaDAO extends BaseDAO{
    
    public Cuota insertar(Cuota vo) throws DAOExcepcion{
		String query = "INSERT INTO cuota(idvivienda,periodo,anio  ,importe,fech_venc,estado,tipo_pago,fech_pago) VALUES (?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
                    
                    //verificar si existe la cuota
                     con = ConexionDAO.obtenerConexion();
                    String string2 = "SELECT idcuota FROM cuota where periodo = ? and anio = ? and idvivienda = ?" ;
                    stmt = con.prepareStatement(string2);
                    stmt.setString(1, vo.getperiodo());
                    stmt.setInt(2, vo.getanio());
                    stmt.setInt(3, vo.getidvivienda());
                    rs   = stmt.executeQuery();
                    
                    Result result = ResultSupport.toResult(rs);
                    if (result.getRowCount() > 0)
                    {
                      throw new SQLException("No se pudo insertar");
                    }
               
			con  = ConexionDAO.obtenerConexion();
			stmt = con.prepareStatement(query);
                        stmt.setInt(1, vo.getidvivienda());
			stmt.setString(2, vo.getperiodo());
			stmt.setInt(3, vo.getanio());
                        stmt.setDouble(4, vo.getimporte());
                        stmt.setString(5, vo.getfech_venc());
                        stmt.setString(6, vo.getestado());
                        stmt.setString(7, vo.gettipo_pago());
                        stmt.setString(8, vo.getfech_pago());
                        
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
                            vo.setIdCuotas(id);
			
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
    
    
       public Cuota actualizar(Cuota vo) throws DAOExcepcion{
           String query = "UPDATE cuota SET idvivienda=?,periodo=?,anio=?,importe=?,fech_venc=?,estado=?,tipo_pago=?,fech_pago=? WHERE idcuota=?";
           Connection con = null;
           PreparedStatement stmt = null;
           try{
                con = ConexionDAO.obtenerConexion();
                stmt= con.prepareStatement(query);
                stmt.setInt(1, vo.getidvivienda());
                stmt.setString(2, vo.getperiodo());
                stmt.setInt(3, vo.getanio());
                stmt.setDouble(4, vo.getimporte());
                stmt.setString(5, vo.getfech_venc());
                stmt.setString(6, vo.getestado());
                stmt.setString(7, vo.gettipo_pago());
                stmt.setString(8, vo.getfech_pago());
                stmt.setInt(9, vo.getIdCuotas());
                
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
       
       public void eliminar(int idcuota) throws DAOExcepcion {
		String query = "DELETE FROM cuota WHERE idcuota=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionDAO.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idcuota);
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
       
       public Collection<Cuota> listarpendientes(int idresidente) throws DAOExcepcion{
           Collection<Cuota> c = new ArrayList<Cuota>();
           Connection con = null;
           PreparedStatement stmt = null;
           ResultSet rs = null;
           try{
               con = ConexionDAO.obtenerConexion();
               String query = "SELECT cuo.idcuota,cuo.periodo, cuo.anio, concat(red.apellidos,', ',red.nombre) as nombre, " +
                "red.dni, cuo.importe, cuo.fech_venc, viv.direccion " +
                "FROM cuota as cuo " +
                "inner join vivienda as viv on viv.idvivienda = cuo.idvivienda " +
                "inner join residente as red on red.idresidente = viv.idresidente " +
                "where red.idresidente = " + String.valueOf(idresidente);
               stmt = con.prepareStatement(query);
               rs   = stmt.executeQuery();
               while(rs.next()){
                   Cuota vo = new Cuota();
                   vo.setIdCuotas(rs.getInt("idcuota"));
                   vo.setanio(rs.getInt("anio"));
                   Residente residente = new Residente();
                   residente.setNombres(rs.getString("nombre"));
                   residente.setDni(rs.getString("dni"));
                   vo.setResidente(residente);
                   vo.setimporte(rs.getDouble("importe"));
                   vo.setfech_venc(rs.getString("fech_venc"));
                   Vivienda vivienda = new Vivienda();
                   vivienda.setDireccion(rs.getString("direccion"));
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
