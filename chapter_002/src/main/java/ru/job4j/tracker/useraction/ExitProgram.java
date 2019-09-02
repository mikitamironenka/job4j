package ru.job4j.tracker.useraction;

import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

public class ExitProgram extends BaseAction {

    private final StartUI ui;


    public ExitProgram(final int key, final String name, StartUI ui) {
        super(key, name);
        this.ui = ui;
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer output) {
        this.ui.stop();
    }
}
