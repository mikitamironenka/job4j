package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CountFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        CountFunction function = new CountFunction();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenQuadroResults() {
        CountFunction function = new CountFunction();
        List<Double> result = function.diapason(2, 5, x -> x * x);
        List<Double> expected = Arrays.asList(4D, 9D, 16D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenLogarithmResults() {
        CountFunction function = new CountFunction();
        List<Double> result = function.diapason(2, 5, x -> Math.log(x));
        List<Double> expected = Arrays.asList(Math.log(2), (Math.log(3)), Math.log(4));
        assertThat(result, is(expected));
    }
}