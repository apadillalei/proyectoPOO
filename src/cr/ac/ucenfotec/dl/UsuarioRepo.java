package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.bl.entities.Usuario;
import cr.ac.ucenfotec.dl.DataStore;

import java.util.List;

public class UsuarioRepo {
    private int contador = 1;

    public void save(Usuario u) {
        if (u.getId() == 0) {
            u.setId(contador++);
        }
        DataStore.usuarios.add(u);
    }

    public List<Usuario> list() {
        return DataStore.usuarios;
    }

    public Usuario findById(int id) {
        for (Usuario u : DataStore.usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }
}
