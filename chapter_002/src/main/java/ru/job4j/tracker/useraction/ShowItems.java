package ru.job4j.tracker.useraction;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.Tracker;

public class ShowItems extends BaseAction {

    public ShowItems(int key, String info) {
       super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println(item.toString());
        }
    }
}
