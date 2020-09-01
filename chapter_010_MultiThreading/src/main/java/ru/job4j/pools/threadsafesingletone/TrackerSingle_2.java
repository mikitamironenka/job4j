package ru.job4j.pools.threadsafesingletone;

//с помощью поля final.

public class TrackerSingle_2 {

    private static final TrackerSingle_2 INSTANCE = new TrackerSingle_2();

    private TrackerSingle_2() {
    }

    public static TrackerSingle_2 getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingle_2 tracker = TrackerSingle_2.getInstance();
    }
}
