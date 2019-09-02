package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.model.Item;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);
        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };


    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }


//    @Test
//    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
//        Tracker tracker = new Tracker();     // создаём Tracker
//        Input input = new StubInput(new String[]{"1", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
//        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
//        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
//    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, output).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
//        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteItemThenTrackerHasntTheValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().size(), is(0));
    }

    @Test
    public void whenShowMenuThenShowMenu() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"6"});
        StartUI startUI = new StartUI(input, tracker, output);
        startUI.init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(showMenu())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindAllItemThenShowAll() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"1", "6"});
        StartUI startUI = new StartUI(input, tracker, output);
        startUI.init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(showMenu())
                                .append("------------ Все созданые заявки --------------" + System.lineSeparator())
                                .append(item1.toString() + System.lineSeparator())
                                .append(item2.toString() + System.lineSeparator())
                                .append(showMenu())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindItemByNameThenShowItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", item1.getName(), "6"});
        StartUI startUI = new StartUI(input, tracker, output);
        startUI.init();
        assertThat(
//                new String(out.toByteArray()),
                this.output.toString(),
                is(
                        new StringBuilder()
                                .append(showMenu())
                                .append(item1.toString() + System.lineSeparator())
                                .append(item2.toString() + System.lineSeparator())
                                .append(showMenu())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindItemByIDThenShowItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item1.getId(), "6"});
        StartUI startUI = new StartUI(input, tracker, output);
        startUI.init();
        assertThat(
//                new String(out.toByteArray()),
                this.output.toString(),
                is(
                        new StringBuilder()
                                .append(showMenu())
                                .append(item1.toString() + System.lineSeparator() + System.lineSeparator())
                                .append(showMenu())
                                .toString()
                )
        );
    }

    private static String showMenu() {
        return new StringBuilder()
        .append("Menu. Make your choice:" + System.lineSeparator())
        .append("1. Add item" + System.lineSeparator())
        .append("2. Show all items" + System.lineSeparator())
        .append("3. Edit item" + System.lineSeparator())
        .append("4. Delete item" + System.lineSeparator())
        .append("5. Find item by Id" + System.lineSeparator())
        .append("6. Find items by name" + System.lineSeparator())
        .append("7. Exit Program" + System.lineSeparator())
        .toString();
    }

}