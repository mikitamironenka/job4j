package ru.job4j.set;

//Реализовать коллекцию SimpleSet. Коллекция должна обеспечивать void add(E e) и реализовывать Iterable<E>.
//Коллекция не должна хранить дубликаты.
//Set - внутри для хранения данных использует обычные массивы.
//Код будет идентичным, как и в SimpleList(Это код из задания реализации списка на массиве).
//как можно за счет композиции сократить количества кода?
//Здесь нужно использовать SimpleList в реализации SimpleSet.

import ru.job4j.list.SimpleList;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SimpleSet<E> implements Iterable {

    /**
     * Default capacity of array
     */
    private static final int INITIAL_CAPACITY = 16;
    /**
     * Array of Nodes.
     */
    private SimpleList.Node<E>[] buckets;
    private int size;
    /**
     * Counter of adding elements.
     */
    private int elements;

    /**
     * Default constructor. Initialize array with default capacity.
     */
    public SimpleSet() {
        this(INITIAL_CAPACITY);
    }

    public SimpleSet(int capacity) {
        this.buckets = new SimpleList.Node[capacity];
        this.size = 0;
    }

    private void increaseCapacity() {
//        E[] newArr = new E[this.buckets.length * 2];
//        System.arraycopy(this.buckets, 0, newArr, 0, this.buckets.length);
//        this.buckets = newArr;
    }

    /**
     * Add elements.
     * Compute index (place) in bucket where to put element.
     * @param e element to add.
     */
    public void add(E e) {
        int index = e.hashCode() % this.buckets.length;
        SimpleList.Node bucket = buckets[index];
        SimpleList.Node<E> newNode = new SimpleList.Node<>(e);
        if (bucket == null) {
            buckets[index] = newNode;
            size++;
        }


    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
    }
}
