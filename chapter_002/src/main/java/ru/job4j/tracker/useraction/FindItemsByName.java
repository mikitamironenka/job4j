package ru.job4j.tracker.useraction;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.Tracker;

public class FindItemsByName implements UserAction{

    private final int key;
    private final String info;
    public FindItemsByName(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Enter name of the item to find");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("Items not found");
        }
    }

    @Override
    public String info() {
        return (key + 1) + ". " + info;
    }
}
