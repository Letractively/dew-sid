package sid.negocio;

import java.sql.SQLException;
import java.util.Collection;
import sid.persistencia.MensajeDAO;
import sid.persistencia.DAOExcepcion;
import sid.modelo.Mensaje;

public class GestionMensaje {
    
    public Mensaje insertar(String titulo,String descripcion,String fecha,int estado) throws DAOExcepcion{
        MensajeDAO dao = new MensajeDAO();
        Mensaje   obj = new Mensaje();
        obj.setTitulo(titulo);
        obj.setDescripcion(descripcion);
        obj.setFecha(fecha);
        obj.setEstado(estado);
            
        if(descripcion!=""){
           return dao.insertar(obj); 
        }else{
            throw new DAOExcepcion("El contenido esta vacio"); 
        }
        
        //int longitud = descripcion.length();
        
        /*if(descripcion.length()>140){
           return dao.insertar(obj); 
        }else{
            throw new DAOExcepcion("El contenido esta vacio"); 
        }*/
        
    }
    
    public Collection<Mensaje> listado() throws DAOExcepcion{
        MensajeDAO dao = new MensajeDAO();
        return dao.listado();
    }
    
}
