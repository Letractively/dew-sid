package sid.persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sid.modelo.EspacioComun;
import sid.persistencia.DAOExcepcion;
import sid.persistencia.ConexionDAO;

public class EspacioComunDAO extends BaseDAO {
    
    public Collection<EspacioComun> listado() throws DAOExcepcion{
        Collection<EspacioComun> es = new ArrayList<EspacioComun>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            con = ConexionDAO.obtenerConexion();
            String query = "SELECT idespaciocomun,nombre,tipo FROM espaciocomun";
            stmt         = con.prepareStatement(query);
            rs           = stmt.executeQuery();
            while(rs.next()){
                   EspacioComun vo = new EspacioComun();
                   vo.setIdespaciocomun(rs.getInt("idespaciocomun"));
                   vo.setNombre(rs.getString("nombre"));
                   vo.setTipo(rs.getString("tipo"));
                   es.add(vo);
           }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }finally{
            this.cerrarStatement(stmt);
            this.cerrarResultSet(rs);
            this.cerrarConexion(con);
        }
        return es;
        
}
    
    
}
