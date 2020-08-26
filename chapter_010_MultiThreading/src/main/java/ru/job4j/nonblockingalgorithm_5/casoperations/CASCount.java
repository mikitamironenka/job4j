package ru.job4j.nonblockingalgorithm_5.casoperations;

import net.jcip.annotations.ThreadSafe;
import ru.job4j.commonresourses_2.atomic.Count;

import java.util.concurrent.atomic.AtomicReference;

//1. Реализовать неблокирующий счетчик.
//2. Для решения нужно использовать CAS операции.

@ThreadSafe
public class CASCount<T> {

    private final AtomicReference<Integer> count = new AtomicReference<>();

    public void increment() {
        int v;
        do {
            v = count.get();
        }
        while (!count.compareAndSet(v, v + 1));
    }

    public int get() {
        return count.get();
    }

}
