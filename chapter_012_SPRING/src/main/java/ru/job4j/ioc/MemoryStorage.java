package ru.job4j.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemoryStorage implements Storage {

    @Autowired
    public MemoryStorage() {

    }
    @Override
    public void addUser(User user) {
        System.out.println("store to memory");
    }
}
