package ru.job4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.jsoupparser.Vacancy;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class DBConnect {

    private static final Logger LOG = LogManager.getLogger(DBConnect.class);

    private Connection conn;

    public DBConnect() {
        init();
    }

    public boolean init() {
        try (InputStream in = DBConnect.class.getClassLoader().getResourceAsStream("app.properties")) {
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
            LOG.info(e);
        }
        createTableIfNotExist();
        return this.conn != null;
    }

    private void createTableIfNotExist() {
        try (PreparedStatement pr = this.conn.prepareStatement(
                "CREATE TABLE IF NOT EXISTS vacancies("
                        + "id serial primary key,"
                        + "name varchar(200),"
                        + "text varchar(500),"
                        + "link varchar(500)"
                        + ");")) {
            pr.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public void insert(List<Vacancy> list) {

        final String insert = "INSERT INTO vacancies (name, text, link) VALUES(?, ?, ?);";
        //create batch of sql queries
        try (PreparedStatement ps = this.conn.prepareStatement(insert)) {
            for (int i = 0; i < list.size(); i++) {
                ps.setString(1, list.get(i).getText());
                ps.setString(1, list.get(i).getText());
                ps.setString(1, list.get(i).getLink());
                ps.addBatch();
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }


}
