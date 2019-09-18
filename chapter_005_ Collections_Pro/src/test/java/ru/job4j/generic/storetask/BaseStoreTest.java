package ru.job4j.generic.storetask;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BaseStoreTest {

    @Test
    public void whenAddThenShouldReturnIt() {

        UserStore store = new UserStore(5);
        User user = new User("1");
        store.add(user);
        assertThat(store.findById(user.getId()), is(user));
    }

    @Test
    public void whenReplaceOneThenReturnTwo() {
        UserStore store = new UserStore(5);
        User one = new User("1");
        User two = new User("2");
        store.add(one);
        store.replace(one.getId(), two);
        assertThat(store.findById(two.getId()), is(two));
    }

    @Test
    public void whenDeleteThenReturnNull() {
        UserStore store = new UserStore(5);
        User one = new User("1");
        User two = new User("2");
        store.add(one);
        store.add(two);
        boolean result = store.delete(one.getId());
        assertThat(result, is(true));
    }


    @Test
    public void getIndexById() {
        UserStore store = new UserStore(5);
        User one = new User("1");
        User two = new User("2");
        store.add(one);
        store.add(two);
        assertThat(store.getIndexById(one.getId()), is(0));
        assertThat(store.getIndexById(two.getId()), is(1));
    }
}