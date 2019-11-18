package ru.job4j.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.tracker.model.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//Задача реализовать методы интефейса ITracker.
//Хранить данные и извлекать их нужно из базы данных.
//Предусмотреть возможность, что структуры в базе еще нет. И вам нужно ее создать при старте.
//Все ресурсы необходимо закрывать через try-with-resources
//В классе трекер появляется новое поле private Connection connection.
// Его нужно закрывать через AutoCloseable.


public class TrackerSQL implements ITracker, AutoCloseable {

    private static final Logger Log = LoggerFactory.getLogger(TrackerSQL.class);

    private Connection conn;

    public TrackerSQL() {
        init();
    }

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            Class.forName("org.postgresql.Driver");
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
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
                     this.conn.prepareStatement("create table if not exists items(id serial primary key," +
                             "name varchar(200),description varchar(500),create_time timestamp);" )) {
             prItems.execute();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }


    @Override
    public Item add(Item item) {
        String generatedColumns[] = { "id" };
        try (
                PreparedStatement pr = this.conn.prepareStatement("INSERT INTO " +
                    "items(name, description, create_time) VALUES(?, ?, ?)", generatedColumns) ) {
            pr.setString(1, item.getName());
            pr.setString(2, item.getDesc());
            pr.setTimestamp(3, new java.sql.Timestamp(item.getTime()));
            pr.executeUpdate();
            //returning generated id and set it to item id
            ResultSet rs = pr.getGeneratedKeys();
            if (rs.next()) {
                long id = rs.getLong(1);
                item.setId(String.valueOf(id));
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        try (PreparedStatement pr = this.conn.prepareStatement(
                "UPDATE items SET name = ?, description = ?, create_time = ? WHERE id = ?") ) {
            pr.setString(1, item.getName());
            pr.setString(2, item.getDesc());
            pr.setTimestamp(3, new java.sql.Timestamp(item.getTime()));
            pr.setInt(4, Integer.parseInt(id));
            //returning number of affected rows
            int affectedRows = pr.executeUpdate();
            if (affectedRows == 1) {
                result = true;
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        try (PreparedStatement pr = this.conn.prepareStatement(
                "DELETE FROM items WHERE id = ?")) {
            pr.setInt(1, Integer.parseInt(id));
            int affectedRows = pr.executeUpdate();
            if (affectedRows == 1) {
                result = true;
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement pr = this.conn.prepareStatement("SELECT * FROM items")) {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("id"), rs.getString("name"),
                        rs.getString("description"), rs.getTimestamp("create_time").getTime());
                result.add(item);
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement pr = this.conn.prepareStatement("SELECT * FROM items WHERE name LIKE ?")) {
            pr.setString(1, String.format("%s%s%s", "%", key, "%"));
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("id"), rs.getString("name"),
                        rs.getString("description"), rs.getTimestamp("create_time").getTime());
                result.add(item);
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public Item findById(String id) {
        Item result = null;
        try (PreparedStatement pr = this.conn.prepareStatement("SELECT * FROM items WHERE id = ?") ) {
            pr.setInt(1, Integer.parseInt(id));
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                result = new Item(rs.getString("id"), rs.getString("name"),
                        rs.getString("description"), rs.getTimestamp("create_time").getTime());
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public void close() {
        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
