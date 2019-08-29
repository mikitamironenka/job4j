package ru.job4j.tracker.useraction;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.Tracker;

public class FindItemById extends BaseAction {

    public FindItemById(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter id of the item to find");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.format("%s%s", item.toString(), System.lineSeparator());
        } else {
            System.out.println("The item wasn't fonded");
        }
    }
}
