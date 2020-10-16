package ru.job4j.tracker.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.job4j.tracker.input.ConsoleInput;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class StartUI {

    @Autowired
    private Store store;

    @Autowired
    public void setConsoleInput(ConsoleInput consoleInput) {
        this.consoleInput = consoleInput;
    }

    private ConsoleInput consoleInput;

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }

    public String ask(String s) {
        return consoleInput.ask(s);
    }

    public int ask(String s, List<Integer> range) {
        return consoleInput.ask(s, range);
    }
}
