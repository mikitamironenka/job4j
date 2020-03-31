package ru.job4j.lsp.storage;

import lombok.Getter;
import ru.job4j.lsp.CalculateDate;
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
    public boolean accept(Food food) {
        boolean result = false;
        int percentOfExpiration = CalculateDate.calculatePercentOfDays(food);
        if (25 < percentOfExpiration && percentOfExpiration < 75) {
            result = true;
        } else if (percentOfExpiration > 75 && percentOfExpiration < 100) {
            result = true;
            food.setDiscount(30);
        }
        return  result;
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }
}
