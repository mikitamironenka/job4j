package ru.job4j.nonblockingalgorithm_5.nonblockingcache;

import org.junit.Test;
import java.util.concurrent.atomic.AtomicReference;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class NonBlockingCustomCacheTest {

    @Test
    public void whenThreadsUpdateThenVersionIsDiff() throws InterruptedException {
        Base model = new Base(1, "one");
        NonBlockingCustomCache cache = new NonBlockingCustomCache();
        cache.add(model);
        Thread first = new Thread(
            () -> cache.update(new Base(1, "two"))
        );
        first.start();
        first.join();
        assertThat(cache.get(1).getVersion().get(), is(1));
        assertThat(cache.get(1).getBaseName(), is("two"));
    }

    @Test
    public void whenThrowException() throws InterruptedException {
        Base model = new Base(1, "model");
        NonBlockingCustomCache cache = new NonBlockingCustomCache();
        AtomicReference<Exception> ex = new AtomicReference<>();
        cache.add(model);
        Thread first = new Thread(() -> {
            try {
                Thread.sleep(50);
                model.getVersion().set(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread second = new Thread(
            () -> {
                try {
                    cache.update(new Base(1, "newModel"));
                } catch (OptimisticException e) {
                    ex.set(e);
                }
            }
        );
        first.start();
        second.start();
        first.join();
        second.join();
        assertThat(ex.get().getMessage(), is("OptimisticException"));
    }
}