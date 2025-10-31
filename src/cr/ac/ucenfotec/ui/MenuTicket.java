package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.dominio.Ticket;
import cr.ac.ucenfotec.dominio.Usuario;
import cr.ac.ucenfotec.dominio.Departamento;

import cr.ac.ucenfotec.memoria.TicketRepo;
import cr.ac.ucenfotec.memoria.UsuarioRepo;
import cr.ac.ucenfotec.memoria.DepartamentoRepo;
import cr.ac.ucenfotec.memoria.TicketRepo;
import java.time.LocalDate;

public class MenuTicket {
    private final IO io = new IO();
    private final TicketRepo tRepo = new TicketRepo();
    private final UsuarioRepo uRepo = new UsuarioRepo();
    private final DepartamentoRepo dRepo = new DepartamentoRepo();

    public void mostrar() {
        int op;
        do {
            System.out.println("\n--- Tickets ---");
            System.out.println("1) Registrar ticket");
            System.out.println("2) Listar tickets");
            System.out.println("0) Volver");
            op = io.i("Opción: ");
            switch (op) {
                case 1:
                    registrar();
                    break;
                case 2:
                    listar();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (op != 0);
    }

    private void registrar() {
        if (uRepo.list().isEmpty() || dRepo.list().isEmpty()) {
            System.out.println(" Debes tener al menos 1 Usuario y 1 Departamento registrados.");
            return;
        }

        System.out.println("\n> Elige Usuario reportante:");
        uRepo.list().forEach(System.out::println);
        int uid = io.i("Id de usuario: ");
        Usuario u = uRepo.findById(uid);
        if (u == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.println("\n> Elige Departamento asignado:");
        dRepo.list().forEach(System.out::println);
        int did = io.i("Id de departamento: ");
        Departamento d = dRepo.findById(did);
        if (d == null) {
            System.out.println("Departamento no encontrado.");
            return;
        }

        String titulo = io.str("Título: ");
        String desc = io.str("Descripción: ");
        String estado = io.str("Estado (nuevo/en progreso/cerrado): ");

    }
    private void listar() {
        System.out.println("\nTickets registrados:");
        if (tRepo.list().isEmpty()) {
            System.out.println("(sin tickets)");
            return;
        }
        tRepo.list().forEach(System.out::println);
    }
}