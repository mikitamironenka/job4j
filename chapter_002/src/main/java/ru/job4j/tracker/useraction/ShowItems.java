package ru.job4j.tracker.useraction;

import ru.job4j.tracker.HbnTracker;
import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;

import java.util.function.Consumer;

public class ShowItems extends BaseAction {

    public ShowItems(int key, String info) {
       super(key, info);
    }

    @Override
    public void execute(Input input, Store tracker, Consumer output) {
        System.out.println("------------ Все созданые заявки --------------");
        for (Item item : tracker.findAll()) {
//            System.out.println(item.toString());
            output.accept(item.toString());
        }
    }
}
