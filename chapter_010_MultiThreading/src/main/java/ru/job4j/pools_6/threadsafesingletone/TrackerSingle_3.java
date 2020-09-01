package ru.job4j.pools_6.threadsafesingletone;

//1. Single checked locking.
//Инициализация и проверка экземпляра происходит внутри критической секции.
// Этот шаблон деградирует производительность.
//Использовать этот шаблон не рекомендуется.

public class TrackerSingle_3 {

    private static TrackerSingle_3 INSTANCE;

    private TrackerSingle_3() {
    }

    public static synchronized TrackerSingle_3 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TrackerSingle_3();
        }
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingle_3 tracker = TrackerSingle_3.getInstance();
    }
}
