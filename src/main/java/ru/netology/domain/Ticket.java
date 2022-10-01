package ru.netology.domain;

import lombok.Data;

import java.util.Objects;

@Data
public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String departurePort;
    private String arrivalPort;
    private int flightTime;

    public Ticket(int id, int price, String departurePort, String arrivalPort, int flightTime) {
        this.id = id;
        this.price = price;
        this.departurePort = departurePort;
        this.arrivalPort = arrivalPort;
        this.flightTime = flightTime;
    }

    @Override
    public int compareTo(Ticket other) {
        if (price < other.price) {
           return -1;
        }
        if (price > other.price) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && price == ticket.price && flightTime == ticket.flightTime && departurePort.equals(ticket.departurePort) && arrivalPort.equals(ticket.arrivalPort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, departurePort, arrivalPort, flightTime);
    }

}
