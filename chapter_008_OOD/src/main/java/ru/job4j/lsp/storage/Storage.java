package ru.job4j.lsp.storage;

import ru.job4j.lsp.models.Food;

import java.util.ArrayList;
import java.util.List;

//Создать классы хранилище продуктов Warehouse, Shop, Trash.

public interface Storage {

    boolean accept(Food food);

    void addFood(Food food);
}
