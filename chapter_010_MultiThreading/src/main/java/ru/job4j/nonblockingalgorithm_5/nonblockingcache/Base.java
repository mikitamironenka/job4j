package ru.job4j.nonblockingalgorithm_5.nonblockingcache;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class Base {
    @GuardedBy("this")
    private final int id;
    private final String baseName;
    private final AtomicReference<Integer> version = new AtomicReference<Integer>(0);

    public Base(int id, String baseName) {
        this.id = id;
        this.baseName = baseName;
    }

    public void incrementVersion() {
        int v;
        do {
            v = version.get();
        }
        while (!version.compareAndSet(v, v + 1));
    }

    public AtomicReference<Integer> getVersion() {
        return version;
    }

    public synchronized int getId() {
        return this.id;
    }

    public synchronized String getBaseName() {
        return this.baseName;
    }

    @Override
    public synchronized boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Base base = (Base) o;
        return id == base.id &&
            version == base.version;
    }

    @Override
    public synchronized int hashCode() {
        return Objects.hash(id, version);
    }


}
