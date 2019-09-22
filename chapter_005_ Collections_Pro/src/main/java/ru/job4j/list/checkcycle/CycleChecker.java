package ru.job4j.list.checkcycle;

public class CycleChecker {

    public boolean hasCycle(Node first) {
        boolean result = false;
        Node firstNode = first;
        Node node = firstNode.getNext();
        while (node != null || node != firstNode) {
            node = node.getNext();
            if (node == firstNode) {
                result = true;
                break;
            }
            if (node == null) {
                break;
            }
        }
        return result;
    }
}
