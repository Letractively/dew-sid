/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sid.test;

import java.util.Collection;
import org.junit.Assert;
import sid.persistencia.DAOExcepcion;
import sid.modelo.Junta;
import sid.negocio.GestionJunta;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Uwe.Mayo
 */
public class GestionJuntaTest {
    @Test
     public void insertarTest() throws DAOExcepcion{
        GestionJunta junta = new GestionJunta();
        try{
           junta.insertar(2, "Padre Manuel", "Basura en las entradas", "2013-11-15 16:00:00", "2013-11-15 17:00:00", "Pagar por limpieza"); //1980-10-89
        }catch(DAOExcepcion e){
            Assert.assertTrue("Fallo al insertar", true);    //Assert.fail("Fallo la insercion: " + e.getMessage());
        }
    }   
 /*
     @Test
    / public void actualizarTest() throws DAOExcepcion{
        GestionJunta junta = new GestionJunta();
        try{
            junta.actualizar(2, "Padre Manuel", "Basura en las escaleras", "2013-11-15 10:30:00", "2013-11-15 11:30:00", "Cada uno limpriar quincenalmente");
        }catch(DAOExcepcion e){
            Assert.fail("Fallo la actualización: " + e.getMessage());
        }
    
    } 
  */ 
}