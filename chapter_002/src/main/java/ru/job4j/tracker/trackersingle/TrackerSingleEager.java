package ru.job4j.tracker.trackersingle;

import ru.job4j.tracker.model.Item;

public class TrackerSingleEager {

    private static final TrackerSingleEager INSTANCE = new TrackerSingleEager();

    private TrackerSingleEager() {
    }

    public static TrackerSingleEager getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

}
