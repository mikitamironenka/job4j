package ru.job4j.tracker.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.job4j.tracker.input.ConsoleInput;

public class SpringDI {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.job4j.tracker");
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();
        ui.ask("dsfa");
    }
}
