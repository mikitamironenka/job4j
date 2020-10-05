package ru.job4j.controller;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.model.Book;

import java.io.*;
import java.sql.*;
import java.util.*;

public class BookStore {

    private static final Logger LOG = LogManager.getLogger(BookStore.class);

    private final BasicDataSource pool = new BasicDataSource();

    private BookStore() {
        Properties cfg = new Properties();
        try (BufferedReader io = new BufferedReader(
            new FileReader("db.properties")
        )) {
            cfg.load(io);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        try {
            Class.forName(cfg.getProperty("jdbc.driver"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        pool.setDriverClassName(cfg.getProperty("jdbc.driver"));
        pool.setUrl(cfg.getProperty("jdbc.url"));
        pool.setUsername(cfg.getProperty("jdbc.username"));
        pool.setPassword(cfg.getProperty("jdbc.password"));
        pool.setMinIdle(5);
        pool.setMaxIdle(10);
        pool.setMaxOpenPreparedStatements(100);
    }

    private static final class Lazy {
        private static final BookStore INST = new BookStore();
    }

    public static BookStore instOf() {
        return Lazy.INST;
    }

    public Book getBook(int id) throws SQLException, IOException {
        Book book = null;

        String sql = "SELECT * FROM book WHERE id = ?";

        try (Connection connection = pool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                book = new Book();
                String title = result.getString("title");
                String author = result.getString("author");
                Blob blob = result.getBlob("image");

                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);


                inputStream.close();
                outputStream.close();

                book.setTitle(title);
                book.setBase64Image(base64Image);
            }

        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            throw ex;
        }

        return book;
    }
}
