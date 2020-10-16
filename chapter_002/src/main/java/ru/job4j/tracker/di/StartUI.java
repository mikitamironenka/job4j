package ru.job4j.tracker.di;

import org.springframework.stereotype.Component;
import ru.job4j.tracker.input.ConsoleInput;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class StartUI {

    private Store store;
    private ConsoleInput consoleInput;

    public StartUI(Store store, ConsoleInput consoleInput) {
        this.store = store;
        this.consoleInput = consoleInput;
    }

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
