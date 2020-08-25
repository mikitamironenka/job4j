package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenIterate() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);

        Iterator it = tree.iterator();
        assertThat(((Node<Integer>) it.next()).getValue(), is(1));
        assertThat(((Node<Integer>) it.next()).getValue(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(((Node<Integer>) it.next()).getValue(), is(3));
        assertThat(((Node<Integer>) it.next()).getValue(), is(4));
        assertThat(((Node<Integer>) it.next()).getValue(), is(5));
        assertThat(((Node<Integer>) it.next()).getValue(), is(6));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenIsBinary() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 5);
        assertThat(
                tree.isBinary(),
                is(true)
        );
    }

    @Test
    public void whenIsNotBinary() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        assertThat(
                tree.isBinary(),
                is(false)
        );
    }
}