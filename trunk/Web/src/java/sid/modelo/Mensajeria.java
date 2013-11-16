/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sid.modelo;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author proyecto
 */
public class Mensajeria {

    private int id_Mensajeria;
    private String titulo;
    private String contenido;
    private String fech_public;
    private int id_Residente;
    private Collection<Mensajeria> mensajeria = new ArrayList<Mensajeria>();

    public Mensajeria() {
    }

    public Mensajeria(int id_Mensajeria, String titulo, String contenido, String fech_public, int id_Residente) {
        super();
        this.id_Mensajeria = id_Mensajeria;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fech_public = fech_public;
        this.id_Residente = id_Residente;
    }

    public int getId_Mensajeria() {
        return id_Mensajeria;
    }

    public void setId_Mensajeria(int id_Mensajeria) {
        this.id_Mensajeria = id_Mensajeria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFech_public() {
        return fech_public;
    }

    public void setFech_public(String fech_public) {
        this.fech_public = fech_public;
    }

    public Collection<Mensajeria> getMensajeria() {
        return mensajeria;
    }

    public void setMensajeria(Collection<Mensajeria> mensajeria) {
        this.mensajeria = mensajeria;
    }

    public int getId_Residente() {
        return id_Residente;
    }

    public void setId_Residente(int id_Residente) {
        this.id_Residente = id_Residente;
    }
}