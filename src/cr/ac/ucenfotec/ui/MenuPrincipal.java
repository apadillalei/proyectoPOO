package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.ui.IO;

public class MenuPrincipal {
    private final IO io = new IO();

    private final MenuUsuario      menuUsuario      = new MenuUsuario();
    private final MenuDepartamento menuDepartamento = new MenuDepartamento();
    private final MenuTicket       menuTicket       = new MenuTicket();
    private final MenuDiccionario  menuDiccionario  = new MenuDiccionario();

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
                case 1 -> menuUsuario.mostrar();
                case 2 -> menuDepartamento.mostrar();
                case 3 -> menuTicket.mostrar();
                case 4 -> menuDiccionario.mostrar();
                case 0 -> System.out.println("¡Adiós!");
                default -> System.out.println("Opción inválida.");
            }
        } while(op != 0);
    }
}