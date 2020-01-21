package ru.job4j.lsp.storage;

import lombok.Getter;
import ru.job4j.lsp.CalculateDate;
import ru.job4j.lsp.models.Food;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Trash implements Storage {

    private List<Food> foods;

    public Trash() {
        this.foods = new ArrayList<>();
    }

    @Override
    public boolean accept(Food food) {
        return CalculateDate.calculatePercentOfDays(food) >= 100;
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

}
