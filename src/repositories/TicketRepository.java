package repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    Map<Long, Ticket> ticketStore;

    public TicketRepository() {
        ticketStore = new HashMap<>();
    }

    public void saveTicket(Ticket ticket) {
        ticketStore.put(ticket.getId(), ticket);
    }

    public Ticket getTicket(long ticketId) {
        return ticketStore.get(ticketId);
    }
}
