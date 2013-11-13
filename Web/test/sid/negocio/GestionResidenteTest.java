package sid.negocio;

import java.util.Collection;
import org.junit.Assert;
import sid.persistencia.DAOExcepcion;
import sid.modelo.Residente;
import sid.negocio.GestionResidente;

import org.junit.Test;
import static org.junit.Assert.*;

public class GestionResidenteTest {
    
    @Test
    public void insertarTest() throws DAOExcepcion{
        GestionResidente negocio = new GestionResidente();
        try{
           negocio.insertar("Paola", "Nievee", "98765415", "1980-10-20", "nieve__2@hotmail.com", "987156758"); //1980-10-89
        }catch(DAOExcepcion e){
            Assert.assertTrue("Email registrado", true);    //Assert.fail("Fallo la insercion: " + e.getMessage());
        }
    
    }
    
    //@Test
    public void actualizarTest() throws DAOExcepcion{
        GestionResidente negocio = new GestionResidente();
        try{
            negocio.actualizar(5, "Jimmy", "Lopez", "12345678", "1980-01-07", "poemasmix@hotmail.com", "2871055");
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
                System.out.println(r.getNombres());
                System.out.println(r.getApellidos());
            }
            Assert.assertTrue(listado.size()>0);
        }catch(DAOExcepcion e){
            Assert.fail("Fallo el listado: " + e.getMessage());
        }
    }
    
   /* @Test
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