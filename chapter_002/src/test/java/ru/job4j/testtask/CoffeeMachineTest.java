package ru.job4j.testtask;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CoffeeMachineTest {

    @Test
    public void whenChangesTenFive() {
        int[] result = CoffeeMachine.changes(50, 35);
        int[] checked = new int[]{10, 5};
        assertThat(result, is(checked));
    }

    @Test
    public void whenChangesTenTen() {
        int[] result = CoffeeMachine.changes(50, 30);
        int[] checked = new int[]{10, 10};
        assertThat(result, is(checked));
    }

    @Test
    public void whenChangesTenTenFiveTwoOne() {
        int[] result = CoffeeMachine.changes(50, 22);
        int[] checked = new int[]{10, 10, 5, 2, 1};
        assertThat(result, is(checked));
    }
}