package ru.job4j.isp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseMenuEntry implements Entry {

    private String name;
    private String number;

    @Override
    public void show() {
        System.out.println(String.format("%s %s", name, number));
    }
    @Override
    public void action() {
        System.out.println(String.format("base menu action from %s%s", name, number));
    }
}
