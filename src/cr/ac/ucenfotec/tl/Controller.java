package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.entities.Departamento;
import cr.ac.ucenfotec.bl.entities.Diccionario;
import cr.ac.ucenfotec.bl.entities.Palabra;
import cr.ac.ucenfotec.bl.entities.Ticket;
import cr.ac.ucenfotec.bl.entities.Usuario;
import cr.ac.ucenfotec.bl.logic.Gestor;
import cr.ac.ucenfotec.ui.MenuDepartamento;
import cr.ac.ucenfotec.ui.MenuDiccionario;
import cr.ac.ucenfotec.ui.MenuPrincipal;
import cr.ac.ucenfotec.ui.MenuTicket;
import cr.ac.ucenfotec.ui.MenuUsuario;

import java.util.List;

public class Controller {

    private final Gestor gestor;

    // Menús
    private final MenuPrincipal   menuPrincipal;
    private final MenuUsuario     menuUsuario;
    private final MenuDepartamento menuDepartamento;
    private final MenuTicket      menuTicket;
    private final MenuDiccionario menuDiccionario;

    public Controller() {
        gestor = new Gestor();

        // Pasamos this a los menús para que ellos llamen al controller
        menuUsuario      = new MenuUsuario(this);
        menuDepartamento = new MenuDepartamento(this);
        menuTicket       = new MenuTicket(this);
        menuDiccionario  = new MenuDiccionario(this);
        menuPrincipal    = new MenuPrincipal(this);
    }

    // ========= Arranque del programa =========
    public void iniciarPrograma() {
        menuPrincipal.iniciar();
    }

    // ========= Navegación desde el menú principal =========
    public void mostrarMenuUsuarios() {
        menuUsuario.mostrar();
    }

    public void mostrarMenuDepartamentos() {
        menuDepartamento.mostrar();
    }

    public void mostrarMenuTickets() {
        menuTicket.mostrar();
    }

    public void mostrarMenuDiccionarios() {
        menuDiccionario.mostrar();
    }

    // ========= LÓGICA DE NEGOCIO (usa Gestor) =========
    // USUARIOS
    public void registrarUsuario(String nombre, String correo, String pass, String tel, String rol) {
        Usuario u = new Usuario(nombre, correo, pass, tel, rol);
        gestor.guardarUsuario(u);
    }

    public List<Usuario> obtenerUsuarios() {
        return gestor.listarUsuarios();
    }

    public Usuario buscarUsuarioPorId(int id) {
        return gestor.buscarUsuarioPorId(id);
    }

    // DEPARTAMENTOS
    public void registrarDepartamento(String nombre, String desc, String contacto) {
        Departamento d = new Departamento(nombre, desc, contacto);
        gestor.guardarDepartamento(d);
    }

    public List<Departamento> obtenerDepartamentos() {
        return gestor.listarDepartamentos();
    }

    public Departamento buscarDepartamentoPorId(int id) {
        return gestor.buscarDepartamentoPorId(id);
    }

    // DICCIONARIOS
    public void crearDiccionario(String tipo) {
        Diccionario d = new Diccionario(tipo);
        gestor.guardarDiccionario(d);
    }

    public List<Diccionario> obtenerDiccionarios() {
        return gestor.listarDiccionarios();
    }

    public Diccionario buscarDiccionarioPorId(int id) {
        return gestor.buscarDiccionarioPorId(id);
    }

    public void agregarPalabraADiccionario(Diccionario dic, String texto, String categoria) {
        Palabra p = new Palabra(texto, categoria);
        gestor.agregarPalabraADiccionario(dic, p);
    }

    public List<Palabra> obtenerPalabrasDeDiccionario(Diccionario dic) {
        return gestor.listarPalabrasDeDiccionario(dic);
    }

    // TICKETS
    public void registrarTicket(String titulo, String desc, String estado, Usuario usuario, Departamento departamento) {
        // ⚠ Ajustá este constructor al que tenga tu clase Ticket
        Ticket t = new Ticket(titulo, desc, estado, usuario, departamento);
        gestor.guardarTicket(t);
    }

    public List<Ticket> obtenerTickets() {
        return gestor.listarTickets();
    }
}
