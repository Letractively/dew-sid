package sid.modelo;

public class Reserva{
  private int idreserva;
  private String fecha;
  private String hora;  
  private int tiempo;
  private int idespaciocomun;
  private int idresidente;
  private int estado;
  
  public Reserva() {
        
  }

  public Reserva(int idreserva, String fecha, String hora, int tiempo, int idespaciocomun, int idresidente, int estado) {
        this.idreserva = idreserva;
        this.fecha = fecha;
        this.hora = hora;
        this.tiempo = tiempo;
        this.idespaciocomun = idespaciocomun;
        this.idresidente = idresidente;
        this.estado = estado;
  }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getIdespaciocomun() {
        return idespaciocomun;
    }

    public void setIdespaciocomun(int idespaciocomun) {
        this.idespaciocomun = idespaciocomun;
    }

    public int getIdresidente() {
        return idresidente;
    }

    public void setIdresidente(int idresidente) {
        this.idresidente = idresidente;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
  
}
