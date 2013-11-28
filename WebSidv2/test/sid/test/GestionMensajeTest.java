package sid.test;

import java.sql.SQLException;
import sid.negocio.GestionMensaje;
import sid.modelo.Mensaje;
import sid.persistencia.DAOExcepcion;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class GestionMensajeTest {
    
   @Test
   public void insertarTest() throws DAOExcepcion{
        GestionMensaje negocio = new GestionMensaje();
        try{
            negocio.insertar("Ingresando a mi blog", "Blog de vladimir","2013-12-23", 1);
        }catch(DAOExcepcion e){
            Assert.fail("Fallo la insercion: " + e.getMessage());
        }
   }
    
  @Test
  public void listarTest(){
      GestionMensaje negocio = new GestionMensaje();
      try{
          Collection<Mensaje> lista = negocio.listado();
          for(Mensaje r:lista){
              System.out.println(r.getCod());
              System.out.println(r.getTitulo());
          }
          Assert.assertTrue(lista.size()>0);
      }catch(DAOExcepcion e){
          Assert.fail("Fallo el listado:" + e.getMessage());
      }
  }
    
    
}