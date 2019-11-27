package ru.job4j.lesson;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MemoryStoragy implements Storage {

    private static final Logger LOG = LogManager.getLogger(MemoryStoragy.class);


    @Override
    public void add(User user) {
        System.out.println("memory storage");
    }
}
