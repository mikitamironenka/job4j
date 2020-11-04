package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.useraction.DeleteItem;
import ru.job4j.tracker.useraction.FindItemById;
import ru.job4j.tracker.useraction.FindItemsByName;
import ru.job4j.tracker.useraction.UpdateItem;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartUITest {

    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private static String LINE_SEPARATOR = System.lineSeparator();

    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);
        @Override
        public void accept(String s) {
            stdout.println(s);
        }

        @Override
        public String toString() {
            return out.toString();
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
//        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
//        new StartUI(input, tracker, output).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
//        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenUpdateItemActionTest() {
        // создаём Tracker
//        Tracker tracker = new Tracker();
//        //Напрямую добавляем заявку
//        Item item = tracker.add(new Item("test name", "desc"));
//
//        String replacedName = "test replace name";
//        String replacedDesc = "test replace desc";
//
//        Input input = mock(Input.class);
//
//        //создаём mock объект с эмуляцией действий по запросу
////        when(input.ask("Enter id of the item to edit")).thenReturn(item.getId());
//        when(input.ask("Enter the new name of the item")).thenReturn(replacedName);
//        when(input.ask("Enter the new description of the item")).thenReturn(replacedDesc);
//
//        // создаём StartUI и вызываем метод init()
//        UpdateItem updateItem = new UpdateItem(2, "Edit item");
//        updateItem.execute(input, tracker, output);

//        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
//        assertThat(tracker.findById(item.getId()).getDesc(), is(replacedDesc));
    }


    @Test
    public void whenDeleteItemThenTrackerHasntTheValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
//        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
//        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().size(), is(0));
    }

    @Test
    public void whenDeleteItemActionTest() {
//        Tracker tracker = new Tracker();
//        Item item = tracker.add(new Item("test name", "desc"));
//        Input input = mock(Input.class);
//        //создаём mock объект с эмуляцией действий по запросу
////        when(input.ask("Enter id of the item to delete")).thenReturn(item.getId());
//
//        DeleteItem deleteItem = new DeleteItem(3, "Delete item");
//        deleteItem.execute(input, tracker, output);
//
//        assertThat(tracker.findAll().size(), is(0));
    }

    @Test
    public void whenShowMenuThenShowMenu() {
//        Tracker tracker = new Tracker();
//        HbnTracker hbnTracker = new HbnTracker();
//        Input input = new StubInput(new String[]{"6"});
//        StartUI startUI = new StartUI(input, tracker, output);
//        startUI.init();
//        assertThat(
////                new String(out.toByteArray()),
//                this.output.toString(),
//                is(
//                        new StringBuilder()
//                                .append(showMenu())
//                                .toString()
//                )
//        );
    }

    @Test
    public void whenFindAllItemThenShowAll() {
//        Tracker tracker = new Tracker();
//        Item item1 = tracker.add(new Item("test name", "desc"));
//        Item item2 = tracker.add(new Item("test name", "desc"));
//        Input input = new StubInput(new String[]{"1", "6"});
//        StartUI startUI = new StartUI(input, tracker, output);
//        startUI.init();
//        assertThat(
////                new String(out.toByteArray()),
//                this.output.toString(),
//                is(
//                        new StringBuilder()
//                                .append(showMenu())
//                                .append("------------ Все созданые заявки --------------" + LINE_SEPARATOR)
//                                .append(item1.toString() + LINE_SEPARATOR)
//                                .append(item2.toString() + LINE_SEPARATOR)
//                                .append(showMenu())
//                                .toString()
//                )
//        );
    }

    @Test
    public void whenFindItemByNameThenShowItems() {
//        Tracker tracker = new Tracker();
//        Item item1 = tracker.add(new Item("test name", "desc"));
//        Item item2 = tracker.add(new Item("test name", "desc"));
//        Input input = new StubInput(new String[]{"5", item1.getName(), "6"});
//        StartUI startUI = new StartUI(input, tracker, output);
//        startUI.init();
//        assertThat(
////                new String(out.toByteArray()),
//                this.output.toString(),
//                is(
//                        new StringBuilder()
//                                .append(showMenu())
//                                .append(item1.toString() + LINE_SEPARATOR)
//                                .append(item2.toString() + LINE_SEPARATOR)
//                                .append(showMenu())
//                                .toString()
//                )
//        );
    }

    @Test
    public void whenFindItemByNameActionTest() {
//        Tracker tracker = new Tracker();
//        String testName = "test name";
//        Item item1 = tracker.add(new Item(testName, "desc"));
//        Item item2 = tracker.add(new Item(testName, "desc"));
//        Input input = mock(Input.class);
//        when(input.ask("Enter name of the item to find")).thenReturn(testName);
//
//        new FindItemsByName(5, "Find items by name").execute(input, tracker, output);
//
//        assertThat(this.output.toString(), is(String.format("%s%s%s%s",item1.toString(), LINE_SEPARATOR, item2.toString(), LINE_SEPARATOR)));

    }

    @Test
    public void whenFindItemByIDThenShowItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name", "desc"));
//        Input input = new StubInput(new String[]{"4", item1.getId(), "6"});

//        StartUI startUI = new StartUI(input, tracker, output);
//        startUI.init();

        assertThat(
//                new String(out.toByteArray()),
                this.output.toString(),
                is(
                        new StringBuilder()
                                .append(showMenu())
                                .append(item1.toString() + LINE_SEPARATOR + LINE_SEPARATOR)
                                .append(showMenu())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindItemByIdActionTest() {
//        Tracker tracker = new Tracker();
//        Item item1 = tracker.add(new Item("test name", "desc"));
//        Item item2 = tracker.add(new Item("test name", "desc"));
//
//        Input input = mock(Input.class);
////        when(input.ask("Enter id of the item to find")).thenReturn(item1.getId());
//        new FindItemById(4, "Find item by Id").execute(input, tracker, output);
//
//        assertThat(this.output.toString(), is(item1.toString() + LINE_SEPARATOR + LINE_SEPARATOR));
    }


    private static String showMenu() {
        return new StringBuilder()
        .append("Menu. Make your choice:" + LINE_SEPARATOR)
        .append("1. Add item" + LINE_SEPARATOR)
        .append("2. Show all items" + LINE_SEPARATOR)
        .append("3. Edit item" + LINE_SEPARATOR)
        .append("4. Delete item" + LINE_SEPARATOR)
        .append("5. Find item by Id" + LINE_SEPARATOR)
        .append("6. Find items by name" + LINE_SEPARATOR)
        .append("7. Exit Program" + LINE_SEPARATOR)
        .toString();
    }

}