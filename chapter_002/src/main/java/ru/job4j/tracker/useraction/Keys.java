package ru.job4j.tracker.useraction;

public enum Keys {

    ADD(1),
    SHOW_ALL(2),
    EDIT(3),
    DELETE(4),
    FIND_DY_ID(5),
    FIND_BY_NAME(6),
    EXIT(7);

    private final int key;

    private Keys(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
