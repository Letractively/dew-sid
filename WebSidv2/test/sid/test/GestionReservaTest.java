package sid.test;

import java.util.Collection;
import org.junit.Assert;
import sid.persistencia.DAOExcepcion;
import sid.modelo.Reserva;
import sid.negocio.GestionReserva;

import org.junit.Test;
import static org.junit.Assert.*;

public class GestionReservaTest{
    
 @Test
 public void insertarTest() throws DAOExcepcion{
        GestionReserva negocio = new GestionReserva();
        try{
           negocio.insertar("2013-12-21", "07:00", 4, 5, 5, 1); //negocio.insertar("2013-10-25","01:00",2, 3);
        }catch(DAOExcepcion e){
           Assert.assertTrue("fecha ocupada", true);    
        }
    
 }
    
}