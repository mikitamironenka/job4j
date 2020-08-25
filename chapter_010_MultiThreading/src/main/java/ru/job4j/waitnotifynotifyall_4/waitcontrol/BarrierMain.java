package ru.job4j.waitnotifynotifyall_4.waitcontrol;

public class BarrierMain {

    public static void main(String[] args) {

        CountBarrier countBarrier = new CountBarrier(2);
        Thread master = new Thread(
            () -> {
                System.out.println(Thread.currentThread().getName() + " started");
                countBarrier.count();
                countBarrier.count();
            },
            "Master"
        );
        Thread slave = new Thread(
            () -> {
                countBarrier.await();
                System.out.println(Thread.currentThread().getName() + " started");
            },
            "Slave"
        );
        master.start();
        slave.start();
    }
}
