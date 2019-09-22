package ru.job4j.list.checkcycle;

public class CycleChecker {

    public boolean hasCycle(Node first) {
        boolean result = false;
        Node tortoise = first;
        Node hare = first;
        while (hare != null || hare.getNext() != null) {
            tortoise = tortoise.getNext();
            hare = hare.getNext().getNext();
            if (hare == null) {
                break;
            }
            if (tortoise == hare) {
                result = true;
                break;
            }
        }
        return result;
    }
}
