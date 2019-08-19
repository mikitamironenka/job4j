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
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(Integer.valueOf(input.ask("select:")));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    private void findByName() {
        String name = this.input.ask("Enter name of the item to find");
        Item[] items = this.tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("Items not found");
        }
    }

    private void findById() {
        String id = this.input.ask("Enter id of the item to find");
        Item item = this.tracker.findById(id);
        if (!item.equals(null)) {
            System.out.println(item.toString());
        } else {
            System.out.println("The item wasn't fonded");
        }
        System.out.println(this.tracker.findById(id).toString());
    }

    private void deleteItem() {
        String id = this.input.ask("Enter id of the item to delete");
        boolean result = this.tracker.delete(id);
        if (result == true) {
            System.out.format("The item %s was deleted " + System.lineSeparator(), id);
        } else {
            System.out.format("The item %s wasn't deleted " + System.lineSeparator(), id);
        }
        this.tracker.delete(id);
    }

    private void editItem() {
        String id = this.input.ask("Enter id of the item to edit");
        String name = this.input.ask("Enter the new name of the item");
        String description = this.input.ask("Enter the new description of the item");
        Item item = new Item(name, description);
        item.setId(this.tracker.findById(id).getId());
        boolean result = this.tracker.replace(id, item);
        if (result == true) {
            System.out.format("The item %s after editing is %s %s" + System.lineSeparator(), id,
                    this.tracker.findById(id).getName(),
                    this.tracker.findById(id).getDesc());
        } else {
            System.out.println("The item wasn't editing");
        }
    }

    private void showAll() {
        System.out.println("------------ Все созданые заявки --------------");
        for (Item item : this.tracker.findAll()) {
            System.out.println(item.toString());
        }
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.format("------------ Новая заявка : %s-----------", item.getId());
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
