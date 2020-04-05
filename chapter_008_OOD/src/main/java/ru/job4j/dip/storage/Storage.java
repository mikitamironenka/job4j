package ru.job4j.dip.storage;

import ru.job4j.dip.models.Food;

import java.util.List;

public interface Storage {

    boolean accept(Food food, int percent);
    void addFood(Food food);
    List<Food> getFood();
}
