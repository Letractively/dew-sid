package sid.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sid.modelo.Queja;
import sid.persistencia.DAOExcepcion;
import sid.persistencia.ConexionDAO;

public class QuejaDAO extends BaseDAO {
    

    public Queja insertar(Queja vo) throws DAOExcepcion{
		String query = "INSERT INTO queja(tipo_queja,motivo,fech_queja,idresidente, estado) VALUES (?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con  = ConexionDAO.obtenerConexion();
			stmt = con.prepareStatement(query);
                        stmt.setString(1, vo.getTipo_queja());
			stmt.setString(2, vo.getMotivo());
                        stmt.setString(3, vo.getFech_queja());
                        stmt.setInt(4, vo.getIdresidente());
                        stmt.setString(5, vo.getEstado());
                        
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
                            vo.setIdqueja(id);
			
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
    
      
      
       
      public Collection<Queja> Listarquejas(int idresidente) throws DAOExcepcion{
           String query = "SELECT idresidente, idqueja,tipo_queja,motivo,fech_queja, estado FROM queja WHERE idqueja=?";
           Collection<Queja> lista = new ArrayList<Queja>();
           Connection con = null;
           PreparedStatement stmt = null;
           ResultSet rs = null;
           try{
               con = ConexionDAO.obtenerConexion();
               stmt= con.prepareStatement(query);
               stmt.setInt(1, idresidente);
               rs  = stmt.executeQuery();
               while(rs.next()){
                   Queja vo = new Queja();
                   vo.setIdresidente(rs.getInt("idresidente"));
                   vo.setTipo_queja(rs.getString("tipo_queja"));
                   vo.setMotivo(rs.getString("motivo"));
                   vo.setFech_queja(rs.getString("fech_queja"));
                   vo.setEstado(rs.getString("estado"));
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
           
           System.out.println(lista.size());
           return lista;
       }
                
       
}