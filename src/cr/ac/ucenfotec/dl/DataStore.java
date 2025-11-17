package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.bl.entities.Departamento;
import cr.ac.ucenfotec.bl.entities.Diccionario;
import cr.ac.ucenfotec.bl.entities.Ticket;
import cr.ac.ucenfotec.bl.entities.Usuario;

import java.util.ArrayList;
import java.util.List;


public class DataStore {
    public static final List<Usuario> usuarios = new ArrayList<>();
    public static final List<Departamento> departamentos = new ArrayList<>();
    public static final List<Ticket> tickets = new ArrayList<>();
    public static final List<Diccionario> diccionarios = new ArrayList<>();
}