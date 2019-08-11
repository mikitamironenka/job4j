package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax2To1Then1() {
        Max max = new Max();
        int result = max.max(2, 1);
        assertThat(result, is(2));
    }

    @Test
    public void whenNumbersEqual() {
        Max max = new Max();
        int result = max.max(2, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax3To2To1Then3() {
        Max max = new Max();
        int result = max.maxFromThree(1, 3, 2);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax3To3To1Then3() {
        Max max = new Max();
        int result = max.maxFromThree(3, 3, 2);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax4To3To2Then1() {
        Max max = new Max();
        int result = max.maxFromFour(4, 3, 3, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenMax4then4() {
        Max max = new Max();
        int result = max.maxFromFour(4, 4, 4, 4);
        assertThat(result, is(4));
    }

}