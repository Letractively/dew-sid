package sid.modelo;

public class Vivienda {
    int idvivienda;
    String tipoVivienda;
    String tipoUbicacion;
    String ubicacion;
    String numero;
    double metraje;
    int idresidente;
    String descripciontipo;
    
    
    public Vivienda(){
    
    }

    public Vivienda(int idvivienda, String tipoVivienda, String tipoUbicacion, String numero, double metraje, int idresidente) {
        this.idvivienda = idvivienda;
        this.tipoVivienda = tipoVivienda;
        this.tipoUbicacion = tipoUbicacion;
        this.numero = numero;
        this.metraje = metraje;
        this.idresidente = idresidente;
    }

 
    public int getIdvivienda() {
        return idvivienda;
    }

    public void setIdvivienda(int idvivienda) {
        this.idvivienda = idvivienda;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

   public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getMetraje() {
        return metraje;
    }

    public void setMetraje(double metraje) {
        this.metraje = metraje;
    }

   public int getIdresidente() {
        return idresidente;
    }

    public void setIdresidente(int idresidente) {
        this.idresidente = idresidente;
    }
    
    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public String getTipoUbicacion() {
        return tipoUbicacion;
    }

    public void setTipoUbicacion(String tipoUbicacion) {
        this.tipoUbicacion = tipoUbicacion;
    }

    public String getDescripciontipo() {
        return descripciontipo;
    }

    public void setDescripciontipo(String descripciontipo) {
        this.descripciontipo = descripciontipo;
    }
   
    
}
