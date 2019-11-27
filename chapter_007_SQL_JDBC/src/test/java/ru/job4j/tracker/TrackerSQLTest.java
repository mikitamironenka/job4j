package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.model.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSQLTest {

//    @Test
//    public void checkConnection() {
//        TrackerSQL sql = new TrackerSQL();
//        assertThat(sql.init(), is(true));
//    }

    public static Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties config = new Properties();
            config.load(in);
            String driver = config.getProperty("driver-class-name");
            String url = config.getProperty("url");
            String username = config.getProperty("username");
            String pass = config.getProperty("password");
            System.out.println(driver + " " + url + " " + username + " " + pass);
            Class.forName(driver);
            return DriverManager.getConnection(
                    url,
                    username,
                    pass
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenCreateItem() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(TrackerSQLTest.init()))) {

            Item item = tracker.add(new Item("name", "desc"));
            assertThat(tracker.findById(item.getId()), is(item));
        }
    }

    @Test
    public void whenDeleteItem() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(TrackerSQLTest.init()))) {

            Item item1 = tracker.add(new Item("name1", "desc"));
            Item item2 = tracker.add(new Item("name2", "desc"));
            boolean result  = tracker.delete(item1.getId());
            assertThat(result, is(true));
        }
    }



    @Test
    public void whenFindAll() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(TrackerSQLTest.init()))) {

            Item item = tracker.add(new Item("name1", "desc"));
            Item item2 = tracker.add(new Item("name2", "desc"));
            Item item3 = tracker.add(new Item("name3", "desc"));

            List<Item> checked = List.of(item, item2, item3);
            List<Item> result = tracker.findAll();
            System.out.println(result);
            assertThat(result, is(checked));
        }
    }

}