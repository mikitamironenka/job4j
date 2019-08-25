package ru.job4j.priorityqueue;

import java.util.LinkedList;

public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();

    public LinkedList<Task> getTasks() {
        return tasks;
    }

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.add(task);
        } else {
            int index = 0;
            for (int i = 0; i < tasks.size(); i++) {
                if (task.getPriority() < tasks.get(i).getPriority()) {
                    index = i;
                }
            }
            tasks.add(index, task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
