package ru.job4j.lsp.storage;

import lombok.Getter;
import ru.job4j.lsp.models.Food;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Shop implements Storage{

    private List<Food> foods;

    public Shop() {
        this.foods = new ArrayList<>();
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }
}
