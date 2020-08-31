package ru.job4j.waitnotifynotifyall_4.producerconsumerpattern;

import lombok.extern.java.Log;
import net.jcip.annotations.GuardedBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;

//Задание.
//1. Реализовать методы poll() и offer().
//2. Написать тесты. В тестах должны быть две нити: одна производитель, другая потребитель.
//Через методы join() добиться последовательного выполнение программы.


public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    private final int limit;

    public SimpleBlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void offer(T value) {
        while(this.queue.size() == this.limit) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.queue.add(value);
        System.out.println("produce :" + value);
        if (this.queue.size() == 1) {
            notifyAll();
        }
    }

    public synchronized T poll() throws InterruptedException{
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        T value = this.queue.poll();
        System.out.println("consume :" + value);
        return value;
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }
}
