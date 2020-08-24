package ru.job4j.commonresourses_2.immutable;

public class Node<T> {

    private final Node<T> next;
    private final T value;

    public Node(Node next, T value) {
        this.value = value;
        this.next = next;
    }

}
