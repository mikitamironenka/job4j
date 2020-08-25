package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleStackTest {

    @Test
    public void whenRemoveLastThenReturnLast() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int result = stack.poll();
        assertThat(result, is(3));
    }

    @Test
    public void whenPushPushPollPushReturnThree() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.poll();
        stack.push(3);
        int result = stack.poll();
        assertThat(result, is(3));
    }

}