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
        Base model2 = new Base(1, "model");
        Base model3 = new Base(1, "model");
        NonBlockingCustomCache cache = new NonBlockingCustomCache();
        AtomicReference<Exception> ex = new AtomicReference<>();
        cache.add(model);
        cache.add(model2);
        cache.add(model3);
        Thread first = new Thread(
            () -> {
                try {
                    cache.update(model);
                } catch (OptimisticException e) {
                    ex.set(e);
                }
            }
        );
        Thread second = new Thread(
            () -> {
                try {
                    cache.update(model2);
                } catch (OptimisticException e) {
                    ex.set(e);
                }
            }
        );
        Thread third = new Thread(
            () -> {
                try {
                    cache.update(model);
                } catch (OptimisticException e) {
                    ex.set(e);
                }
            }
        );
        Thread forth = new Thread(
            () -> {
                try {
                    cache.update(model);
                } catch (OptimisticException e) {
                    ex.set(e);
                }
            }
        );
        first.start();
        second.start();
        third.start();
        forth.start();
        first.join();
        second.join();
        third.join();
        forth.join();
        assertThat(ex.get().getMessage(), is("OptimisticException"));
    }
}