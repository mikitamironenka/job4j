package ru.job4j.commonresourses_2.memorymodeljava;


//Исправьте в нем ошибку. Текстом в комментарии напишите, почему возникает ошибка.

public class DCLSingletone {

    private static volatile DCLSingletone inst;

    public static DCLSingletone instOf() {
        if (inst == null) {
            synchronized (DCLSingletone.class) {
                if (inst == null) {
                    inst = new DCLSingletone();
                }
            }
        }
        return inst;
    }

    private DCLSingletone() {
    }
}
