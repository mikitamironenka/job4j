package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

//Необходимо создать динамический контейнер с методами:
//1) add(E value);
//2) E get(int index);
//3) реализовать интерфейс Iterable<E>.
//Внутри контейнер должен базироваться на массиве (Object[] container).
// Контейнер должен быть динамическим, т.е. при полном заполнении увеличиваться.
//Итератор должен реализовывать fail-fast поведение, т.е. если с момента создания итератора коллекция
// подверглась структурному изменению, итератор должен кидать ConcurrentModificationException.
//Это достигается через введение счетчика изменений - modCount. Каждая операция, которая структурно
// модифицирует коллекцию должна инкрементировать этот счетчик. В свою очередь итератор запоминает значение
// этого счетчика на момент своего создания (expectedModCount), а затем на каждой итерации сравнивает
// сохраненное значение, с текущим значением поля modCount, если они отличаются, то генерируется исключение.

public class ArrayListContainer<E> implements Iterable<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] container;
    private int elements = 0;
    private int modCount = 0;

    public ArrayListContainer() {
        this.container = new Object[DEFAULT_CAPACITY];
    }

    public void add(E value) {
        if (this.elements == container.length) {
            increaseCapacity();
        }
        this.container[elements++] = value;
    }

    public E get(int index) {
        return (E) this.container[index];
    }

    @Override
    public Iterator iterator() {
        Iterator it = new Iterator() {

            private int expectedModCount = modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {
                return ((container.length > index) && (container[index] != null));
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[index++];
            }
        };
        return it;
    }

    public int getSize() {
        return this.container.length;
    }

    private void increaseCapacity() {
        Object[] newArray = new Object[this.container.length * 2];
        System.arraycopy(this.container, 0, newArray, 0, this.container.length);
        this.container = newArray;
        modCount++;
    }
}
