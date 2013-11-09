package sid.negocio;

import java.sql.SQLException;
import java.util.Collection;
import sid.persistencia.CuotaDAO;
import sid.persistencia.DAOExcepcion;
import sid.modelo.Cuota;

public class GestionCuota { //aqui va la regla de negocio
    
    public Cuota insertar(int idvivienda,String periodo,int anio,double importe,String fech_venc,String estado, String tipo_pago,String fech_pago)throws DAOExcepcion
    {
        CuotaDAO dao = new CuotaDAO();
        Cuota    vo  = new Cuota();
        //vo.setIdresidente(idresidente);
        vo.setidvivienda(idvivienda);
        vo.setperiodo(periodo);
        vo.setanio(anio);
        vo.setimporte(importe);
        vo.setfech_venc(fech_venc);
        vo.setestado(estado);
        vo.settipo_pago(tipo_pago);
        vo.setfech_pago(fech_pago);
        return dao.insertar(vo);//aqui es donde me retorna el objeto
   }
    
   public Cuota actualizar(int idvivienda,String periodo,int anio,double importe,String fech_venc,String estado, String tipo_pago,String fech_pago, int  idcuota)throws DAOExcepcion{
     CuotaDAO re = new CuotaDAO();
     Cuota    vo = new Cuota();
      vo.setidvivienda(idvivienda);
        vo.setperiodo(periodo);
        vo.setanio(anio);
        vo.setimporte(importe);
        vo.setfech_venc(fech_venc);
        vo.setestado(estado);
        vo.settipo_pago(tipo_pago);
        vo.setfech_pago(fech_pago);
        vo.setIdCuotas(idcuota);
     return re.actualizar(vo);
   }
   
   /*public Cuota eliminar(int idresidente ) throws DAOExcepcion{ //Aqui le envio parametros
       CuotaDAO eli = new CuotaDAO();
       Cuota    vo  = new Cuota();
       vo.setIdresidente(idresidente);      //Aqui asigno el valor (SET)
       return eli.eliminar(vo);
   }*/
   
   public void eliminar(int idCuota) throws DAOExcepcion {  //Esto no es una funcion, es un procedimiento y no retorna nada, en este caso le envio un parametro
	CuotaDAO eli = new CuotaDAO();
	eli.eliminar(idCuota);
  }
   
  public Collection<Cuota> listarpendientes(int idresidente) throws DAOExcepcion{
      CuotaDAO dao = new CuotaDAO();
      return dao.listarpendientes(idresidente);
  }
    
    
    
    
}
