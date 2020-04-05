package ru.job4j.dip.storage;

import lombok.Getter;
import ru.job4j.dip.models.Food;

@Getter
public class Shop extends StorageImpl{

    private static final int PERCENT_25 = 25;
    private static final int PERCENT_75 = 75;
    private static final int PERCENT_100 = 100;
    private static final int DISCOUNT_30 = 30;

    @Override
    public boolean accept(Food food, int percentOfExpiration) {
        boolean result = false;
        if (PERCENT_25 < percentOfExpiration && percentOfExpiration < PERCENT_75) {
            result = true;
        } else if (percentOfExpiration > PERCENT_75 && percentOfExpiration < PERCENT_100) {
            result = true;
            food.setDiscount(DISCOUNT_30);
        }
        return result;
    }
}
