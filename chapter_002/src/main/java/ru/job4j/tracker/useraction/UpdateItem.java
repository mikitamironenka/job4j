package ru.job4j.tracker.useraction;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;

import java.util.function.Consumer;

public class UpdateItem extends BaseAction {

    public UpdateItem(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, ITracker tracker, Consumer output) {
        String id = input.ask("Enter id of the item to edit");
        if (tracker.findById(id) == null) {
            output.accept("Your entered the wrong id or item doesn't exist");
        } else {
            String name = input.ask("Enter the new name of the item");
            String description = input.ask("Enter the new description of the item");
            Item item = new Item(name, description);
            item.setId(tracker.findById(id).getId());
            boolean result = tracker.replace(id, item);
            if (result) {
                output.accept(String.format("The item %s after editing is %s %s" + System.lineSeparator(), id,
                        tracker.findById(id).getName(),
                        tracker.findById(id).getDesc()));
            } else {
                output.accept("The item wasn't editing");
            }
        }
    }
}
