package ru.job4j.tracker.trackersingle;

import ru.job4j.tracker.model.Item;

public enum TrackerSingleEnum {

    INSTANCE;

    public Item add(Item model) {
        return model;
    }
}
