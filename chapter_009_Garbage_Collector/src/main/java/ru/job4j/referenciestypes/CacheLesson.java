package ru.job4j.referenciestypes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class CacheLesson {

    private static final Logger Log = LoggerFactory.getLogger(CacheLesson.class);

    public static void main(String[] args) {
        // объект со ссылкой типа weak сборщик уничтожает сразу.
        WeakReference<User> weakUser =  new WeakReference<User>(new User("test"));
        // объект со ссылкой soft сборщик не уничтожает, если есть ещё ресурсы.
        SoftReference<User> softUser =  new SoftReference<User>(new User("test"));System.gc();
        System.out.println(weakUser.get());
        System.out.println(softUser.get());
    }
}
