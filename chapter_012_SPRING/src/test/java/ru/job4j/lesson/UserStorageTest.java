package ru.job4j.lesson;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserStorageTest {

    private static final Logger LOG = LogManager.getLogger(UserStorageTest.class);


    @Test
    public void whenAddUserToStorageShouldSaveIt() {

        MemoryStoragy memory = new MemoryStoragy();
        UserStorage userStorage = new UserStorage(memory);
        userStorage.add(new User());

    }

    @Test
    public void whenLoadContextShouldGetBeans() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage memory = context.getBean(UserStorage.class);
        assertNotNull(memory);
        memory.add(new User());
    }

}