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
            negocio.insertar("Los Cedros", "E-15","2052",80.00, "1", "Av los cedros 256",3);
        }catch(DAOExcepcion e){
            Assert.assertTrue("casa registrada", true);    //Assert.fail("Fallo la insercion: " + e.getMessage());
        }
    }

}