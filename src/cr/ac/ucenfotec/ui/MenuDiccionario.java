package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.bl.entities.Diccionario;
import cr.ac.ucenfotec.bl.entities.Palabra;
import cr.ac.ucenfotec.dl.DiccionarioRepo;

public class MenuDiccionario {
    private final IO io = new IO();
    private final DiccionarioRepo repo = new DiccionarioRepo();

    public void mostrar(){
        int op;
        do{
            System.out.println("\n--- Diccionarios / Palabras ---");
            System.out.println("1) Crear diccionario (tipo: emocional/tecnico)");
            System.out.println("2) Agregar palabra a un diccionario");
            System.out.println("3) Listar diccionarios");
            System.out.println("4) Listar palabras de un diccionario");
            System.out.println("0) Volver");
            op = io.i("Opción: ");

            switch (op){
                case 1 -> crearDiccionario();
                case 2 -> agregarPalabra();
                case 3 -> listarDiccionarios();
                case 4 -> listarPalabras();
                case 0 -> {}
                default -> System.out.println("Opción inválida.");
            }
        } while(op != 0);
    }

    private void crearDiccionario(){
        String tipo = io.str("Tipo (emocional/tecnico): ");
        Diccionario d = new Diccionario(tipo);
        repo.save(d);
        System.out.println("Creado: " + d);
    }

    private void agregarPalabra(){
        if (repo.list().isEmpty()){
            System.out.println("⚠ No hay diccionarios. Crea uno primero.");
            return;
        }

        listarDiccionarios();
        int id = io.i("Id del diccionario: ");
        Diccionario dic = repo.findById(id);
        if (dic == null){
            System.out.println("Diccionario no encontrado.");
            return;
        }

        String texto = io.str("Palabra: ");
        String categoria = io.str("Categoría/Emoción: ");

        boolean ok = repo.addPalabra(dic, new Palabra(texto, categoria));
        System.out.println(ok ? "Palabra agregada." : "⚠ No se pudo agregar (id inválido o palabra repetida).");
    }

    private void listarDiccionarios(){
        System.out.println("\nDiccionarios:");
        if (repo.list().isEmpty()){
            System.out.println("(sin diccionarios)");
            return;
        }
        repo.list().forEach(System.out::println);
    }

    private void listarPalabras(){
        if (repo.list().isEmpty()){
            System.out.println("No hay diccionarios. Crea uno primero.");
            return;
        }

        listarDiccionarios();
        int id = io.i("Id del diccionario: ");
        Diccionario dic = repo.findById(id);
        if (dic == null){
            System.out.println("Diccionario no encontrado.");
            return;
        }

        System.out.println("\nPalabras:");
        var palabras = repo.listPalabras(dic);
        if (palabras == null || palabras.isEmpty()){
            System.out.println("(sin palabras)");
            return;
        }
        palabras.forEach(System.out::println);
    }
}