/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sid.negocio;

import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import sid.modelo.Cuota;
import sid.modelo.Residente;
import sid.persistencia.DAOExcepcion;

/**
 *
 * @author proyecto
 */
public class GestionCuotaTest {
    
    @Test
    public void insertarTest() throws DAOExcepcion{
        GestionCuota negocio = new GestionCuota();
        try{
                       
            negocio.insertar(2, "03", 2013, 245.32, "2013-10-11", "P", null, null);
            
        }catch(DAOExcepcion e){
           Assert.fail("Fallo la insercion: " + e.getMessage());
        }
    
    }
    
    @Test
    public void actualizarTest() throws DAOExcepcion{
        GestionCuota negocio = new GestionCuota();
        try{
            Cuota cuota = new Cuota();
            cuota = negocio.actualizar(1, "01", 2013, 245.32, "2013-10-11", "C", "E", "2013-11-11",1);
            System.out.print(cuota.getfech_pago());
        }catch(DAOExcepcion e){
            Assert.fail("Fallo la actualizacion: " + e.getMessage());
        }
    
    }
    
    //@Test
    public void eliminarTest() throws DAOExcepcion{
        GestionCuota negocio = new GestionCuota();
        try{
            negocio.eliminar(1);
        }catch(DAOExcepcion x){
            Assert.fail("Error, no elimina: " + x.getMessage());
        }
    }
    
   @Test
    public void listarTest(){
        GestionCuota negocio = new GestionCuota();
        try{
            Collection<Cuota> listado = negocio.listarpendientes(2);
            //System.out.println(listado.size());
            for(Cuota r:listado){
                System.out.println(r.getestado());
                System.out.println(r.getimporte());
                /*System.out.println(r.getDni());
                System.out.println(r.getEmail());*/
            }
            Assert.assertTrue(listado.size()>0);
        }catch(DAOExcepcion e){
            Assert.fail("Fallo el listado: " + e.getMessage());
        }
    }
    
}