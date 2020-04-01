package ru.job4j.tdd.cinema;

import java.util.List;

public interface Account {
    boolean returnTicket(Ticket ticket);

    boolean addToShoppingCart(List<Ticket> ticket);

    boolean getDiscont();
}
