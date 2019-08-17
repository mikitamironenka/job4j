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

import java.util.Scanner;

public class StartUI {

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    private static final String SHOW_ALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Enter number : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.showAll();                
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void findByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id of the item to find");
        String name = scanner.nextLine();
        System.out.println(this.tracker.findById(name).toString());
    }

    private void findById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id of the item to find");
        String id = scanner.nextLine();
        System.out.println(this.tracker.findById(id).toString());
    }

    private void deleteItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id of the to delete");
        String id = scanner.nextLine();
        this.tracker.delete(id);
    }

    private void editItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id of the item to edit");
        String id = scanner.nextLine();
        System.out.println("Enter the new name of the item");
        String name = scanner.nextLine();
        System.out.println("Enter the new description of the item");
        String description = scanner.nextLine();
        Item item = new Item(name, description);
        item.setId(this.tracker.findById(id).getId());
        this.tracker.replace(id, item);
    }

    private void showAll() {
        System.out.println("------------ Все созданые заявки --------------");
        for (Item item : this.tracker.findAll()) {
            System.out.println(item.toString());
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка : " + item.getId() + "-----------");
    }

    private void showMenu() {
        System.out.println("Menu. Make your choice:");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
