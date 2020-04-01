package ru.job4j.tdd.cinema;

import java.util.List;

public class AccountCinema implements Account {
    @Override
    public boolean returnTicket(Ticket ticket) {
        return false;
    }

    @Override
    public boolean addToShoppingCart(List<Ticket> ticket) {
        return false;
    }

    @Override
    public boolean getDiscont() {
        return false;
    }
}
