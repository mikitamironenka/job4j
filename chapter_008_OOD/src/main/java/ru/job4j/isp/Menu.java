package ru.job4j.isp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<BaseMenuEntry> entries;
    private boolean isExit;

    private void createMenu() {

        this.entries = new ArrayList<>();
        entries.add(new BaseMenuEntry("Задача", "1"));
        entries.add(new MenuSubEntry("----" ,"Задача", "1.1"));
        entries.add(new MenuSubEntry("--------", "Задача", "1.1.1"));
        entries.add(new MenuSubEntry("--------", "Задача", "1.1.2"));
        entries.add(new MenuSubEntry("----", "Задача", "1.2"));
        entries.add(new BaseMenuEntry("Задача", "2"));
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!isExit) {
            printMenu();
            try {
                String line = reader.readLine();

                if (line.toLowerCase().equals("exit")) {
                    isExit = true;
                    break;
                }
                for (BaseMenuEntry entry : this.entries) {
                    if (entry.getNumber().equals(line)) {
                        entry.action();
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void printMenu() {
        createMenu();
        this.entries.stream()
            .forEach(s -> s.show());
    }
}
