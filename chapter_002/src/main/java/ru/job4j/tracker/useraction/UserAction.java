package ru.job4j.tracker.useraction;

import ru.job4j.tracker.HbnTracker;
import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;

import java.util.function.Consumer;

public interface UserAction {

    /**
     * Метод возвращает ключ опции.
     * @return ключ
     */
    int key();
    /**
     * Основной метод.
     * @param input объект типа Input
     * @param tracker объект типа Tracker
     */
    void execute(Input input, Store tracker, Consumer output);
    /**
     * Метод возвращает информацию о данном пункте меню.
     * @return Строка меню
     */
    String info();

}
