package ru.job4j.readconfig;

import org.junit.Test;
import ru.job4j.io.Config;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void whenReadPropertiesThenReturnMap() {
        String path = "src/test/resources";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        Config config = new Config(absolutePath + "/app.properties");
        config.load();

        Map<String, String> map = new HashMap<>();
        map.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        map.put("hibernate.connection.url", "jdbc:postgresql://127.0.0.1:5432/trackstudio");
        map.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        map.put("hibernate.connection.username", "postgres");
        map.put("hibernate.connection.password", "password");
        assertThat(config.getValues(), is(map));
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
    }

}