package sid.negocio;

import java.sql.SQLException;
import java.util.Collection;
import sid.persistencia.ResidenteDAO;
import sid.persistencia.DAOExcepcion;
import sid.modelo.Residente;

public class GestionResidente { //aqui va la regla de negocio
    
    /*public Residente insertar(String nombre,String apellido,String dni,String fecha_nac,String email,String pwd)throws DAOExcepcion
    {
        ResidenteDAO dao = new ResidenteDAO();
        Residente    vo  = new Residente();
        //vo.setIdresidente(idresidente);
        vo.setNombres(nombre);
        vo.setApellidos(apellido);
        vo.setDni(dni);
        vo.setFech_nac(fecha_nac);
        vo.setEmail(email);
        vo.setPassword(pwd);
        
        /*Collection<Residente> lista = dao.buscarporcorreo(email);//aqui ingreso el correo para buscarlo
        if(lista.size()>0){
            throw new DAOExcepcion("Este correo existe");   //Este es para mostrar un mensaje de exception
        }else{
            return dao.insertar(vo);
        }*/
        //return dao.insertar(vo);
   //}*/
    
   public Residente insertar(String nombre,String apellido,String dni,String fecha_nac,String email,String pwd)throws DAOExcepcion
    {
        ResidenteDAO dao = new ResidenteDAO();
        Residente    vo  = new Residente();
        //vo.setIdresidente(idresidente);
        vo.setNombres(nombre);
        vo.setApellidos(apellido);
        vo.setDni(dni);
        vo.setFech_nac(fecha_nac);
        vo.setEmail(email);
        vo.setPassword(pwd);
        return dao.insertar(vo);//aqui es donde me retorna el objeto
   }
    
   public Residente actualizar(int idresidente,String nombre,String apellido,String dni,String fecha_nac,String email,String pwd) throws DAOExcepcion{
     ResidenteDAO re = new ResidenteDAO();
     Residente    vo = new Residente();
     vo.setIdresidente(idresidente);
     vo.setNombres(nombre);
     vo.setApellidos(apellido);
     vo.setDni(dni);
     vo.setFech_nac(fecha_nac);
     vo.setEmail(email);
     vo.setPassword(pwd);
     return re.actualizar(vo);
   }
   
   /*public Residente eliminar(int idresidente ) throws DAOExcepcion{ //Aqui le envio parametros
       ResidenteDAO eli = new ResidenteDAO();
       Residente    vo  = new Residente();
       vo.setIdresidente(idresidente);      //Aqui asigno el valor (SET)
       return eli.eliminar(vo);
   }*/
   
   public void eliminar(int idResidente) throws DAOExcepcion {  //Esto no es una funcion, es un procedimiento y no retorna nada, en este caso le envio un parametro
	ResidenteDAO eli = new ResidenteDAO();
	eli.eliminar(idResidente);
  }
   
  public Collection<Residente> buscarporcorreo(String correo) throws DAOExcepcion {
	ResidenteDAO dao = new ResidenteDAO();
	return dao.buscarporcorreo(correo);
  }
   
   public Collection<Residente> listar() throws DAOExcepcion{
      ResidenteDAO dao = new ResidenteDAO();
      return dao.listar();
  }
    
    
    
    
}
