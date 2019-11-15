package ru.job4j.tracker.useraction;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.input.Input;

import java.util.function.Consumer;

public class DeleteItem extends BaseAction {

    public DeleteItem(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, ITracker tracker, Consumer output) {
        String id = input.ask("Enter id of the item to delete");
        boolean result = tracker.delete(id);
        if (result) {
            output.accept(String.format("The item %s was deleted " + System.lineSeparator(), id));
        } else {
            output.accept(String.format("The item %s wasn't deleted " + System.lineSeparator(), id));
        }
        tracker.delete(id);
    }
}
