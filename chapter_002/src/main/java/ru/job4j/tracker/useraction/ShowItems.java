package ru.job4j.tracker.useraction;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.Tracker;

public class ShowItems implements UserAction {

    private final int key;
    private final String info;
    public ShowItems(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println(item.toString());
        }
    }

    @Override
    public String info() {
        return (key + 1) + ". " + info;
    }

}
