package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

//Необходимо создать динамический контейнер с методами:
//1) add(E value);
//2) E get(int index);
//3) реализовать интерфейс Iterable<E>.
// Внутри контейнер должен базироваться на связанном списке(Node<E> node). Использовать стандартные
// коллекции JDK (ArrayList, LinkedList и т.д.) запрещено. Контейнер должен быть динамическим, т.е.
// увеличиваться по мере добавления элементов.

public class LinkedListContainer<E> implements Iterable<E> {

    private Node<E> first;
    private Node<E> last;
    private Node<E> current;
    private int size = 0;
    private int modCount = 0;

    public LinkedListContainer() {
        first = null;
        last = null;
        current = null;
    }

    public void add(E value) {
        Node<E> l = last;
        Node<E> newNode = new Node<E>(value, l, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public E get(int index) {
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.data;
    }

    public E removeLast() {
        Node<E> l = last;
        Node<E> previous = l.previous;
        if (l == null) {
            throw new NoSuchElementException();
        }
        E element = l.data;
        l.data = null;
        l.previous = null;
        last = previous;
        if (last == null) {
            first = null;
        } else {
            previous.next = null;
        }
        size--;
        return element;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator it = new Iterator() {
            int expectedModCount = modCount;
            Node<E> current = first;
            /**
             * index of iterator
             */
            private int index = 0;
            /**
             * Hasnext as long as the indexes are not out of limits and not equals to null
             */
            @Override
            public boolean hasNext() {
                return (current != null);
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (hasNext()) {
                    E result = current.data;
                    current = current.next;
                    return result;
                }
                throw new NoSuchElementException("linked list.next");
            }
        };
        return it;
    }

    public static class Node<E> {
        E data;
        Node<E> next;
        Node<E> previous;

        Node(E data) {
            this.data = data;
        }

        Node(E data, Node<E> previous, Node<E> next) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }
}
