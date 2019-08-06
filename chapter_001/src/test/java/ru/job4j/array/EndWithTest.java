package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EndWithTest {

    @Test
    public void whenEndsWithSuffixThenTrue() {
        EndsWith word = new EndsWith();
        boolean result = word.endsWith("Hello", "ello");
        assertThat(result, is(true));
    }

    @Test
    public void whenNotEndsWithSuffixThenFalse() {
        EndsWith word = new EndsWith();
        boolean result = word.endsWith("Hello", "la");
        assertThat(result, is(false));
    }

}