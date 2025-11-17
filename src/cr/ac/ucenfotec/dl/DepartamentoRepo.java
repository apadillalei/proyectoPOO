package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.bl.entities.Departamento;
import cr.ac.ucenfotec.dl.DataStore;

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