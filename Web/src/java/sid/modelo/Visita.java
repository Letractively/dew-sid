/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sid.modelo;

import java.sql.Date;

/**
 *
 * @author Uwe.Mayo
 */
public class Visita {
    private int idvisita;
    private int dni_visita;
    private String nombre;
    private String fech_visita;
    private int idresidente;
    
    public Visita (){
        
    }
    
    public Visita(int idvisita, int dni_visita, String nombre, String fech_visita, int idresidente) {
        this.idvisita = idvisita;
        this.dni_visita = dni_visita;
        this.nombre = nombre;
        this.fech_visita = fech_visita;
        this.idresidente = idresidente;
    }

    public int getIdvisita() {
        return idvisita;
    }

    public void setIdvisita(int idvisita) {
        this.idvisita = idvisita;
    }

    public int getDni_visita() {
        return dni_visita;
    }

    public void setDni_visita(int dni_visita) {
        this.dni_visita = dni_visita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFech_visita() {
        return fech_visita;
    }

    public void setFech_visita(String fech_visita) {
        this.fech_visita = fech_visita;
    }

    public int getIdresidente() {
        return idresidente;
    }

    public void setIdresidente(int idresidente) {
        this.idresidente = idresidente;
    }
    
    
}
