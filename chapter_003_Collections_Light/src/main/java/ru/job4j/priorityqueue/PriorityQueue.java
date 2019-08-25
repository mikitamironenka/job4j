package ru.job4j.priorityqueue;

import java.util.LinkedList;

public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        //TODO добавить вставку в связанный список.
//        if ( tasks.size() == 0 || task.getPriority() < tasks.size()) {
//           tasks.add(task);
//        } else {
//            this.tasks.add(task.getPriority(), task);
//        }
        tasks.add(task);
        if (tasks.size() > 1) {
            Task temp;
            for (int i = 0; i < tasks.size(); i++) {
                for (int j = i + 1; j < tasks.size(); j++) {
                    if (tasks.get(i).getPriority() > tasks.get(j).getPriority()) {
                        temp = tasks.get(i);
                        tasks.set(i, tasks.get(j));
                        tasks.set(j, temp);
                    }
                }
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
