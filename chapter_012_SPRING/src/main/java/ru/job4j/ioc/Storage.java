package ru.job4j.ioc;

import java.util.List;

public interface Storage {

    void addUser(User user);
    List<User> getAll();
}
