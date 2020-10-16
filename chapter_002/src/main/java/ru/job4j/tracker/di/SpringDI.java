package ru.job4j.tracker.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.job4j.tracker.input.ConsoleInput;

public class SpringDI {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.job4j.tracker");
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        Store store = context.getBean(Store.class);
        store.add("Petr Arsentev");
        Store another = context.getBean(Store.class);
        another.getAll().forEach(System.out::println);
    }
}
