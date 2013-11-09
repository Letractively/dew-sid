/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sid.modelo;


/**
 *
 * @author proyecto
 */
public class Cuota {
     int idcuota;
    int idvivienda;
    String periodo;
    int anio;
    double importe;
    String fech_venc;
    String estado;
    String tipo_pago;
    String fech_pago;
    private Residente residente;
    private Vivienda vivienda;

    public Vivienda getVivienda() {
        return vivienda;
    }

    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }

    public Residente getResidente() {
        return residente;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;
    }
    
    
    public int getIdCuotas() {
        return idcuota;
    }

    public void setIdCuotas(int idcuota) {
        this.idcuota = idcuota;
    }

    public int getidvivienda() {
        return idvivienda;
    }

    public void setidvivienda(int idvivienda) {
        this.idvivienda = idvivienda;
    }

    public String getperiodo() {
        return periodo;
    }

    public void setperiodo(String periodo) {
        this.periodo = periodo;
    }

    public int getanio() {
        return anio;
    }

    public void setanio(int anio) {
        this.anio = anio;
    }

    public double getimporte() {
        return importe;
    }

    public void setimporte(double importe) {
        this.importe = importe;
    }

    public String getfech_venc() {
        return fech_venc;
    }

    public void setfech_venc(String fech_venc) {
        this.fech_venc = fech_venc;
    }

    public String getestado() {
        return estado;
    }

    public void setestado(String estado) {
        this.estado = estado;
    }

    public String gettipo_pago() {
        return tipo_pago;
    }

    public void settipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getfech_pago() {
        return fech_pago;
    }

    public void setfech_pago(String fech_pago) {
        this.fech_pago = fech_pago;
    }
}
