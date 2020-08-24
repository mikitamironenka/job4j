package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArrayListContainerTest {

    private ArrayListContainer<Integer> list;

    @Before
    public void beforeTest() {
        list = new ArrayListContainer<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenGetOneThenReturnTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenIteratorNextReturnElement() {
        Iterator it = list.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }


}