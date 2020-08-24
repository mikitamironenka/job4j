package ru.job4j.commonresourses_2.atomic;

public class Count {

    private int value;

    public void increment() {
        value++;
    }

    public int get() {
        return value;
    }
}
