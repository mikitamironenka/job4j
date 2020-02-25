package ru.job4j.isp.items;


public class TaskOne extends Item implements Info {

    public TaskOne(int key, String info) {
        super(key, info);
    }

    @Override
    public void info() {
        System.out.println();
    }
}
