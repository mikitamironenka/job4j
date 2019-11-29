package ru.job4j.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserStorage {

    private Storage storage;

    @Autowired
    public UserStorage(@Qualifier("memoryStorage") Storage storage) {
        this.storage = storage;
    }

    public void addUser(User user) {
        this.storage.addUser(user);
    }

    public List<User> getAll() {
        return this.storage.getAll();
    }
}
