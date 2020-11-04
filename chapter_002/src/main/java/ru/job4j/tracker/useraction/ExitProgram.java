package ru.job4j.tracker.useraction;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;

import java.util.function.Consumer;

public class ExitProgram extends BaseAction {

    private final StartUI ui;


    public ExitProgram(final int key, final String name, StartUI ui) {
        super(key, name);
        this.ui = ui;
    }

    @Override
    public void execute(Input input, Store tracker, Consumer output) {
        this.ui.stop();
    }
}
