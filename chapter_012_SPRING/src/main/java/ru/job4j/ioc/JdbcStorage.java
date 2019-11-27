package ru.job4j.ioc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

@Component
public class JdbcStorage implements Storage {

    private static final Logger LOG = LogManager.getLogger(JdbcStorage.class);

    private Connection conn;

    public JdbcStorage() {
        init();
    }

    public boolean init() {
        try (InputStream in = JdbcStorage.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            Class.forName(properties.getProperty("jdbc.driver"));
            String url = properties.getProperty("jdbc.url");
            String username = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");
            this.conn = DriverManager.getConnection(
                    url,
                    username,
                    password
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        createTableIfNotExist();
        return this.conn != null;
    }

    private void createTableIfNotExist() {
        try (PreparedStatement prItems =
                     this.conn.prepareStatement("CREATE TABLE IF NOT EXISTS items(id serial primary key,"
                             + "name varchar(200), description varchar(500), create_time timestamp);")) {
            prItems.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }


    @Override
    public void addUser(User user) {
        System.out.println("store to db");
    }
}
