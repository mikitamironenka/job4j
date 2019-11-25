package ru.job4j.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.jsoupparser.Vacancy;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class DBConnect {

    private static final Logger LOG = LogManager.getLogger(DBConnect.class);

    private Connection conn;

    public DBConnect() {
        init();
    }

    public Connection getConn() {
        return this.conn;
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
            //set autocommit to false
            this.conn.setAutoCommit(false);
        } catch (Exception e) {
            LOG.info(e);
        }
        createTableIfNotExist();
        return this.conn != null;
    }

    private void createTableIfNotExist() {
        try (PreparedStatement pr = this.conn.prepareStatement(
                "CREATE TABLE IF NOT EXISTS vacanciesThree("
                        + "id serial primary key,"
                        + "name varchar(1000),"
                        + "text varchar(5000),"
                        + "link varchar(1000)"
                        + ");")) {
            pr.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public void insert(List<Vacancy> list) {

        final String insert = "INSERT INTO vacanciesThree(name, text, link) VALUES(?, ?, ?);";
        //create batch of sql queries
        try (PreparedStatement ps = this.conn.prepareStatement(insert)) {
            for (int i = 0; i < list.size(); i++) {
                ps.setString(1, list.get(i).getName());
                ps.setString(2, list.get(i).getText());
                ps.setString(3, list.get(i).getLink());
                ps.addBatch();
//                ps.executeUpdate();
            }
            int[] count = ps.executeBatch();
            System.out.println(count);
            this.conn.commit();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Checks is table is empty
     * @return true if empty, false if not
     */
    public boolean isTableEmpty() throws SQLException {
        int result = -1;
        try (PreparedStatement prCheck = this.conn.prepareStatement(
                "SELECT CASE WHEN EXISTS (SELECT * FROM vacanciesThree LIMIT 1) THEN 1 ELSE 0 END;");
                ResultSet rs = prCheck.executeQuery()) {
            if (rs.next()) {
                result = rs.getInt(1);
            }
        }
        return (result == 0) ? true : false;
    }

    public void insertOneVacancy(Vacancy vacancy) {

        final String insert = "INSERT INTO vacanciesThree(name, text, link) VALUES(?, ?, ?);";
        //create batch of sql queries
        try (PreparedStatement ps = this.conn.prepareStatement(insert)) {

            ps.setString(1, vacancy.getName());
            ps.setString(2, vacancy.getText());
            ps.setString(3, vacancy.getLink());
//                ps.addBatch();
            ps.executeUpdate();
//            int[] count = ps.executeBatch();
//            System.out.println(count);
//            this.conn.commit();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

}
