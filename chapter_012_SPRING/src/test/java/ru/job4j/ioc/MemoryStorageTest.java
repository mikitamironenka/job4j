package ru.job4j.ioc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.lesson.MemoryStoragy;
import ru.job4j.lesson.User;

import static org.junit.Assert.assertNotNull;

public class MemoryStorageTest {

    private static final Logger LOG = LogManager.getLogger(MemoryStorageTest.class);

    @Test
    public void whenAddUserThenShouldReturn() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        MemoryStoragy memory = context.getBean(MemoryStoragy.class);
        assertNotNull(memory);
        memory.add(new User());
    }

}