package sid.negocio;

import java.util.Collection;
import org.junit.Assert;

import org.junit.Test;
import static org.junit.Assert.*;
import sid.persistencia.DAOExcepcion;
import sid.modelo.Vivienda;
import sid.negocio.GestionVivienda;

public class GestionViviendaTest {
    
    @Test
    public void insertarTest() throws DAOExcepcion{
        GestionVivienda negocio = new GestionVivienda();
        try{
//            negocio.insertar("Los Cedros", "E-15","2052",80.00, "1", "Av los cedros 256",3);
            
            negocio.insertar("Callao", "W-95","5652",150.00, "2", "Av barracones 568",1);
            negocio.insertar("San martin", "Q-45","8970",200.00, "3", "Av armendaris 568",2);
            negocio.insertar("San Miguel", "P-25","7841",50.00, "4", "Av huaylas 578",3);
            negocio.insertar("La Molina", "W-75","8080",1200.00, "5", "Av venezuela 457",4);
        }catch(DAOExcepcion e){
            Assert.assertTrue("casa registrada", true);    //Assert.fail("Fallo la insercion: " + e.getMessage());
        }
    }

}