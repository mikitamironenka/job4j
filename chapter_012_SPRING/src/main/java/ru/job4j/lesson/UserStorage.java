package ru.job4j.lesson;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserStorage {

    private static final Logger LOG = LogManager.getLogger(UserStorage.class);

    private final Storage storage;

    @Autowired
    public UserStorage(final Storage storage) {
        this.storage = storage;
    }

    public void add(User user) {
        this.storage.add(user);
    }
}
