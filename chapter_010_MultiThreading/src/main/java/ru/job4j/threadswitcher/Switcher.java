package ru.job4j.threadswitcher;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicBoolean;

@ThreadSafe
public class Switcher {

    private static final AtomicBoolean writeA = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {

        Thread first = new Thread(
            () -> {
                while (true) {
                    synchronized (Thread.currentThread()) {
                        while(!writeA.get()) {
                            try {
                                Thread.currentThread().wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    System.out.println("Thread A");
                    writeA.set(false);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        );
        Thread second = new Thread(
            () -> {
                while (true) {
                    synchronized (Thread.currentThread()) {
                        while (writeA.get()) {
                            Thread.currentThread().notify();
                        }
                    }
                    System.out.println("Thread B");
                    writeA.set(true);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        );
        first.start();
        second.start();
        first.join();
        second.join();
    }
}
