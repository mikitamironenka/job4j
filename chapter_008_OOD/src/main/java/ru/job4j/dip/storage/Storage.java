package ru.job4j.dip.storage;

import ru.job4j.dip.models.Food;

import java.util.List;

public interface Storage {

    void addFood(Food food);
    List<Food> getFood();
}
