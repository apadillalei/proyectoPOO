package cr.ac.ucenfotec.bl.entities;

public class Usuario {

    private int id;
    private String nombreCompleto;
    private String correo;
    private String contrasena;
    private String telefono;
    private String rol;


    public Usuario(String nombreCompleto, String correo, String contrasena, String telefono, String rol) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.rol = rol;
    }


    public int getId() { return id; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getCorreo() { return correo; }
    public String getContrasena() { return contrasena; }
    public String getTelefono() { return telefono; }
    public String getRol() { return rol; }


    public void setId(int id) { this.id = id; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setRol(String rol) { this.rol = rol; }


    @Override
    public String toString() {
        return "[" + id + "] " + nombreCompleto + " - " + rol + " (" + correo + ")";
    }
}