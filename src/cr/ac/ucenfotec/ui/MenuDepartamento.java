package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.dominio.Departamento;
import cr.ac.ucenfotec.memoria.DepartamentoRepo;

public class MenuDepartamento {
    private final IO io = new IO();
    private final DepartamentoRepo repo = new DepartamentoRepo();

    public void mostrar(){
        int op;
        do{
            System.out.println("\n--- Departamentos ---");
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
        String nombre   = io.str("Nombre: ");
        String desc     = io.str("Descripción: ");
        String contacto = io.str("Correo de contacto: ");

        Departamento d = new Departamento(nombre, desc, contacto);
        repo.save(d);
        System.out.println("Registrado: " + d);
    }

    private void listar(){
        System.out.println("\nDepartamentos registrados:");
        repo.list().forEach(System.out::println);
    }
}