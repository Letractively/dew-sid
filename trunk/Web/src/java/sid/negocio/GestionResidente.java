package sid.negocio;

import java.sql.SQLException;
import java.util.Collection;
import sid.persistencia.ResidenteDAO;
import sid.persistencia.DAOExcepcion;
import sid.modelo.Residente;

public class GestionResidente { //aqui va la regla de negocio
    
    public Residente insertar(String nombre,String apellido,String dni,String fecha_nac,String correo,String pwd)throws DAOExcepcion {
        ResidenteDAO dao = new ResidenteDAO();
        Residente    vo  = new Residente();
        vo.setNombres(nombre);
        vo.setApellidos(apellido);
        vo.setDni(dni);
        vo.setFech_nac(fecha_nac);
        vo.setEmail(correo);
        vo.setPassword(pwd);
        
        Collection<Residente> rs = dao.buscarporcorreo(correo);   //aqui ingreso el correo para buscarlo
       // System.out.println(rs.size());
        
        if(rs.size()>0){                //Si en el array hay mas de un elemento quiere decir que hay un correo ya grabado y no debe grabar
            throw new DAOExcepcion("este correo ya existe");   //Este es para mostrar un mensaje de exception
        }else{                          //de lo contrario que grabe
            return dao.insertar(vo);    
        }
     }
    
   /*public Residente insertar(String nombre,String apellido,String dni,String fecha_nac,String email,String pwd)throws DAOExcepcion
    {
        ResidenteDAO dao = new ResidenteDAO();
        Residente    vo  = new Residente();
        vo.setNombres(nombre);
        vo.setApellidos(apellido);
        vo.setDni(dni);
        vo.setFech_nac(fecha_nac);
        vo.setEmail(email);
        vo.setPassword(pwd);
        return dao.insertar(vo);//aqui es donde me retorna el objeto
   }*/
    
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
