package ru.job4j.commonresourses_2.atomic;


//1. Ниже приведен код. Напишите в комментарии. Является ли этот код атомарным. Напишите почему нет.

public final class Cache {

    private static Cache cache;

    private static Cache instOf() {
        if (cache == null) {
            cache = new Cache();
        }
        return cache;
    }

}
