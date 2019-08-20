package ru.job4j.tracker.useraction;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Tracker;

public class ExitProgram extends BaseAction {

    public ExitProgram(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.exit(1);
    }
}
