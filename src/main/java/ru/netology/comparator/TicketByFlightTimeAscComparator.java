package ru.netology.comparator;

import ru.netology.domain.Ticket;

import java.util.Comparator;

public class TicketByFlightTimeAscComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getFlightTime() - o2.getFlightTime();
    }
}
