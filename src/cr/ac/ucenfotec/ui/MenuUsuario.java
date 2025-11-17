package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.bl.entities.Usuario;
import cr.ac.ucenfotec.dl.UsuarioRepo;

public class MenuUsuario {
    private final IO io = new IO();
    private final UsuarioRepo repo = new UsuarioRepo();

    public void mostrar(){
        int op;
        do{
            System.out.println("\n--- Usuarios ---");
            System.out.println("1) Registrar");
            System.out.println("2) Listar");
            System.out.println("0) Volver");
            op = io.i("Opción: ");
            switch (op){
                case 1 -> registrar();
                case 2 -> listar();
                case 0 -> {}
                default -> System.out.println("Opción inválida.");
            }
        } while(op != 0);
    }

    private void registrar(){
        String nombre = io.str("Nombre completo: ");
        String correo = io.str("Correo: ");
        String pass   = io.str("Contraseña: ");
        String tel    = io.str("Teléfono: ");
        String rol    = io.str("Rol: ");


        Usuario u = new Usuario(nombre, correo, pass, tel, rol);
        repo.save(u);
        System.out.println("Registrado: " + u);
    }

    private void listar(){
        System.out.println("\nUsuarios registrados:");
        repo.list().forEach(System.out::println);
    }
}
