package ru.job4j.tracker.useraction;

import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Tracker;

public class ExitProgram extends BaseAction {

    private final StartUI ui;


    public ExitProgram(final int key, final String name, StartUI ui) {
        super(key, name);
        this.ui = ui;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("You chose exit. Good buy");
        this.ui.stop();
    }
}
