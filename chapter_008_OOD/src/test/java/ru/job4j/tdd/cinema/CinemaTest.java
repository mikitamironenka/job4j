package ru.job4j.tdd.cinema;

import jdk.jfr.Description;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

//1. Посмотрите на созданные тесты. Опишите, каких тестов тут не хватает?
//2. Допишите не достающие тесты. Классы реализовывать не нужно.

public class CinemaTest {

    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Description("Возвращаем билет.")
    @Test
    public void returnTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        boolean result = account.returnTicket(ticket);
        assertTrue(result);
    }

    @Description("Добавляем выбранный билет в корзину. " +
        "Добавление должно произойти успешно.")
    @Test
    public void whenTicketAddToShoppingCartThenShouldReturnTrue() {
        Account account = new AccountCinema();
        Ticket ticket = new Ticket3D();
        boolean result = account.addToShoppingCart(List.of(ticket));
        assertTrue(result);
    }

    @Description("Запрашиваем скидку за покупку 4х билетов")
    @Test
    public void whenAskForDiscont() {
        Account account = new AccountCinema();
        Ticket ticket1 = new Ticket3D();
        Ticket ticket2 = new Ticket3D();
        Ticket ticket3 = new Ticket3D();
        Ticket ticket4 = new Ticket3D();
        account.addToShoppingCart(List.of(ticket1, ticket2, ticket3, ticket4));
        boolean result  = account.getDiscont();
        assertTrue(result);
    }

}