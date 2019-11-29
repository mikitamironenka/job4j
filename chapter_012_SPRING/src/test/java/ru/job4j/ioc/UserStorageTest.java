package ru.job4j.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStorageTest {

    @Test
    public void whenAddThenShouldSaveIt() {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        JdbcStorage jdbcStorage = context.getBean("jdbcStorage", JdbcStorage.class);
        User user = new User("name", "city");
        assertNotNull(jdbcStorage);
        jdbcStorage.addUser(user);
        assertThat(jdbcStorage.getAll().size(), is(1));
    }

}