package ru.job4j.tracker.useraction;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.Tracker;

public class FindItemById implements UserAction {
    private final int key;
    private final String info;
    public FindItemById(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter id of the item to find");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.format("You look for : %s %s", System.lineSeparator(), item.toString());
        } else {
            System.out.println("The item wasn't fonded");
        }
    }

    @Override
    public String info() {
        return (key + 1) + ". " + info;
    }
}
