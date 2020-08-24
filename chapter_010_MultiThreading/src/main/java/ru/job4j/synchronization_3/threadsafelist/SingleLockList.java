package ru.job4j.synchronization_3.threadsafelist;

import net.jcip.annotations.ThreadSafe;
import ru.job4j.list.ArrayListContainer;
import java.util.Iterator;

@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {

    private final ArrayListContainer<T> container = new ArrayListContainer();

    public synchronized void add(T value) {
        this.container.add(value);
    }

    public synchronized T get(int index) {
        return (T)this.container.get(index);
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return copy(this.container).iterator();
    }

    private ArrayListContainer<T> copy(ArrayListContainer<T> arrayListContainer) {
        ArrayListContainer copyList = new ArrayListContainer();
        for (T el : arrayListContainer) {
            copyList.add(el);
        }
        return copyList;
    }
}
