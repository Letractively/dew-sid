/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sid.test;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import sid.persistencia.DAOExcepcion;
import sid.modelo.Mensajeria;
import sid.negocio.GestionMensajeria;

/**
 *
 * @author proyecto
 */
public class GestionMensajeriaTest {

//    @Test
    public void insertarTest() {

        GestionMensajeria negocio = new GestionMensajeria();

        try {
//            negocio.insertar("navidad", "prospera fiestas de nacimiento", "1994-05-29", 5);
            negocio.insertar("bajada reyes", "olaaaaaaaaaaa", "1987-12-12", 8);
            negocio.insertar("jfdvlkhvlkjlk", "hdkjhckjdhc", "1999-09-19", 2);

//			Categoria nuevo = negocio.obtener(7);

//			Assert.assertEquals("Categoria de electrónicos", nuevo.getDescripcion());

        } catch (DAOExcepcion e) {
            Assert.fail("Fallo la inserción: " + e.getMessage());
        }
    }

    @Test
    public void listarTest() {

        GestionMensajeria negocio = new GestionMensajeria();

        try {
            Collection<Mensajeria> listado = negocio.listar();

            System.out.println(listado.size());

            for (Mensajeria c : listado) {
//                System.out.println(c.getId_Mensajeria());
                System.out.println(c.getFech_public());
                System.out.println(c.getTitulo());
                System.out.println(c.getContenido());
                System.out.println(c.getId_Residente());
            }

            Assert.assertTrue(listado.size() > 0);

        } catch (DAOExcepcion e) {

            Assert.fail("Falló el listado: " + e.getMessage());

        }

    }
}