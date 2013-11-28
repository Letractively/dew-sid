package sid.modelo;

public class Reserva{
  private int idreserva;
  private String fecha;
  private String hora;  
  private int idespaciocomun;
  private int idresidente;
  
  public Reserva() {
        
  }

  public Reserva(int idreserva, String fecha, String hora, int idespaciocomun, int idresidente) {
        this.idreserva = idreserva;
        this.fecha = fecha;
        this.hora = hora;
        this.idespaciocomun = idespaciocomun;
        this.idresidente = idresidente;
  }

    public int getIdreserva() {
        return idreserva;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public int getIdespaciocomun() {
        return idespaciocomun;
    }

    public int getIdresidente() {
        return idresidente;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setIdespaciocomun(int idespaciocomun) {
        this.idespaciocomun = idespaciocomun;
    }

    public void setIdresidente(int idresidente) {
        this.idresidente = idresidente;
    }
  
  
  
}
