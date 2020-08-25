package ru.job4j.waitnotifynotifyall_4.producerconsumerpattern;

import org.junit.Test;

public class SimpleBlockingQueueTest {

    @Test
    public void whenProgrammeGoRight() {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(5);

        Thread producer = new Thread(
            () -> {
                for (int i = 1; i <= 10; i++) {
                    try {
                        queue.offer(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        );
        Thread consumer = new Thread(
            () -> {
                for (int i = 1; i <= 10; i++) {
                    try {
                        queue.poll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        );

        producer.start();
        consumer.start();
    }

}