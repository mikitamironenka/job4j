package ru.job4j.threadswitcher;

import java.util.concurrent.atomic.AtomicBoolean;

public class MasterSlaveBarrier {

    private final Object monitor = this;
    private static AtomicBoolean writeA = new AtomicBoolean(true);

    /**
     * While condition writeA for master thread is false - the thread wait for better times
     * @throws InterruptedException
     */
    public void tryMaster() throws InterruptedException {
        synchronized (monitor) {
            while (!writeA.get()) {
                wait();
            }
            writeA.set(false);
            System.out.println("Thread A");
            Thread.sleep(1000);
            notify();
        }
    }

    public void trySlave() throws InterruptedException {
        synchronized (monitor) {
            while (writeA.get()) {
                wait();
            }
            writeA.set(true);
            System.out.println("Thread B");
            Thread.sleep(1000);
            notify();
        }
    }

    public void doneMaster() {
        synchronized (monitor) {
            while (true) {
                try {
                    tryMaster();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void doneSlave() {
        synchronized (monitor) {
            while (true) {
                try {
                    trySlave();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        MasterSlaveBarrier masterSlaveBarrier = new MasterSlaveBarrier();
        Thread master = new Thread(
            () -> {
                masterSlaveBarrier.doneMaster();
            }
        );
        Thread slave = new Thread(
            () -> {
                masterSlaveBarrier.doneSlave();
            }
        );
        master.start();
        slave.start();
    }
}
