package ru.job4j.set;

import ru.job4j.list.ArrayListContainer;

import java.util.Iterator;

public class SimpleSetTwo<E> implements Iterable {

    private ArrayListContainer<E> list;
    private int nullCounter = 0;

    public SimpleSetTwo() {
        this.list = new ArrayListContainer<>();
    }

    public void add(E e) {

        if (!this.list.isContains(e)) {
            this.list.add(e);
        }
//        if (e != null && !this.list.isContains(e)) {
//            this.list.add(e);
//        } else if (e == null && nullCounter == 0) {
//            this.list.add(e);
//            nullCounter++;
//        }
    }

    public ArrayListContainer<E> getList() {
        return list;
    }

    @Override
    public Iterator iterator() {
        return this.list.iterator();
    }
}
