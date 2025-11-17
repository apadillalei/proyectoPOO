package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.bl.entities.Ticket;
import cr.ac.ucenfotec.dl.DataStore;

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