package ru.job4j.dip.storage;

import ru.job4j.dip.models.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class StorageImpl implements Storage {

    private List<Food> foods;

    public StorageImpl() {
        this.foods = new ArrayList<>();
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    @Override
    public List<Food> getFood() {
        return this.foods;
    }
}
