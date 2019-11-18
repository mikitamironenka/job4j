package ru.job4j.xmltask.sql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.xmltask.xml.StoreXML;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBReader {

    private static final Logger Log = LogManager.getLogger(DBReader.class.getName());

    private final Connection connection;

    public DBReader(Connection connection) {
        this.connection = connection;
    }

    public List<StoreXML.Field> readDataFromDBToList() {

        List<StoreXML.Field> result = new ArrayList<>();

        final String read = "SELECT * FROM accounts;";

        try (PreparedStatement pr = this.connection.prepareStatement(read)) {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                StoreXML.Field field = new StoreXML.Field(rs.getInt("number"));
                result.add(field);
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return result;
    }
}
