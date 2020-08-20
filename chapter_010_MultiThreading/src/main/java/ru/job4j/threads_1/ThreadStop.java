package ru.job4j.threads_1;

public class ThreadStop {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(
            () -> {
                int count = 0;
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(count++);
                }
            }
        );
        thread.start();
        Thread.sleep(1);
        thread.interrupt();
    }
    //Планировщик выделяет разное время для каждой нити, по этой причине флаг прерывания выставляется в произвольное время.
}