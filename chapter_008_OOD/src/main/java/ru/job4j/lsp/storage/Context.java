package ru.job4j.lsp.storage;

import lombok.Data;
import ru.job4j.lsp.models.Food;

@Data
public class Context {

    private Storage storage;

    public void addFoodToStorage(Food food) {
        storage.addFood(food);
    }

}
