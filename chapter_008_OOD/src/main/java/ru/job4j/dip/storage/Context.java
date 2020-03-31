package ru.job4j.dip.storage;

import lombok.Data;
import ru.job4j.dip.models.Food;

@Data
public class Context {

    private Storage storage;

    public void addFoodToStorage(Food food) {
        storage.addFood(food);
    }

}
