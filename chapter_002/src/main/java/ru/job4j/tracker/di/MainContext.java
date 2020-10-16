package ru.job4j.tracker.di;

import ru.job4j.tracker.input.ConsoleInput;

public class MainContext {

    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(ConsoleInput.class);
        context.reg(StartUI.class);

        StartUI ui = context.get(StartUI.class);

        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();
        ui.ask("1");
    }
}
