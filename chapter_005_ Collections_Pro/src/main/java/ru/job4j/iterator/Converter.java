package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            private Iterator<Integer> currentIterator = it != null && it.hasNext() ? it.next() : null;

            @Override
            public boolean hasNext() {
                selectCurrentIterator();
                return currentIterator != null;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return this.currentIterator.next();
            }

            private void selectCurrentIterator() {
                    if (this.currentIterator != null && !this.currentIterator.hasNext()) {
                        this.currentIterator = it.hasNext() ? it.next() : null;
                    }
                if (this.currentIterator != null && !this.currentIterator.hasNext()) {
                    this.currentIterator = it.hasNext() ? it.next() : null;
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
