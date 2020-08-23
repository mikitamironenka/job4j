package ru.job4j.commonresourses_2.immutable;

public class Node<T> {
    private Node next;
    private T value;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        Node newNode = new Node(value);
        newNode.next = null;
    }
}
