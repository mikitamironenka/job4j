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
        assertThat(set.getList().getElements(), is(3));
    }

}