package ru.job4j.waitnotifynotifyall_4.waitcontrol;

//Переменная total содержит количество вызовов метода count().
//Нити, которые выполняют метод await, могут начать работу, если поле count == total.
// Если оно не равно, то нужно перевести нить в состояние wait.

public class CountBarrier {

    private final Object monitor = this;

    private final int total;

    private int count = 0;

    public CountBarrier(final int total) {
        this.total = total;
    }

    public void count() {
        synchronized (monitor) {
            ++this.count;
            monitor.notifyAll();
        }
    }

    public void await() {
        synchronized (monitor) {
                try {
                    if (this.count != this.total) {
                        monitor.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
