package ru.job4j.waitnotifynotifyall_4.junittestblockingqueue;

import net.jcip.annotations.GuardedBy;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleBlockingQueue <T> {
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    private final int limit;

    public  SimpleBlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void offer(T value)  {
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

    public synchronized T poll() {
        while (this.queue.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        T value = this.queue.poll();
        System.out.println("consume :" + value);
        return value;
    }

    public Queue<T> getQueue() {
        return this.queue;
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }
}