package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinkedListContainerTest {

    @Test
    public void whenGetSizeThenShouldReturnSize() {
        LinkedListContainer<Integer> list = new LinkedListContainer<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator it = list.iterator();

        assertThat(list.getSize(), is(3));
        assertThat(list.get(2), is(3));

        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }

}