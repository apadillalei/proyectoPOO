package cr.ac.ucenfotec.dominio;

import java.text.Normalizer;
import java.util.*;

public class AnalisisBow {

    private final Diccionario tecnico;
    private final Diccionario emocional;

    // Constructor
    public AnalisisBow(Diccionario tecnico, Diccionario emocional) {
        this.tecnico = tecnico;
        this.emocional = emocional;
    }


    public String detectarEstadoAnimo(String descripcion) {
        String norm = normalizar(descripcion);
        List<String> toks = tokenizar(norm);
        Map<String,Integer> puntaje = new HashMap<>();
        for (String t : toks) {
            String emo = emocional.buscar(t);
            if (emo != null) puntaje.merge(emo, 1, Integer::sum);
        }
        return puntaje.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("Neutralidad");
    }

    public String sugerirCategoriaTecnica(String descripcion) {
        String norm = normalizar(descripcion);
        List<String> toks = tokenizar(norm);
        Map<String,Integer> puntaje = new HashMap<>();
        for (String t : toks) {
            String cat = tecnico.buscar(t);
            if (cat != null) puntaje.merge(cat, 1, Integer::sum);
        }
        return puntaje.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("General");
    }


    public String normalizar(String texto) {
        if (texto == null) return "";
        String s = texto.toLowerCase(Locale.ROOT);
        s = Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        s = s.replaceAll("[^a-z0-9áéíóúñ\\s]", " ");
        return s.replaceAll("\\s+", " ").trim();
    }

    public List<String> tokenizar(String texto) {
        if (texto == null || texto.isEmpty()) return Collections.emptyList();
        return Arrays.asList(texto.split("\\s+"));
    }
}