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
     String query= "INSERT INTO reserva(fecha,hora,tiempo,idespaciocomun,idresidente,estado)VALUES(?,?,?,?,?,?)";
     Connection con = null;
     PreparedStatement stmt = null;
     ResultSet rs = null;
     try{
         con = ConexionDAO.obtenerConexion();
         stmt= con.prepareStatement(query);
         stmt.setString(1, vo.getFecha());
         stmt.setString(2, vo.getHora());
         stmt.setInt(3,vo.getTiempo());
         stmt.setInt(4, vo.getIdespaciocomun());
         stmt.setInt(5, vo.getIdresidente());
         stmt.setInt(6, vo.getEstado());
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
     Collection<Reserva> listado = new ArrayList<Reserva>();    //creamos un arreglo
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
     int numero = listado.size();
     if(numero!=0){
         System.out.println("¡Error..! la fecha de reserva no esta disponible");
     }else{
         System.out.println("Reserva realizada con exito");
     }
     
     return listado;
 }
 
 public Collection<Reserva> listareservas() throws DAOExcepcion{
     Collection<Reserva> lista = new ArrayList<Reserva>();
     Connection con = null;
     PreparedStatement stmt = null;
     ResultSet rs = null;
     try{
         con = ConexionDAO.obtenerConexion();
         String query = "SELECT r.idreserva,r.fecha,r.hora,r.tiempo,r.idespaciocomun,r.idresidente,e.nombre as espacio,r.estado FROM reserva r,espaciocomun e WHERE e.idespaciocomun=r.idespaciocomun";
         stmt= con.prepareStatement(query);
         rs  = stmt.executeQuery();
         while(rs.next()){
             Reserva vo = new Reserva();
             vo.setIdreserva(rs.getInt("idreserva"));
             vo.setFecha(rs.getString("fecha"));
             vo.setHora(rs.getString("hora"));
             vo.setTiempo(rs.getInt("tiempo"));
             vo.setIdespaciocomun(rs.getInt("idespaciocomun"));
             vo.setNomespacio(rs.getString("espacio"));
             vo.setIdresidente(rs.getInt("idresidente"));
             vo.setEstado(rs.getInt("estado"));
             lista.add(vo);
        }
         
     }catch(SQLException e){
         System.err.println();
     }finally{
         this.cerrarStatement(stmt);
         this.cerrarResultSet(rs);
         this.cerrarConexion(con);
     }
     return lista;
 }
 
 public Collection<Reserva> misreservas(int cod) throws DAOExcepcion{
     Collection<Reserva> lista = new ArrayList<Reserva>();
     Connection con = null;
     PreparedStatement stmt = null;
     ResultSet rs = null;
     try{
         con = ConexionDAO.obtenerConexion();
         String query = "SELECT r.idreserva,r.fecha,r.hora,r.tiempo,r.idespaciocomun,r.idresidente,e.nombre as espacio,r.estado FROM reserva r,espaciocomun e WHERE e.idespaciocomun=r.idespaciocomun AND r.idresidente=?";
         stmt= con.prepareStatement(query);
         stmt.setInt(1, cod);
         rs  = stmt.executeQuery();
         while(rs.next()){
             Reserva vo = new Reserva();
             vo.setIdreserva(rs.getInt("idreserva"));
             vo.setFecha(rs.getString("fecha"));
             vo.setHora(rs.getString("hora"));
             vo.setTiempo(rs.getInt("tiempo"));
             vo.setIdespaciocomun(rs.getInt("idespaciocomun"));
             vo.setNomespacio(rs.getString("espacio"));
             vo.setIdresidente(rs.getInt("idresidente"));
             vo.setEstado(rs.getInt("estado"));
             lista.add(vo);
        }
         
     }catch(SQLException e){
         System.err.println();
     }finally{
         this.cerrarStatement(stmt);
         this.cerrarResultSet(rs);
         this.cerrarConexion(con);
     }
     return lista;
 }
 


}
