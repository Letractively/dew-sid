package sid.modelo;

public class EspacioComun{
    private int idespaciocomun;
    private String nombre;
    private String tipo;
    
    public EspacioComun() {
        
    }

    public EspacioComun(int idespaciocomun, String nombre, String tipo) {
        this.idespaciocomun = idespaciocomun;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getIdespaciocomun() {
        return idespaciocomun;
    }

    public void setIdespaciocomun(int idespaciocomun) {
        this.idespaciocomun = idespaciocomun;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
