package ru.job4j.isp.entries;

import lombok.Data;
import ru.job4j.isp.entries.Entry;

@Data
public class SubSubEntry implements Entry {

    private static final String PREFIX = "--------";
    private static final String TASK = "Задача";
    private String number;

    public SubSubEntry(String number) {
        this.number = number;
    }

    @Override
    public void action() {
        System.out.println(String.format("action from %s%s %s", PREFIX, TASK, number));
    }

    @Override
    public void show() {
        System.out.println(String.format("%s %s %s", PREFIX, TASK, number));
    }
}
