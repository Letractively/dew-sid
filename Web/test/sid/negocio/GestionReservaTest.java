package sid.negocio;

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
           negocio.insertar("2013-12-19","04:30",1, 2);
        }catch(DAOExcepcion e){
           Assert.fail("Fallo la insercion: " + e.getMessage());
        }
    
 }
    
    
    
}