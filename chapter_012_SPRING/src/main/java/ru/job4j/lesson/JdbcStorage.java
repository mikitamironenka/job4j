package ru.job4j.lesson;

public class JdbcStorage implements Storage {
    @Override
    public void add(User user) {
        System.out.println("jdbc storage");
    }
}
