package sid.modelo;

public class Residente {
    private int idresidente;
    private String nombres;
    private String apellidos;
    private String dni;
    private String fech_nac;
    private String email;
    private String password;

    public Residente() {
        
    }

    public Residente(int idresidente, String nombres, String apellidos, String dni, String fech_nac, String email, String password) {
        this.idresidente = idresidente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fech_nac = fech_nac;
        this.email = email;
        this.password = password;
    }

    public int getIdresidente() {
        return idresidente;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public String getFech_nac() {
        return fech_nac;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setIdresidente(int idresidente) {
        this.idresidente = idresidente;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFech_nac(String fech_nac) {
        this.fech_nac = fech_nac;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}