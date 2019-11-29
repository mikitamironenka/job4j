package ru.job4j.ioc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcStorage implements Storage {

    private static final Logger LOG = LogManager.getLogger(JdbcStorage.class);
    private final static String ADD_USER = "INSERT INTO users(name, city) VALUES(?, ?)";
    private final static String GET_USERS = "SELECT * FROM users";
//    private Connection conn;

    private final JdbcTemplate storage;

//    public JdbcStorage() {
//        init();
//    }

    public JdbcStorage(JdbcTemplate jdbcTemplate) {
        this.storage = jdbcTemplate;
    }

//    public boolean init() {
//        try (InputStream in = JdbcStorage.class.getClassLoader().getResourceAsStream("db.properties")) {
//            Properties properties = new Properties();
//            properties.load(in);
//            Class.forName(properties.getProperty("jdbc.driver"));
//            String url = properties.getProperty("jdbc.url");
//            String username = properties.getProperty("jdbc.username");
//            String password = properties.getProperty("jdbc.password");
//            System.out.println(url + " " + username);
//            this.conn = DriverManager.getConnection(
//                    url,
//                    username,
//                    password
//            );
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        }
//        createTableIfNotExist();
//        return this.conn != null;
//    }

//    private void createTableIfNotExist() {
//        try (PreparedStatement prItems =
//                     this.conn.prepareStatement("CREATE TABLE IF NOT EXISTS users(id serial primary key,"
//                             + "name varchar(200), city varchar(500))")) {
//            prItems.execute();
//        } catch (SQLException e) {
//            LOG.error(e.getMessage(), e);
//        }
//    }


//    @Override
//    public void addUser(User user) {
//        try (PreparedStatement pr = this.conn.prepareStatement("INSERT INTO "
//                + "users(name, city) VALUES(?, ?)")) {
//            pr.setString(1, user.getName());
//            pr.setString(2, user.getCity());
//            pr.executeUpdate();
//            //returning generated id and set it to item id
//            ResultSet rs = pr.getGeneratedKeys();
//            if (rs.next()) {
//                long id = rs.getLong(1);
//                user.setId((int) id);
//            }
//        } catch (SQLException e) {
//            LOG.error(e.getMessage(), e);
//        }
//    }


//    @Override
//    public List<User> getAll() {
//        List<User> result = new ArrayList<>();
//        try (PreparedStatement pr = this.conn.prepareStatement("SELECT * FROM users")) {
//            ResultSet rs = pr.executeQuery();
//            while (rs.next()) {
//                User user = new User(rs.getInt("id"), rs.getString("name"),
//                        rs.getString("city"));
//                result.add(user);
//            }
//        } catch (SQLException e) {
//            LOG.error(e.getMessage(), e);
//        }
//        return result;
//    }

    @Override
    public void addUser(User user) {
        final int update = this.storage.update(ADD_USER, user.getName(), user.getCity());
    }

    @Override
    public List<User> getAll() {
        return storage.query(GET_USERS, new UserMapper());
    }

    public JdbcTemplate getStorage() {
        return storage;
    }
}
