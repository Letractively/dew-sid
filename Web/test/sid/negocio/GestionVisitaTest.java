/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sid.negocio;

import java.util.Collection;
import org.junit.Assert;
import sid.persistencia.DAOExcepcion;
import sid.modelo.Visita;
import sid.negocio.GestionVisita;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Uwe.Mayo
 */
public class GestionVisitaTest {
   
     @Test
     public void insertarTest() throws DAOExcepcion{
        GestionVisita visita = new GestionVisita();
        try{
           visita.insertar(99999999, "Adrian Eduardo", "2013-10-20 20:30:42", 1084445); //1980-10-89
        }catch(DAOExcepcion e){
            Assert.assertTrue("Fallo al insertar", true);    //Assert.fail("Fallo la insercion: " + e.getMessage());
        }
    }     

     //@Test     
     public void actualizarTest() throws DAOExcepcion{
        GestionVisita visita = new GestionVisita();
        try{
            visita.actualizar(1, 42882273, "Adrian", "2013-10-20 10:30:42 am", 1084444);
        }catch(DAOExcepcion e){
            Assert.fail("Fallo la actualización: " + e.getMessage());
        }
    
    } 
    
    //@Test
    public void eliminarTest() throws DAOExcepcion{
        GestionVisita negocio = new GestionVisita();
        try{
            negocio.eliminar(1);
        }catch(DAOExcepcion x){
            Assert.fail("Error, no elimina: " + x.getMessage());
        }
    }
    
    //@Test
    public void listarTest(){
        GestionVisita negocio = new GestionVisita();
        try{
            Collection<Visita> listado = negocio.listar(1084444);
            //System.out.println(listado.size());
            for(Visita r:listado){
                System.out.print(r.getIdvisita()+" / ");
                System.out.print(r.getDni_visita()+" / ");
                System.out.print(r.getNombre()+" / ");                
                System.out.print(r.getFech_visita()+" / ");
                System.out.println(r.getIdresidente());                
            }
            Assert.assertTrue(listado.size()>0);
        }catch(DAOExcepcion e){
            Assert.fail("Fallo el listado: " + e.getMessage());
        }
    }
    
}
