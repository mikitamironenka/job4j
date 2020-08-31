package ru.job4j.pools_6.threadsafesingletone;

public class Item {
    private final int id;
    private final String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
