package ru.job4j.tracker.useraction;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
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
        if (!item.equals(null)) {
            System.out.println(item.toString());
        } else {
            System.out.println("The item wasn't fonded");
        }
        System.out.println(tracker.findById(id).toString());
    }

    @Override
    public String info() {
        return (key + 1) + ". " + info;
    }
}
