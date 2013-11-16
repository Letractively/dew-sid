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

import sid.persistencia.DAOExcepcion;
import sid.modelo.Mensajeria;
import sid.persistencia.ConexionDAO;

/**
 *
 * @author proyecto
 */
public class MensajeriaDAO extends BaseDAO {

    public Mensajeria insertar(Mensajeria vo) throws DAOExcepcion {
        String query = "insert into Mensajeria(Titulo,Contenido,Fech_public,idResidente) values (?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionDAO.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, vo.getTitulo());
            stmt.setString(2, vo.getContenido());
            stmt.setString(3, vo.getFech_public());
            stmt.setInt(4, vo.getId_Residente());
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
            vo.setId_Mensajeria(id);

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

    public Collection<Mensajeria> listar() throws DAOExcepcion {
        Collection<Mensajeria> c = new ArrayList<Mensajeria>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionDAO.obtenerConexion();
            String query = "select idmensajeria,titulo,contenido,fech_public,idresidente from mensajeria order by fech_public";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Mensajeria vo = new Mensajeria();
                vo.setId_Mensajeria(rs.getInt("idmensajeria"));
                vo.setTitulo(rs.getString("titulo"));
                vo.setContenido(rs.getString("contenido"));
                vo.setFech_public(rs.getString("fech_public"));
                vo.setId_Residente(rs.getInt("idresidente"));
                c.add(vo);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return c;
    }
}

