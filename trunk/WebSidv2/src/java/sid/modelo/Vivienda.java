package sid.modelo;

public class Vivienda {
    int idvivienda;
    String zona;
    String edificio;
    String numero;
    double metraje;
    String tipo;
    String direccion;
    int idresidente;
    
    public Vivienda(){
    
    }
    
    public int getIdvivienda() {
        return idvivienda;
    }

    public void setIdvivienda(int idvivienda) {
        this.idvivienda = idvivienda;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdresidente() {
        return idresidente;
    }

    public void setIdresidente(int idresidente) {
        this.idresidente = idresidente;
    }
}
