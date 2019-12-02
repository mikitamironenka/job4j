package ru.job4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "password";
        Connection conn;

        {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(
                        url,
                        username,
                        password);
                System.out.println(conn != null);
                conn.close();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


    }
}
