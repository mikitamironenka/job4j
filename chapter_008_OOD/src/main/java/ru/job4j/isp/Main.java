package ru.job4j.isp;

import ru.job4j.isp.menu.Menu;
import ru.job4j.isp.menu.MenuCreator;
import ru.job4j.isp.ui.UIClass;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        MenuCreator menuCreator = new MenuCreator(menu);
        menuCreator.createMenu();
        UIClass uiClass = new UIClass(menu);
        uiClass.run();
    }
}
