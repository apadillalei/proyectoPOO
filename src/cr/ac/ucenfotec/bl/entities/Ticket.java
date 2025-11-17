package cr.ac.ucenfotec.bl.entities;

public class Ticket {
    // Atributos
    private static int SEQ = 1;

    private final int id;
    private String asunto;
    private String descripcion;
    private String estado;           // "Nuevo" | "En Progreso" | "Resuelto"
    private String estadoAnimo;      // resultado del BoW
    private String categoriaTecnica; // resultado del BoW
    private Usuario usuario;         // asociación 1..1
    private Departamento departamento; // asociación 1..1

    // Constructor
    public Ticket(String asunto, String descripcion, String estado,
                  Usuario usuario, Departamento departamento) {
        this.id = SEQ++;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.estado = estado;
        this.usuario = usuario;
        this.departamento = departamento;
    }


    public int getId() { return id; }
    public String getAsunto() { return asunto; }
    public String getDescripcion() { return descripcion; }
    public String getEstado() { return estado; }
    public String getEstadoAnimo() { return estadoAnimo; }
    public String getCategoriaTecnica() { return categoriaTecnica; }
    public Usuario getUsuario() { return usuario; }
    public Departamento getDepartamento() { return departamento; }


    public void setResultadosAnalisis(String estadoAnimo, String categoriaTecnica) {
        this.estadoAnimo = estadoAnimo;
        this.categoriaTecnica = categoriaTecnica;
    }

    @Override
    public String toString() {
        return "Ticket{id=" + id +
                ", asunto='" + asunto + '\'' +
                ", estado='" + estado + '\'' +
                ", usuario=" + (usuario==null? "-" : usuario.getCorreo()) +
                ", depto=" + (departamento==null? "-" : departamento.getNombre()) +
                ", animo=" + (estadoAnimo==null? "-" : estadoAnimo) +
                ", categoria=" + (categoriaTecnica==null? "-" : categoriaTecnica) +
                '}';
    }
}