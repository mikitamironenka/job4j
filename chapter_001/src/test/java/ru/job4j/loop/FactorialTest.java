package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FactorialTest {

    public static Factorial factorial = new Factorial();

    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        //напишите здесь тест, проверяющий, что факториал для числа 5 равен 120.

        int excepted = 120;
        int result = factorial.calc(5);

        assertThat(result, is(excepted));
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        //напишите здесь тест, проверяющий, что факториал для числа 0 равен 1.
        int excepted = 1;
        int result = factorial.calc(0);

        assertThat(result, is(excepted));
    }

}