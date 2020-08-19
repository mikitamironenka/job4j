package ru.job4j.isp.entries;

import lombok.Data;

@Data
public class MainEntry implements Entry {

    private static final String PREFIX = "";
    private static final String TASK = "Задача";
    private String number;

    public MainEntry(String number) {
        this.number = number;
    }

    @Override
    public void action() {
        System.out.println(String.format("action from %s%s %s", PREFIX, TASK, number));
    }

    @Override
    public void show() {
        System.out.println(String.format("%s%s %s", PREFIX, TASK, number));
    }
}
