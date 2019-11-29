package ru.job4j.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryStorage implements Storage {

    private List<User> userList;

    @Autowired
    public MemoryStorage() {
        this.userList = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        System.out.println("store to memory");
        this.userList.add(user);
    }

    @Override
    public List<User> getAll() {
        return this.userList;
    }
}
