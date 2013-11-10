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
            negocio.insertar("Los sauces", "K-25","155",45.00, "2", "Av las artes 145",2);
        }catch(DAOExcepcion e){
            Assert.fail("Fallo la insercion: " + e.getMessage());
        }
    }

    
}