package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.comparator.TicketByFlightTimeAscComparator;
import ru.netology.domain.Ticket;
import ru.netology.repository.Repository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Ticket[] testTickets = {
            new Ticket(1, 149, "HEL", "RIX", 60),
            new Ticket(2, 58, "HEL", "WMI", 105),
            new Ticket(3, 17, "LTN", "DUB", 75),
            new Ticket(4, 58, "LIS", "VLC", 90),
            new Ticket(5, 18, "STN", "DUB", 75),
            new Ticket(6, 23, "HEL", "RIX", 65),
            new Ticket(7, 17, "VLC", "LIS", 90),
            new Ticket(8, 179, "HEL", "TKU", 35),
            new Ticket(9, 203, "HEL", "TKU", 35),
            new Ticket(10, 179, "HEL", "TKU", 35),
            new Ticket(11, 32, "HEL", "RIX", 65),
            new Ticket(12, 74, "HEL", "RIX", 65),
    };

    @Test
    public void saveAndFindAll() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.add(testTickets[0]);
        manager.add(testTickets[1]);
        manager.add(testTickets[2]);
        manager.add(testTickets[3]);
        manager.add(testTickets[4]);
        manager.add(testTickets[5]);
        manager.add(testTickets[6]);
        manager.add(testTickets[7]);
        manager.add(testTickets[8]);
        manager.add(testTickets[9]);
        manager.add(testTickets[10]);
        manager.add(testTickets[11]);

        Ticket[] actual = manager.findAll("HEL", "RIX");
        Ticket[] expected = {testTickets[5], testTickets[10], testTickets[11], testTickets[0]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void saveAndFindAllNull() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.add(testTickets[0]);
        manager.add(testTickets[1]);
        manager.add(testTickets[2]);
        manager.add(testTickets[3]);
        manager.add(testTickets[4]);
        manager.add(testTickets[5]);
        manager.add(testTickets[6]);
        manager.add(testTickets[7]);
        manager.add(testTickets[8]);
        manager.add(testTickets[9]);
        manager.add(testTickets[10]);
        manager.add(testTickets[11]);

        Ticket[] actual = manager.findAll("HEL", "MOW");
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void saveAndFindAllTheSame() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.add(testTickets[0]);
        manager.add(testTickets[1]);
        manager.add(testTickets[2]);
        manager.add(testTickets[3]);
        manager.add(testTickets[4]);
        manager.add(testTickets[5]);
        manager.add(testTickets[6]);
        manager.add(testTickets[7]);
        manager.add(testTickets[8]);
        manager.add(testTickets[9]);
        manager.add(testTickets[10]);
        manager.add(testTickets[11]);

        Ticket[] actual = manager.findAll("HEL", "TKU");
        Ticket[] expected = {testTickets[7], testTickets[9], testTickets[8]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void saveAndFindAllByFlightTimeAsc() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        TicketByFlightTimeAscComparator comparator = new TicketByFlightTimeAscComparator();

        manager.add(testTickets[0]);
        manager.add(testTickets[1]);
        manager.add(testTickets[2]);
        manager.add(testTickets[3]);
        manager.add(testTickets[4]);
        manager.add(testTickets[5]);
        manager.add(testTickets[6]);
        manager.add(testTickets[7]);
        manager.add(testTickets[8]);
        manager.add(testTickets[9]);
        manager.add(testTickets[10]);
        manager.add(testTickets[11]);

        Ticket[] actual = manager.findAll("HEL", "RIX", comparator);
        Ticket[] expected = {testTickets[0], testTickets[5], testTickets[10], testTickets[11]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void saveAndFindAllNullByFlightTimeAsc() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        TicketByFlightTimeAscComparator comparator = new TicketByFlightTimeAscComparator();

        manager.add(testTickets[0]);
        manager.add(testTickets[1]);
        manager.add(testTickets[2]);
        manager.add(testTickets[3]);
        manager.add(testTickets[4]);
        manager.add(testTickets[5]);
        manager.add(testTickets[6]);
        manager.add(testTickets[7]);
        manager.add(testTickets[8]);
        manager.add(testTickets[9]);
        manager.add(testTickets[10]);
        manager.add(testTickets[11]);

        Ticket[] actual = manager.findAll("HEL", "MOW", comparator);
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }

}