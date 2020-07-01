package ru.job4j.lsp.storage;

import lombok.Getter;
import ru.job4j.lsp.CalculateDate;
import ru.job4j.lsp.models.Food;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Warehouse implements Storage {

    private List<Food> foods;

    public Warehouse() {
        this.foods = new ArrayList<>();
    }

    @Override
    public boolean accept(Food food) {
        return CalculateDate.calculatePercentOfDays(food) < 25;
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }
}
