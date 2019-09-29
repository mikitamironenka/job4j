package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenAddElementThenShouldReturnTrue() {

        SimpleMap<Integer, Integer> myMap = new SimpleMap<>();
        myMap.insert(1, 1);
        myMap.insert(2, 2);
        boolean resultAddExistingKey = myMap.insert(2, 4);
        boolean resultAdd = myMap.insert(3, 3);

        assertThat(resultAdd, is(true));
        assertThat(resultAddExistingKey, is(false));
        assertThat(myMap.getSize(), is(3));
    }

    @Test
    public void whenDeleteElementThenShouldReturnTrue() {

        SimpleMap<Integer, Integer> myMap = new SimpleMap<>();
        myMap.insert(1, 1);
        myMap.insert(2, 2);
        myMap.insert(3, 3);

        boolean resultDelete = myMap.delete(2);

        assertThat(resultDelete, is(true));
        assertThat(myMap.getSize(), is(2));
    }

    @Test
    public void whenIterateElementThenShouldReturnNext() {

        SimpleMap<Integer, Integer> myMap = new SimpleMap<>();
        myMap.insert(1, 1);
        myMap.insert(2, 2);
        myMap.insert(3, 3);

        Iterator it = myMap.iterator();

        boolean hasNextFirst = it.hasNext();
        Entry<Integer, Integer> valueOne = (Entry<Integer, Integer>) it.next();
        Entry<Integer, Integer> valueTwo = (Entry<Integer, Integer>) it.next();
        it.next();
        boolean hasNextLast = it.hasNext();

        assertThat(hasNextFirst, is(true));
        assertThat(valueOne.getValue(), is(1));
        assertThat(valueTwo.getValue(), is(2));
        assertThat(hasNextLast, is(false));
    }

}