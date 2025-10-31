package cr.ac.ucenfotec.memoria;

import cr.ac.ucenfotec.dominio.Departamento;
import java.util.List;


public class DepartamentoRepo {
    public void save(Departamento d) {
        DataStore.departamentos.add(d);
    }

    public List<Departamento> list() {
        return DataStore.departamentos;
    }

    public Departamento findById(int id) {
        for (Departamento d : DataStore.departamentos) {
            if (d.getId() == id) return d;
        }
        return null;
    }
}