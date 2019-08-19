package ru.job4j.tracker.useraction;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class ShowAll implements UserAction {

    @Override
    public int key() {
        return Keys.SHOW_ALL.getKey();
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println(item.toString());
        }
    }

    @Override
    public String info() {
        return "Show all created items";
    }

}
