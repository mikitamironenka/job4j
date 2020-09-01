package ru.job4j.pools_6.threadpool;

import ru.job4j.waitnotifynotifyall_4.producerconsumerpattern.SimpleBlockingQueue;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPool {

    private final List<Thread> threads = new LinkedList<>();
    private final int size = Runtime.getRuntime().availableProcessors();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(size);
    private AtomicBoolean isThreadPoolShutDownInitiated = new AtomicBoolean(false);

    public ThreadPool() {
        for (int i = 1; i <= size; i++) {
            WorkerThread thread = new WorkerThread(tasks, this);
            thread.setName("Task Thread - " + i);
            thread.start();
            threads.add(thread);
        }
    }

    public AtomicBoolean getIsThreadPoolShutDownInitiated() {
        return isThreadPoolShutDownInitiated;
    }

    public void work(Runnable task) {
        if ( !isThreadPoolShutDownInitiated.get()) {
            System.out.println(isThreadPoolShutDownInitiated.get());
            tasks.offer(task);
        }
    }

    public void shutdown() {
        isThreadPoolShutDownInitiated = new AtomicBoolean(true);
        System.out.println(isThreadPoolShutDownInitiated.get());
    }
}
