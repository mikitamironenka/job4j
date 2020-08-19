package ru.job4j.dip.storage;

import lombok.Getter;
import ru.job4j.dip.models.Food;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Warehouse extends StorageImpl {

    private static final int PERCENT_25 = 25;
    @Override
    public boolean accept(Food food, int percent) {
        return percent < PERCENT_25 ? true : false;
    }
}
