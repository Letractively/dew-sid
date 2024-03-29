package sid.modelo;

public class Residente {
    private int idresidente;
    private String nombre;
    private String apellidos;
    private String tipodoc;
    private String nro;
    private String fech_nac;
    private String email;
    private String password;
    private String perfil;

    public Residente() {
        
    }

    public Residente(int idresidente, String nombres, String apellidos, String tipodoc, String nro, String fech_nac, String email, String password,String perfil) {
        this.idresidente = idresidente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipodoc = tipodoc;
        this.nro = nro;
        this.fech_nac = fech_nac;
        this.email = email;
        this.password = password;
        this.perfil = perfil;
    }

    public int getIdresidente() {
        return idresidente;
    }

    public void setIdresidente(int idresidente) {
        this.idresidente = idresidente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getFech_nac() {
        return fech_nac;
    }

    public void setFech_nac(String fech_nac) {
        this.fech_nac = fech_nac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
       
}