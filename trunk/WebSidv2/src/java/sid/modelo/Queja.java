/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sid.modelo;

/**
 *
 * @author JULIO
 */
public class Queja {
    int idqueja;
    String tipo_queja;
    String motivo;
    String fech_queja;
    int idresidente;
    String estado;

    public int getIdqueja() {
        return idqueja;
    }

    public void setIdqueja(int idqueja) {
        this.idqueja = idqueja;
    }

    public String getTipo_queja() {
        return tipo_queja;
    }

    public void setTipo_queja(String tipo_queja) {
        this.tipo_queja = tipo_queja;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFech_queja() {
        return fech_queja;
    }

    public void setFech_queja(String fech_queja) {
        this.fech_queja = fech_queja;
    }

    public int getIdresidente() {
        return idresidente;
    }

    public void setIdresidente(int idresidente) {
        this.idresidente = idresidente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
