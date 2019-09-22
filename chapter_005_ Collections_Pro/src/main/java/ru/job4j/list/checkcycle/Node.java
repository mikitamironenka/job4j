package ru.job4j.list.checkcycle;
//Задан связанный список.
//class Node<T> {
//   T value;
//   Node<T> next;
//}
//Node first = new Node(1);     first.next = two;
//Node two = new Node(2);       two.next = third;
//Node third = new Node(3);     third.next = four;
//Node four = new Node(4);      four.next = first;
//Написать алгоритм определяющий, что список содержит замыкания.
//boolean hasCycle(Node first);
//Обратите внимание, что список может быть замкнут и в середине. К примеру, 3-й узел будет ссылаться на 2-й узел.
// Определение зацикленности необходимо реализовать путем прохода по узлам, без использования коллекций.

public class Node<T> {

    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
