package ru.job4j.set;

import ru.job4j.list.ArrayListContainer;

import java.util.Iterator;

public class SimpleSetTwo<E> implements Iterable {

    private ArrayListContainer<E> list;

    public SimpleSetTwo() {
        this.list = new ArrayListContainer<>();
    }

    public void add(E e) {
        if (!this.list.isContains(e)) {
            this.list.add(e);
        }
    }

    public ArrayListContainer<E> getList() {
        return list;
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }
}
