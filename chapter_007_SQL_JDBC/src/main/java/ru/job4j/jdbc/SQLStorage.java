package ru.job4j.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class SQLStorage {

    private static final Logger LOG = LoggerFactory.getLogger(SQLStorage.class);

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/car_catalog";
        String userName = "postgres";
        String password = "password";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, userName, password);
            PreparedStatement st = conn.prepareStatement("insert into car(name, carbody_id, engine_id, transmission_id) values (?, ?, ? ,?)");
            st.setString(1, "бмв");
            st.setInt(2, 4);
            st.setInt(3, 2);
            st.setInt(4, 3);
            ResultSet rs = st.executeQuery();
//            while (rs.next())
//            {
//                System.out.println(String.format("%s %s %s %s", rs.getString("name"), rs.getInt("carbody_id"),
//                        rs.getInt("engine_id"), rs.getInt("transmission_id")));
//            } rs.close();
//            st.close();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
    }

    }

}
