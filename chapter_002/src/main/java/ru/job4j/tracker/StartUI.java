package ru.job4j.tracker;

//1. Реализовать класс StartUI и ConsoleInput;
//2. Класс StartUI точка входа в программу, т.е. должен иметь метод main.
// Класс должен обеспечить полноценную работу всего приложения (трекера);
//3. Класс ConsoleInput используется для ввода пользовательских данных из консоли;
//4. Пользователь может выйти из приложения и выполнять все действия описанные в "Общей задаче на второй модуль".
//5. Пользователю должно отображаться меню:
//6. Должен быть реализован диалог с пользователем.
//Пример:
//При запуске класса StartUI пользователю отображается следующее меню:
//0. Add new Item
//1. Show all items
//2. Edit item
//3. Delete item
//4. Find item by Id
//5. Find items by name
//6. Exit Program
//Select:
//При выборе пункта меню 0, программа должна запросить: имя и описание заявки,
// после этого добавить эту заявку в хранилище объект Tracker.
//При выборе пункта меню 4, программа должна запросить у пользователя id заявки,
// после этого отобразить найденную заявку на экране.

import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    private final Consumer<String> output;

    /**
     * Хранилище заявок.
     */
//    private final ITracker tracker;

    private final HbnTracker hbnTracker;

    private boolean working = true;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param output
//     * @param tracker хранилище заявок.
     */
//    public StartUI(Input input, ITracker tracker, Consumer<String> output) {
//        this.input = input;
//        this.tracker = tracker;
//        this.output = output;
//    }

    public StartUI(Input input, HbnTracker hbnTracker, Consumer<String> output) {
        this.input = input;
        this.hbnTracker = hbnTracker;
        this.output = output;
    }

    public void stop() {
        this.working = false;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.hbnTracker, this.output);
        List<Integer> ranges = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i < menu.getActionsLength(); i++) {
            ranges.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("select:", ranges));
        } while (working);
    }


    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
//        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
        new StartUI(new ValidateInput(new ConsoleInput()), new HbnTracker(), System.out::println).init();
    }
}
