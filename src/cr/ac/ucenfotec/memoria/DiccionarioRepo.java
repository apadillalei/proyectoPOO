package cr.ac.ucenfotec.memoria;

import cr.ac.ucenfotec.dominio.Diccionario;
import cr.ac.ucenfotec.dominio.Palabra;
import java.util.List;


public class DiccionarioRepo {
    public void save(Diccionario d) {
        DataStore.diccionarios.add(d);
    }

    public List<Diccionario> list() {
        return DataStore.diccionarios;
    }

    public Diccionario findById(int id) {
        for (Diccionario d : DataStore.diccionarios) {
            if (d.getId() == id) return d;
        }
        return null;
    }

    // Composición: un diccionario contiene palabras
    public boolean addPalabra(Diccionario dic, Palabra p) {
        dic.getPalabras().add(p);
        return false;
    }

    public List<Palabra> listPalabras(Diccionario dic) {
        return dic.getPalabras();
    }
}