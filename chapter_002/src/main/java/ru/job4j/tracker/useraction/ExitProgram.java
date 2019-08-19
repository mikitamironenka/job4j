package ru.job4j.tracker.useraction;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Tracker;

public class ExitProgram implements UserAction {

    private final int key;
    private final String info;
    public ExitProgram(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {


    }

    @Override
    public String info() {
        return (key + 1) + ". " + info;
    }
}
