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

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name", "desc"));
            assertThat(tracker.findByName("name").size(), is(1));
        }
    }
}