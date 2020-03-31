package ru.job4j.isp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuSubEntry extends BaseMenuEntry implements Entry {

    private String prefix;
    private String name;
    private String number;

    @Override
    public void show() {
        System.out.println(String.format("%s %s %s",prefix, name, number));
    }

    @Override
    public void action() {
        System.out.println(String.format("Action from %s %s %s",prefix, name, number));
    }
}
