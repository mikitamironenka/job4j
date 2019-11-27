package ru.job4j.ioc;

public class UserStorage {

    private Storage storage;

    public UserStorage(Storage storage) {
        this.storage = storage;
    }

    public void addUser(User user) {
        this.storage.addUser(user);
    }
}
