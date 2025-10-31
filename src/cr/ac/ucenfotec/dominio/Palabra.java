package cr.ac.ucenfotec.dominio;

public class Palabra {

    private String texto;
    private String categoria; // emoción o categoría técnica

    // Constructor
    public Palabra(String texto, String categoria) {
        this.texto = texto == null ? "" : texto.toLowerCase();
        this.categoria = categoria;
    }

    // Getters
    public String getTexto() { return texto; }
    public String getCategoria() { return categoria; }

    @Override
    public String toString() {
        return "Palabra{" + texto + " -> " + categoria + "}";
    }
}