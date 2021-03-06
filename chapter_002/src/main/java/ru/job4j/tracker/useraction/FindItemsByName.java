package ru.job4j.tracker.useraction;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;

import java.util.List;
import java.util.function.Consumer;

public class FindItemsByName extends BaseAction {

    public FindItemsByName(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Store tracker, Consumer output) {
        String name = input.ask("Enter name of the item to find");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
//                System.out.println(item.toString());
                output.accept(item.toString());
            }
        } else {
//            System.out.println("Items not found");
            output.accept("Items not found");
        }
    }
}
