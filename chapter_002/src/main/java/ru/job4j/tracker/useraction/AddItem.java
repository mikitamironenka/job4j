package ru.job4j.tracker.useraction;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

public class AddItem extends BaseAction {

    public AddItem(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer output) {
        output.accept("------------ Adding new item --------------");
        String name = input.ask("Please, provide item name:");
        String desc = input.ask("Please, provide item description:");
        Item item = new Item(name, desc);
        tracker.add(item);
        output.accept("------------ New Item with Id : " + item.getId());
        output.accept("------------ New Item with Name : " + item.getName());
        output.accept("------------ New Item with Description : " + item.getDesc());
    }
}
