package ru.job4j.pools_6.threadpool;

public class CustomThreadPoolException extends Throwable {
    public CustomThreadPoolException(Exception e) {
        super("CustomThreadPoolException");
    }
}
