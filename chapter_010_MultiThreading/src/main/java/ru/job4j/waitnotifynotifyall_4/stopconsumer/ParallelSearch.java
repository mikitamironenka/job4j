package ru.job4j.waitnotifynotifyall_4.stopconsumer;

import ru.job4j.waitnotifynotifyall_4.producerconsumerpattern.SimpleBlockingQueue;

public class ParallelSearch {


    public static void main(String[] args) throws InterruptedException {

        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>(5);
        final Thread consumer = new Thread(
            () -> {
                while (true) {
                    try {
                        Integer el = queue.poll();
                        System.out.println(el);
                        Thread.sleep(1000);
                        if (queue.isEmpty() ) {
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        );
        consumer.start();
        new Thread(
            () -> {
                for (int index = 0; index != 3; index++) {
                    try {
                        queue.offer(index);
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        ).start();
    }
}
