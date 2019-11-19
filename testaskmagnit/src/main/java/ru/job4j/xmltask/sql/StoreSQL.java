package ru.job4j.xmltask.sql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.xmltask.xml.StoreXML;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StoreSQL implements AutoCloseable {

    private final Config config;
    private final String url;
    private final String dbname;
    private Savepoint savepointOne;
    private Connection connect;

    private static final String CREATE_TABLE_IF_NOT_EXIST =
            "CREATE TABLE IF NOT EXISTS accounts (id integer PRIMARY KEY, number integer);";
    private static final String SELECT_FROM_ACCOUNTS = "SELECT * FROM accounts;";

    private static final Logger LOG = LogManager.getLogger(StoreSQL.class.getName());

    public StoreSQL(Config config) {
        this.config = config;
        this.url = this.config.get("url");
        this.dbname = new File(this.config.get("dbname")).getAbsolutePath();
        this.init();
    }

    public Connection getConnect() {
        return this.connect;
    }

    public Config getConfig() {
        return this.config;
    }

    private boolean init() {

        try {
            createNewDatabase(this.url + this.dbname);
            this.connect = DriverManager.getConnection(this.url + this.dbname);
            //set autocommit to false
            this.connect.setAutoCommit(false);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
//        createNewDatabase(this.dbname);
        createTableIfNotExist();
        return this.connect != null;
    }

    public void generate(int size) {

        final String insert = "INSERT INTO accounts (number) VALUES(?);";
        final String delete = "DELETE FROM accounts;";
        try (PreparedStatement psDelete = this.connect.prepareStatement(delete) ) {
            psDelete.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }

//        for (int i = 0; i < size; i++) {
//            try (PreparedStatement ps = this.connect.prepareStatement(insert);) {
//                ps.setInt(1, i);
////                ps.executeUpdate();
//                ps.addBatch();
//            } catch (SQLException e) {
//                LOG.error(e.getMessage(), e);
//            }
//        }

        //create batch of sql queries
        try (PreparedStatement ps = this.connect.prepareStatement(insert)) {
            for (int i = 0; i < size; i++) {
                ps.setInt(1, i);
                ps.addBatch();
            }
            int[] count = ps.executeBatch();
            System.out.println("count of qsl queries is " + count.length);
            this.connect.commit();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }

        // create savepoint
        try {
            savepointOne = this.connect.setSavepoint("SavepointOne");
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public List<Entry> load() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public void close() throws Exception {
        if (this.connect != null) {
            this.connect.close();
        }
    }

    /**
     * Connect to a sample database
     *
     * @param dbName the database file name
     */
    public void createNewDatabase(String dbName) {

        File file = new File(dbName);
        //check is db already exist
        if (file.exists()) {
            System.out.print("This database name already exists");
        } else {
            DatabaseMetaData meta = null;
            try {
                this.connect = DriverManager.getConnection(dbName);
                meta = this.connect.getMetaData();
                meta.getDriverName();
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
            System.out.println("A new database has been created.");
        }
    }

    private void createTableIfNotExist() {

        try (Statement stmt = this.connect.createStatement()) {
            // create a new table
            stmt.execute(CREATE_TABLE_IF_NOT_EXIST);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }


    public List<StoreXML.Field> readDataFromDBToList() {

        List<StoreXML.Field> result = new ArrayList<>();
        try (PreparedStatement pr = this.connect.prepareStatement(SELECT_FROM_ACCOUNTS)) {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                StoreXML.Field field = new StoreXML.Field(rs.getInt("number"));
                result.add(field);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    public void insert(int value) throws SQLException {
        String insertOne = "INSERT INTO accounts (number) VALUES(?);";
        try (PreparedStatement ps = this.connect.prepareStatement(insertOne);) {
            ps.setInt(1, value);
            ps.executeUpdate();
            //create commit after changing of db
            this.connect.commit();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
            //make rollback to savePoint after exception
            this.connect.rollback(savepointOne);
        }
    }
}
