package ru.job4j.dip.storage;

import ru.job4j.dip.models.Food;

public interface Accept {
    public boolean accept(Food food);
}
