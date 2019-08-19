package ru.job4j.tracker.useraction;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

public class EditItem implements UserAction {

    @Override
    public int key() {
        return Keys.EDIT.getKey();
    }

    @Override
    public void execute(Input input, Tracker tracker) {

    }

    @Override
    public String info() {
        return null;
    }
}
