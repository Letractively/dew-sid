/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sid.negocio;

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sid.modelo.Queja;
import sid.persistencia.DAOExcepcion;

/**
 *
 * @author JULIO
 */
public class GestionQuejaTest {
    
    public GestionQuejaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertQueja method, of class GestionQueja.
     */
    @Test
    public void insertarTest() throws DAOExcepcion{
        GestionQueja negocio = new GestionQueja();
        try{
                       
            negocio.insertQueja("A","motivo","2013-11-12",1,"G");
            
        }catch(DAOExcepcion e){
           Assert.fail("Fallo la insercion: " + e.getMessage());
        }
    }
    /**
     * Test of Listaquejas method, of class GestionQueja.
     */
    @Test
    public void testListaquejas() throws Exception {
       GestionQueja negocio = new GestionQueja();
        try{
            Collection<Queja> listado = negocio.Listaquejas(1);
            //System.out.println(listado.size());
            for(Queja r:listado){
                System.out.println("idqueja: " + String.valueOf(r.getIdqueja()) +
                        " tipo_queja: " + String.valueOf(r.getTipo_queja()) +
                        " motivo: " + String.valueOf(r.getMotivo()) +
                        " fech_queja: " + String.valueOf(r.getFech_queja()) +
                        " estado : " + String.valueOf(r.getEstado()));
                /*System.out.println(r.getDni());
                System.out.println(r.getEmail());*/
            }
            Assert.assertTrue(listado.size()>0);
        }catch(DAOExcepcion e){
            Assert.fail("Fallo el listado: " + e.getMessage());
        }
    }
}