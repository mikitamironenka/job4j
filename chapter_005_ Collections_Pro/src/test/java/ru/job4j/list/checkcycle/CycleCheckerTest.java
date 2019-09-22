package ru.job4j.list.checkcycle;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CycleCheckerTest {

    private CycleChecker checker;
    private Node first;
    private Node two;
    private Node three;
    private Node four;

    @Before
    public void init() {
        first = new Node(1);
        two = new Node(2);
        three = new Node(3);
        four = new Node(4);
         checker = new CycleChecker();
    }

    @Test
    public void whenHasntCycle() {
        first.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(null);
        assertThat(checker.hasCycle(first), is(false));
    }

    @Test
    public void whenHasCycle() {
        first.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(first);
        assertThat(checker.hasCycle(first), is(true));
    }

}