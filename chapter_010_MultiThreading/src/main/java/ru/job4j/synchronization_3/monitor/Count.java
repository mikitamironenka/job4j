package ru.job4j.synchronization_3.monitor;

public class Count {

    private int value;

    public void increment() {
        synchronized (this) {
            value++;
        }
    }

    public int get() {
        synchronized (this) {
            return value;
        }
    }
}
