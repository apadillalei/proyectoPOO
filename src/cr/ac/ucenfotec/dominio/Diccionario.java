package cr.ac.ucenfotec.dominio;

import java.util.*;

public class Diccionario {
    private int id;
    private String tipo;
    private final Map<String, String> entradas = new HashMap<>(); // palabra -> categoría

    // Constructor
    public Diccionario(String tipo) { this.tipo = tipo; }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }


    public List<Palabra> getPalabras() {
        List<Palabra> out = new ArrayList<>();
        for (Map.Entry<String, String> e : entradas.entrySet()) {
            out.add(new Palabra(e.getKey(), e.getValue()));
        }
        out.sort(Comparator.comparing(Palabra::getTexto));
        return Collections.unmodifiableList(out);
    }


    public boolean agregarPalabra(Palabra p) {
        if (p == null) return false;
        String key = p.getTexto() == null ? "" : p.getTexto().toLowerCase();
        if (key.isEmpty() || entradas.containsKey(key)) return false; // únicas
        entradas.put(key, p.getCategoria());
        return true;
    }

    public boolean eliminarPalabra(String texto) {
        if (texto == null) return false;
        return entradas.remove(texto.toLowerCase()) != null;
    }

    public String buscar(String texto) {
        if (texto == null) return null;
        return entradas.get(texto.toLowerCase());
    }


    public List<Palabra> listar() { return new ArrayList<>(getPalabras()); }

    @Override
    public String toString() {
        return "[" + id + "] Diccionario tipo='" + tipo + "' (" + entradas.size() + " palabras)";
    }
}