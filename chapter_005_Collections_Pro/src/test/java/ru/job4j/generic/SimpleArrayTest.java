package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenAddElementThenShouldReturnIt() {

        SimpleArray<Integer> arr = new SimpleArray<>(3);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        int result = arr.get(1);
        assertThat(result, is(2));
    }

    @Test
    public void whenRemoveElementThenSizeSmaller() {

        SimpleArray<Integer> arr = new SimpleArray<>(3);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.remove(1);
        assertThat(arr.get(1), is(3));
    }

    @Test
    public void whenSetNewElementThenShouldReturnIt() {

        SimpleArray<Integer> arr = new SimpleArray<>(3);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.set(0, 2);
        assertThat(arr.get(0), is(2));
    }

    @Test
    public void testThatNextReturnsElement() {
        SimpleArray<Integer> arr = new SimpleArray<>(3);
        Iterator it = arr.iterator();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }

}