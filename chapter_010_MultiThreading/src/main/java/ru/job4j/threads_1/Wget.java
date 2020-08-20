package ru.job4j.threads_1;

public class Wget {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(
            () -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        System.out.println("start ...");
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        );
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        thread.join();
    }
}
