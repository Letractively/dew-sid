package sid.negocio;

import java.util.Collection;
import org.junit.Assert;
import sid.persistencia.DAOExcepcion;
import sid.modelo.Residente;
import sid.negocio.GestionResidente;

import org.junit.Test;
import static org.junit.Assert.*;

public class GestionResidenteTest {
    
    //@Test
    public void insertarTest() throws DAOExcepcion{
        GestionResidente negocio = new GestionResidente();
        try{
           negocio.insertar("Jesus", "Alvarez", "40924578", "1980-10-02", "jesus25@hotmail.com", "287-6700"); //1980-10-89
            
        }catch(DAOExcepcion e){
           Assert.fail("Fallo la insercion que " + e.getMessage());
        }
    
    }
    
   //@Test
    public void actualizarTest() throws DAOExcepcion{
        GestionResidente negocio = new GestionResidente();
        try{
            negocio.actualizar(4, "Juan", "perez", "4463172", "1982-02-15", "peplucho@terra.com.pe", "2871055");
        }catch(DAOExcepcion e){
            Assert.fail("Fallo la actualizacion: " + e.getMessage());
        }
    
    }
    
    //@Test
    public void eliminarTest() throws DAOExcepcion{
        GestionResidente negocio = new GestionResidente();
        try{
            negocio.eliminar(3);
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
                /*System.out.println(r.getDni());
                System.out.println(r.getEmail());*/
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