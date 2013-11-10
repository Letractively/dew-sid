package sid.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sid.modelo.Vivienda;
import sid.persistencia.ConexionDAO;
import sid.persistencia.DAOExcepcion;

public class ViviendaDAO extends BaseDAO {

public Vivienda insertar(Vivienda vo) throws DAOExcepcion{
    String query = "INSERT INTO vivienda(zona,edificio,numero,metraje,tipo,direccion,idresidente)VALUES(?,?,?,?,?,?,?)";
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try{
        con = ConexionDAO.obtenerConexion();
        stmt= con.prepareStatement(query);
        stmt.setString(1, vo.getZona());
        stmt.setString(2, vo.getEdificio());
        stmt.setString(3, vo.getNumero());
        stmt.setDouble(4, vo.getMetraje());
        stmt.setString(5, vo.getTipo());
        stmt.setString(6, vo.getDireccion());
        stmt.setInt(7, vo.getIdresidente());
        int i = stmt.executeUpdate();
        if(i!=1){
            throw new SQLException("No se pudo insertar");
        }
        int id=0;
        query = "select last_insert_id()";
        stmt = con.prepareStatement(query);
        rs   = stmt.executeQuery();
        if(rs.next()){
            id = rs.getInt(1);
        }
        vo.setIdvivienda(id);
        
    }catch(SQLException e){
        System.err.println(e.getMessage());
        throw new DAOExcepcion(e.getMessage());
    }finally{
        this.cerrarConexion(con);
        this.cerrarResultSet(rs);
        this.cerrarStatement(stmt);
    }
    return vo;      
}

public Collection<Vivienda> buscarxnumero(String numero) throws DAOExcepcion{
    String query = "SELECT idvivienda,zona,edificio,metraje FROM vivienda WHERE numero=?";
    Collection<Vivienda> listav = new ArrayList<Vivienda>();
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try{
        con = ConexionDAO.obtenerConexion();
        stmt= con.prepareStatement(query);
        stmt.setString(1, numero);
        rs = stmt.executeQuery();
        while(rs.next()){
            Vivienda vo = new Vivienda();
            vo.setIdvivienda(rs.getInt("idvivienda"));
            vo.setZona(rs.getString("zona"));
            vo.setEdificio(rs.getString("edificio"));
            vo.setMetraje(rs.getDouble("metraje"));
            listav.add(vo);
     }
   }catch(SQLException e){
       System.err.println(e.getMessage());
       throw new DAOExcepcion(e.getMessage());
   }finally{
        this.cerrarConexion(con);
        this.cerrarResultSet(rs);
        this.cerrarStatement(stmt);
   }
   System.out.println(listav.size());
   return listav;

}


    
    
}
