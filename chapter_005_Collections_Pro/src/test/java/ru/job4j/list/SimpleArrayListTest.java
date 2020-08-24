package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayListTest {

    private SimpleList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDeleteFirstElementThenReturnThree() {
        assertThat(list.delete(), is(3));
    }

    @Test
    public void whenDeleteFirstElementThenSizeTwo() {
        list.delete();
        assertThat(list.getSize(), is(2));
    }
}