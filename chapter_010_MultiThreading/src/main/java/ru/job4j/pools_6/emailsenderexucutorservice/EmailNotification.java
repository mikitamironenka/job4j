package ru.job4j.pools_6.emailsenderexucutorservice;

//1. Реализовать сервис для рассылки почты. Создайте класс EmailNotification.
//2. В классе будет метод emailTo(User user) - он должен через ExecutorService отправлять почту.
// Так же добавьте метод close() - он должен закрыть pool.
// То есть в классе EmailNotification должно быть поле pool,
// которые используется в emailTo и close().
//3. Модель User описывают поля username, email.
//4. Метод emailTo должен брать данные пользователя и подставлять в шаблон
//subject = Notification {username} to email {email}.
//body = Add a new event to {username}
//5. создайте метод public void send(String suject, String body, String email) - он должен быть пустой.
//6. Через ExecutorService создайте задачу, которая будет создавать данные для пользователя и передавать их в метод send.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {

    ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    /**
     * Send email with ExecutorService
     * @param user
     */
    public void emailTo(User user) {
        String subject = String.format("Notification %s to email %s", user.getUserName(), user.getEmail());
        String body = String.format("Add a new event to %s", user.getUserName());
        pool.submit(() -> send(subject, body, user.getEmail()));
    }

    /**
     * Close the pool
     */
    public void close() {
        this.pool.shutdown();
    }

    public void send(String suject, String body, String email) {}
}
