package ru.netology.repository;

import ru.netology.domain.Ticket;

public class Repository {
    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        tmp[length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public void removeById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int i = 0;
        for (Ticket ticket:tickets) {
            if (ticket.getId() != id) {
                tmp[i] = ticket;
                i++;
            }
        }
        tickets = tmp;
    }
}
