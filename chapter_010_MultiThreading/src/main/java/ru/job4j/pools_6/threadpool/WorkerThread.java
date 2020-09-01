package ru.job4j.pools_6.threadpool;

import ru.job4j.waitnotifynotifyall_4.producerconsumerpattern.SimpleBlockingQueue;

public class WorkerThread extends Thread {

    private SimpleBlockingQueue<Runnable> tasks;
    private ThreadPool threadPool;

    public WorkerThread(SimpleBlockingQueue<Runnable> tasks, ThreadPool threadPool) {
        this.tasks = tasks;
        this.threadPool = threadPool;
    }

    @Override
    public void run() {
        try {
            while (!threadPool.getIsThreadPoolShutDownInitiated().get() || !tasks.isEmpty()) {
                Runnable task;
                if ((task = tasks.poll()) != null) {
                    task.run();
                }
                Thread.sleep(1);
            }
        } catch (RuntimeException | InterruptedException e) {
            throw new CustomThreadPoolException(e);
        }
    }
}
