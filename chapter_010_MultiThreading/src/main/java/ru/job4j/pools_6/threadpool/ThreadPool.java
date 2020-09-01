package ru.job4j.pools_6.threadpool;

import ru.job4j.waitnotifynotifyall_4.producerconsumerpattern.SimpleBlockingQueue;
import java.util.LinkedList;
import java.util.List;

public class ThreadPool {

    private final List<Thread> threads = new LinkedList<>();
    private final int size = Runtime.getRuntime().availableProcessors();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(size);

    public ThreadPool() {
        for (int i = 1; i <= size; i++) {
            WorkerThread thread = new WorkerThread(tasks, this);
            thread.setName("Task Thread - " + i);
            thread.start();
            threads.add(thread);
        }
    }


    public void work(Runnable task) {
            tasks.offer(task);
    }

    public void shutdown() {
        threads.forEach(Thread::interrupt);
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + " is executing task.");
        };
        ThreadPool threadPool = new ThreadPool();
        threadPool.work(r);
        threadPool.work(r);
        threadPool.shutdown();
    }
}
