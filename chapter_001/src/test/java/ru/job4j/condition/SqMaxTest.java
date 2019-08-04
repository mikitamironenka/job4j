package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqMaxTest {

    @Test
    public void whenMaxFirst() {


        int result = SqMax.max(4, 3, 2, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenMaxSecond() {

        int result = SqMax.max(3, 4, 2, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenMaxThird() {

        int result = SqMax.max(3, 4, 7, 2);
        assertThat(result, is(7));
    }

    @Test
    public void whenMaxFourth() {

        int result = SqMax.max(4, 3, 2, 7);
        assertThat(result, is(7));
    }
}