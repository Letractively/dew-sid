/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sid.negocio;

/**
 *
 * @author proyecto
 */
import java.util.Collection;

import sid.persistencia.MensajeriaDAO;
import sid.persistencia.DAOExcepcion;
import sid.modelo.Mensajeria;

/**
 *
 * @author proyecto
 */
public class GestionMensajeria {

    public Mensajeria insertar(String titulo, String contenido, String fecha, int id_Residente)
            throws DAOExcepcion {
        MensajeriaDAO dao = new MensajeriaDAO();

        Mensajeria vo = new Mensajeria();
        vo.setTitulo(titulo);
        vo.setContenido(contenido);
        vo.setFech_public(fecha);
        vo.setId_Residente(id_Residente);

        return dao.insertar(vo);
    }

    public Collection<Mensajeria> listar() throws DAOExcepcion {
        MensajeriaDAO dao = new MensajeriaDAO();

        return dao.listar();
    }
}

