package ru.job4j.pools_6.threadpool;

import ru.job4j.waitnotifynotifyall_4.producerconsumerpattern.SimpleBlockingQueue;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPool {

    private final List<Thread> threads = new LinkedList<>();
    private final int size = Runtime.getRuntime().availableProcessors();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(size);
    private final AtomicBoolean isThreadPoolShutDownInitiated = new AtomicBoolean(false);

    public ThreadPool() {
        for (int i = 1; i <= size; i++) {
            WorkerThread thread = new WorkerThread(tasks, this);
            thread.setName("Task Thread - " + i);
            thread.start();
            threads.add(thread);
        }
    }

    public void work(Runnable task) {
        if ( !isThreadPoolShutDownInitiated.get()) {
            tasks.offer(task);
        }
    }

    public void shutdown() {
        isThreadPoolShutDownInitiated.set(true);
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " is executing task.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ThreadPool threadPool = new ThreadPool();
        threadPool.work(r);
        threadPool.work(r);
        threadPool.shutdown();

    }
}
