package ru.job4j.priorityqueue;

import java.util.Iterator;
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
        Iterator iterator = tasks.iterator();
        if (tasks.size() == 0) {
            tasks.add(task);
        } else {
            var index = 0;
            var i = 0;
            while (iterator.hasNext()) {
                Task temp = (Task) iterator.next();
                if (task.getPriority() < temp.getPriority()) {
                    index = i;
                }
                i++;
            }
            tasks.add(index, task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
