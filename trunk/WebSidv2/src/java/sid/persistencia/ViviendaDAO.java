package sid.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sid.modelo.Vivienda;


public class ViviendaDAO extends BaseDAO {

public Vivienda insertar(Vivienda vo) throws DAOExcepcion{
    String query = "INSERT INTO vivienda(tipovivienda, tipoubicacion, ubicacion, numero, metraje,idresidente) VALUES(?,?,?,?,?,?)";
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try{
        con = ConexionDAO.obtenerConexion();
        stmt= con.prepareStatement(query);
        stmt.setString(1, vo.getTipoVivienda());
        stmt.setString(2, vo.getTipoUbicacion());
        stmt.setString(3, vo.getUbicacion());
        stmt.setString(4, vo.getNumero());
        stmt.setDouble(5, vo.getMetraje());
        stmt.setInt(6, vo.getIdresidente());
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
    String query = "SELECT idvivienda,ubicacion,metraje,tipovivienda FROM vivienda WHERE numero=?";
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
            vo.setUbicacion(rs.getString("ubicacion"));
            vo.setMetraje(rs.getDouble("metraje"));
            vo.setTipoVivienda(rs.getString("tipovivienda"));
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
   int num = listav.size();
   if(num!=0){
       System.out.println("¡Error...!,la vivienda ya ha sido registrada");
   }else{
       System.out.println("Vivienda registrada con exito");
   }
   return listav;

}

public Collection<Vivienda> listarviviendaporresidente(int idvivienda) throws DAOExcepcion{
    String query = "select idvivienda, ubicacion, numero, metraje, tipovivienda, tipoubicacion, " + 
            "case tipovivienda when '1' then 'Casa' when '2' then 'Departamento' end as descripciontipo, idresidente from vivienda where idresidente =?";
    Collection<Vivienda> listav = new ArrayList<Vivienda>();
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try{
        con = ConexionDAO.obtenerConexion();
        stmt= con.prepareStatement(query);
        stmt.setInt(1, idvivienda);
        rs = stmt.executeQuery();
        while(rs.next()){
            Vivienda vo = new Vivienda();
            vo.setIdvivienda(rs.getInt("idvivienda"));
            vo.setUbicacion(rs.getString("ubicacion"));
            vo.setNumero(rs.getString("numero"));
            vo.setMetraje(rs.getDouble("metraje"));
            vo.setTipoVivienda(rs.getString("tipovivienda"));
            vo.setDescripciontipo(rs.getString("descripciontipo"));
            vo.setTipoUbicacion(rs.getString("tipoubicacion"));
            vo.setIdresidente(rs.getInt("idresidente"));
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
   
   return listav;

}
  
public Collection<Vivienda> listarViviendas() throws DAOExcepcion{
    String query = "Select * from vivienda";
    Collection<Vivienda> listav = new ArrayList<Vivienda>();
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    try{
        con = ConexionDAO.obtenerConexion();
        stmt = con.prepareStatement(query);
        rs = stmt.executeQuery();
        while(rs.next()){
            Vivienda vo = new Vivienda();
            vo.setIdvivienda(rs.getInt("idvivienda"));
            vo.setTipoVivienda(rs.getString("tipovivienda"));
            vo.setTipoUbicacion(rs.getString("tipoubicacion"));
            vo.setUbicacion(rs.getString("ubicacion"));
            vo.setNumero(rs.getString("numero"));
            vo.setMetraje(rs.getDouble("metraje"));
            vo.setIdresidente(rs.getInt("idresidente"));
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
   
   return listav;
 }
    
public void eliminarVivienda(int idresidente, int idvivienda) throws DAOExcepcion {
    String query = "DELETE FROM vivienda WHERE idresidente=? and idvivienda=?";
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try{
        con = ConexionDAO.obtenerConexion();
        stmt= con.prepareStatement(query);
        stmt.setInt(1, idresidente);
        stmt.setInt(2, idvivienda);
        int i = stmt.executeUpdate();
        if (i !=1 ){
            throw new SQLException("No se pudo eliminar");
        }
 
    }catch(SQLException e){
        System.err.println(e.getMessage());
        throw new DAOExcepcion(e.getMessage());
    } finally {
        this.cerrarConexion(con);
        this.cerrarStatement(stmt);
    }
}

}
