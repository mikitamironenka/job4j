package ru.job4j.threadswitcher;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
public class Switcher {

    private static final int threadA = 0;
    private static final int threadB = 1;

    private static final AtomicBoolean ref = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {
        Thread first = new Thread(
            () -> {
                synchronized (Switcher.class) {
                    while (true) {
                        try {
                            if (!ref.get()) {
                                ref.set(true);
                            }
                            System.out.println("Thread A");
                            Thread.currentThread().wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        );
        Thread second = new Thread(
            () -> {
                synchronized (Switcher.class) {
                    while (true) {
                        if (ref.get()) {
                            ref.set(false);
                        }
                        System.out.println("Thread B");
                        Thread.currentThread().notify();
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
