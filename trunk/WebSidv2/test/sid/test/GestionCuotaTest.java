/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sid.test;

import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import sid.modelo.Cuota;
import sid.modelo.Residente;
import sid.negocio.GestionCuota;
import sid.persistencia.DAOExcepcion;

/**
 *
 * @author proyecto
 */
public class GestionCuotaTest {
    
//    @Test
    public void insertarTest() throws DAOExcepcion{
        GestionCuota negocio = new GestionCuota();
        try{
                       
//            negocio.insertar(2, "03", 2013, 245.32, "2013-10-11", "P", null, null);
            
             negocio.insertar(1, "01", 2013, 245.32, "2013-10-11", "P", null, null);
            negocio.insertar(2, "02", 2013, 245.32, "2013-11-11", "c", null, null);
            negocio.insertar(3, "03", 2013, 245.32, "2013-10-11", "P", null, null);
            negocio.insertar(4, "04", 2013, 245.32, "2013-10-11", "c", null, null);
            
        }catch(DAOExcepcion e){
           Assert.fail("Fallo la insercion: " + e.getMessage());
        }
    
    }
    
//    @Test
    public void actualizarTest() throws DAOExcepcion{
        GestionCuota negocio = new GestionCuota();
        try{
            Cuota cuota = new Cuota();
//            cuota = negocio.actualizar(5, "02", 2013, 245.32, "2013-10-11", "C", "E", "2013-11-11",2);
            
            cuota = negocio.actualizar(1, "01", 2013, 320.45, "2013-10-11", "C", "C", "2013-11-11",1);
            cuota = negocio.actualizar(2, "02", 2013, 190.90, "2013-11-11", "P", "E","2013-12-11", 2);
            cuota = negocio.actualizar(3, "03", 2013, 210.10, "2013-10-11", "C", "C","2013-11-11", 3);
            cuota = negocio.actualizar(4, "04", 2013, 223.65, "2013-10-11", "P", "E", "2013-12-11",4);
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
    
//   @Test
    public void listarTest(){
        GestionCuota negocio = new GestionCuota();
        try{
            Collection<Cuota> listado = negocio.listarvencidas();
            //System.out.println(listado.size());
            for(Cuota r:listado){
                System.out.println("idcuota: " + String.valueOf(r.getIdCuotas()) +
                        " año: " + String.valueOf(r.getanio()) +
                        " periodo: " + String.valueOf(r.getperiodo()) +
                        " nombre: " + String.valueOf(r.getResidente().getNombres()) +
                        " DNI : " + String.valueOf(r.getResidente().getDni()) +
                        " importe: " + String.valueOf(r.getimporte())     +                     
//                        " direccion: " + r.getVivienda().getDireccion() +
                        " fecha vencimiento: " + String.valueOf(r.getfech_venc()));
                /*System.out.println(r.getDni());
                System.out.println(r.getEmail());*/
            }
            Assert.assertTrue(listado.size()>=0);
        }catch(DAOExcepcion e){
            Assert.fail("Fallo el listado: " + e.getMessage());
        }
    }
    
   @Test
    public void listarvencidasTest(){
        GestionCuota negocio = new GestionCuota();
        try{
            Collection<Cuota> listado = negocio.listarvencidas();
            //System.out.println(listado.size());
            for(Cuota r:listado){
                System.out.println("idcuota: " + String.valueOf(r.getIdCuotas()) +
                        " año: " + String.valueOf(r.getanio()) +
                        " periodo: " + String.valueOf(r.getperiodo()) +
                        " nombre: " + String.valueOf(r.getResidente().getNombres()) +
                        " DNI : " + String.valueOf(r.getResidente().getDni()) +
                        " importe: " + String.valueOf(r.getimporte())     +                     
//                        " direccion: " + r.getVivienda().getDireccion() +
                        " fecha vencimiento: " + String.valueOf(r.getfech_venc()));
                /*System.out.println(r.getDni());
                System.out.println(r.getEmail());*/
            }
             System.out.println(listado.size());
            Assert.assertTrue(listado.size()>=0);
        }catch(DAOExcepcion e){
            Assert.fail("Fallo el listado: ");
        }
    }
    
   
}
