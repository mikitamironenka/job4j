package ru.job4j.dip.storage;

import ru.job4j.lsp.models.Food;

public interface Store {

    boolean accept(Food food, int percent);
    void add(Food food);
}
