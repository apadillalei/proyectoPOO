package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.tl.Controller;

public class MenuPrincipal {

    private final IO io = new IO();
    private final Controller controller;

    public MenuPrincipal(Controller controller) {
        this.controller = controller;
    }

    public void iniciar(){
        int op;
        do{
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1) Usuarios (registrar / listar)");
            System.out.println("2) Departamentos (registrar / listar)");
            System.out.println("3) Tickets (registrar / listar)");
            System.out.println("4) Diccionarios/Palabras (crear / agregar / listar)");
            System.out.println("0) Salir");
            op = io.i("Opción: ");

            switch (op){
                case 1 -> controller.mostrarMenuUsuarios();
                case 2 -> controller.mostrarMenuDepartamentos();
                case 3 -> controller.mostrarMenuTickets();
                case 4 -> controller.mostrarMenuDiccionarios();
                case 0 -> System.out.println("¡Adiós!");
                default -> System.out.println("Opción inválida.");
            }
        } while(op != 0);
    }
}
