package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.model.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSQLTest {

    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }

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
                    "jdbc:postgresql://localhost:5432/tracker",
                    config.getProperty(username),
                    config.getProperty(pass)
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(TrackerSQLTest.init()))) {
            tracker.add(new Item("name", "desc"));
            assertThat(tracker.findByName("name").size(), is(1));
        }
    }
}