/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sid.modelo;

/**
 *
 * @author Uwe.Mayo
 */
public class Junta {
    int idjunta;
    int idresidente;
    String expositor;
    String tema;
    String fecha_ini;
    String fecha_fin;
    String acuerdo;

    public Junta() {
    }

    public Junta(int idjunta, int idresidente, String expositor, String tema, String fecha_ini, String fecha_fin, String acuerdo) {
        this.idjunta = idjunta;
        this.idresidente = idresidente;
        this.expositor = expositor;
        this.tema = tema;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
        this.acuerdo = acuerdo;
    }

    public int getIdjunta() {
        return idjunta;
    }

    public void setIdjunta(int idjunta) {
        this.idjunta = idjunta;
    }

    public int getIdresidente() {
        return idresidente;
    }

    public void setIdresidente(int idresidente) {
        this.idresidente = idresidente;
    }

    public String getExpositor() {
        return expositor;
    }

    public void setExpositor(String expositor) {
        this.expositor = expositor;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(String fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getAcuerdo() {
        return acuerdo;
    }

    public void setAcuerdo(String acuerdo) {
        this.acuerdo = acuerdo;
    }
        
}