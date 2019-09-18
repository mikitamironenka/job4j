package ru.job4j.generic;

//В этом задании необходимо сделать универсальную обертку над массивом.
//Создать класс:
//public class SimpleArray<T>
//Добавить методы:
//add(T model) - добавляет указанный элемент (model) в первую свободную ячейку;
//set(int index, T model) - заменяет указанным элементом (model) элемент, находящийся по индексу index;
//remove(int index) - удаляет элемент по указанному индексу, все находящиеся справа элементы при этом
// необходимо сдвинуть на единицу влево (в середине массива не должно быть пустых ячеек);
//get(int index) - возвращает элемент, расположенный по указанному индексу;
//Также, реализуйте интерфейс Iterable<T> - метод iterator() возвращает итератор, предназначенный для обхода данной структуры.
//Объект должен принимать количество ячеек. Структура не должна быть динамической. Если идет переполнение надо выкинуть ошибку.

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable {

    Object[] objects;
    int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public int getSize() {
        return this.objects.length;
    }
    public void add(T model) {
        this.objects[this.index++] = model;
    }

    public void set(int index, T model) {
        this.objects[index] = model;
    }

    public void remove(int index) {
        this.objects[index] = null;
        for (int i = index; i < this.objects.length - 1; i++) {
            this.objects[i] = this.objects[i + 1];
        }

//        this.objects = Arrays.stream(this.objects)
//                .filter(p -> p != null)
//                .toArray(Object[] :: new);
    }

    public T get(int index) {
       return (T) this.objects[index];
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < objects.length && objects[currentIndex] != null;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    return objects[currentIndex++];
                }
             }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
