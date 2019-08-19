package ru.job4j.tracker.useraction;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

public class DeleteItem implements UserAction{

    private final int key;
    private final String info;
    public DeleteItem(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter id of the item to delete");
        boolean result = tracker.delete(id);
        if (result == true) {
            System.out.format("The item %s was deleted " + System.lineSeparator(), id);
        } else {
            System.out.format("The item %s wasn't deleted " + System.lineSeparator(), id);
        }
        tracker.delete(id);
    }

    @Override
    public String info() {
        return (key + 1) + ". " + info;
    }
}
