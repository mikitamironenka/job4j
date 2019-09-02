package ru.job4j.tracker.useraction;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Tracker;

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
    void execute(Input input, Tracker tracker, Consumer output);
    /**
     * Метод возвращает информацию о данном пункте меню.
     * @return Строка меню
     */
    String info();

}
