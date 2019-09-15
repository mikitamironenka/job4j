package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {

    final int[] numbers;
    private int index = 0;

    public EvenIt(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        while(index < numbers.length) {
            int num = numbers[index];
            index++;
            if ((num % 2) == 0) {
                return num;
            } else if (!hasNext()){
                throw new NoSuchElementException();
            }
        }
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
