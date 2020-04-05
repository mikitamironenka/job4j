package ru.job4j.dip.storage;

import lombok.Getter;
import ru.job4j.dip.models.Food;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Trash extends StorageImpl {

    private static final int PERCENT_100 = 100;
    @Override
    public boolean accept(Food food, int percent) {
        return percent >= 100 ? true : false;
    }
}
