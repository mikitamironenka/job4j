package ru.job4j.isp.ui;

import ru.job4j.isp.entries.Entry;
import ru.job4j.isp.menu.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UIClass {

    private Menu menu;
    private boolean isExit;

    public UIClass(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!isExit) {
            menu.showMenu();
            try {
                String line = reader.readLine();
                if (line.toLowerCase().equals("exit")) {
                    isExit = true;
                    break;
                }
                for (Entry entry : menu.getEntries()) {
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
}
