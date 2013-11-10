package sid.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sid.modelo.Reserva;
import sid.persistencia.ConexionDAO;
import sid.persistencia.DAOExcepcion;

public class ReservaDAO extends BaseDAO {
    
 public Reserva insertar(Reserva vo) throws DAOExcepcion{
     String query= "INSERT INTO reserva(fecha,hora,idespaciocomun,idresidente)VALUES(?,?,?,?)";
     Connection con = null;
     PreparedStatement stmt = null;
     ResultSet rs = null;
     try{
         con = ConexionDAO.obtenerConexion();
         stmt= con.prepareStatement(query);
         stmt.setString(1, vo.getFecha());
         stmt.setString(2, vo.getHora());
         stmt.setInt(3, vo.getIdespaciocomun());
         stmt.setInt(4, vo.getIdresidente());
         int i = stmt.executeUpdate();
         if(i!=1){
             throw new DAOExcepcion("No se pudo intertar");
         }
         int id = 0;
         query = "select last_insert_id()";
         stmt  = con.prepareStatement(query);
         rs = stmt.executeQuery();
         if(rs.next()){
             id = rs.getInt(1);
         }
         vo.setIdreserva(id);
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
 
 public Collection<Reserva> buscarxfecha(String fecha) throws DAOExcepcion{
     String query = "SELECT idreserva,fecha,idespaciocomun,idresidente FROM reserva WHERE fecha=?";
     Collection<Reserva> listado = new ArrayList<Reserva>();
     Connection con = null;
     PreparedStatement stmt = null;
     ResultSet rs = null;
     try{
         con = ConexionDAO.obtenerConexion();
         stmt= con.prepareStatement(query);
         stmt.setString(1, fecha);
         rs  = stmt.executeQuery();
         while(rs.next()){
             Reserva vo = new Reserva();
             vo.setIdreserva(rs.getInt("idreserva"));
             vo.setFecha(rs.getString("fecha"));
             vo.setIdespaciocomun(rs.getInt("idespaciocomun"));
             vo.setIdresidente(rs.getInt("idresidente"));
             listado.add(vo);
         }
     }catch(SQLException e){
             System.err.println(e.getMessage());
             throw new DAOExcepcion(e.getMessage());
     }finally{
            this.cerrarConexion(con);
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
     }
     System.out.println(listado.size());
     return listado;
 }





}
