package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTwoTest {

    @Test
    public void whenAddThreeElementsThenSizeThree() {
        SimpleSetTwo<Integer> set = new SimpleSetTwo<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        assertThat(set.getList().getElements(), is(3));
    }

    @Test
    public void whenAddFourElementsThenSizeThree() {
        SimpleSetTwo<Integer> set = new SimpleSetTwo<>();
        set.add(1);
        set.add(null);
        set.add(2);
        set.add(1);
        assertThat(set.getList().getElements(), is(3));
        for (int i = 0; i < set.getList().getElements(); i++) {
            System.out.println(set.getList().get(i));
        }

    }
}