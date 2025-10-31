package cr.ac.ucenfotec.memoria;

import cr.ac.ucenfotec.dominio.Ticket;
import java.util.List;


public class TicketRepo {
    public void save(Ticket t) {
        DataStore.tickets.add(t);
    }

    public List<Ticket> list() {
        return DataStore.tickets;
    }

    public Ticket findById(int id) {
        for (Ticket t : DataStore.tickets) {
            if (t.getId() == id) return t;
        }
        return null;
    }
}