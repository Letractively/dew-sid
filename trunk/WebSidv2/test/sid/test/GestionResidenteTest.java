package sid.test;

import java.util.Collection;
import sid.persistencia.DAOExcepcion;
import sid.modelo.Residente;
import sid.negocio.GestionResidente;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class GestionResidenteTest {
    
    @Test
    public void insertarTest() throws DAOExcepcion{
        GestionResidente negocio = new GestionResidente();
        try{
            negocio.insertar("Jesus", "Castro", "P", "654987845", "1980-11-08", "jesus20@gmail.com", "147258");
           
          }catch(DAOExcepcion e){
            Assert.assertTrue("Email registrado", true); 
        }
    
    }
    
    //@Test
    public void actualizarTest() throws DAOExcepcion{
        GestionResidente negocio = new GestionResidente();
        try{
            negocio.actualizar(32, "Jimmy", "Lopez", "P", "12284587","1988-03-09" ,"poemasmix@hotmail.com", "987654");
        }catch(DAOExcepcion e){
            Assert.fail("Fallo la actualizacion: " + e.getMessage());
        }
    
    }
    
    //@Test
    public void eliminarTest() throws DAOExcepcion{
        GestionResidente negocio = new GestionResidente();
        try{
            negocio.eliminar(6);
        }catch(DAOExcepcion x){
            Assert.fail("Error, no elimina: " + x.getMessage());
        }
    }
    
    //@Test
    public void listarTest(){
        GestionResidente negocio = new GestionResidente();
        try{
            Collection<Residente> listado = negocio.listar();
            //System.out.println(listado.size());
            for(Residente r:listado){
                System.out.println(r.getNombre());
                System.out.println(r.getApellidos());
            }
            Assert.assertTrue(listado.size()>0);
        }catch(DAOExcepcion e){
            Assert.fail("Fallo el listado: " + e.getMessage());
        }
    }
    
   /*@Test
    public void verificacorreoTest() throws DAOExcepcion{
       GestionResidente negocio = new GestionResidente(); 
       try{
           Collection<Residente> listamail = negocio.buscarporcorreo("poemasmix@hotmail.com");
           for(Residente r:listamail){
            System.out.println(r.getNombres());
           }
          
           
       }catch(DAOExcepcion e){              
           Assert.fail("No se encontro:" + e.getMessage());
       }
    }*/
    
}
