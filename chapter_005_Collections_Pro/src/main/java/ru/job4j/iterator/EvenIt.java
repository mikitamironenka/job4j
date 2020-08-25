package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {

    final int[] numbers;
    private int index;

    public EvenIt(final int[] numbers) {
        this.numbers = numbers;
        index = -1;
        fixNext();
    }

    @Override
    public boolean hasNext() {
        return index < numbers.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer next = numbers[index];
        fixNext();
        return next;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /** Increase index to the index of the next element in numbers that
     * is even ---or to numbers.length if there no such elements.
     * Precondition: n < numbers.length */
    private void fixNext() {
        index = index + 1;
        while (index < numbers.length && numbers[index] % 2 == 1) {
            index = index + 1;
        }
    }


}
