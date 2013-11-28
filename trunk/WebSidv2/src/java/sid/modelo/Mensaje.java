package sid.modelo;

public class Mensaje {
   private int cod;
   private String titulo;
   private String descripcion;
   private String fecha;
   private int estado;
   
   public Mensaje(){
   
   }

    public Mensaje(int cod, String titulo, String descripcion, String fecha, int estado) {
        this.cod = cod;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getCod() {
        return cod;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
   
}