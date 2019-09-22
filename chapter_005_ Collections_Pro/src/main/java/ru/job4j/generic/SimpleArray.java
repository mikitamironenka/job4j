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

    private Object[] objects;
    private int index = 0;

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
        if (!checkIndex()) {
            System.out.println("Wrong index");
        } else {
        this.objects[index] = model;
        }
    }

    public void remove(int index) {
        if (!checkIndex()) {
            System.out.println("Wrong index");
        } else {
            Object[] array = new Object[this.objects.length - 1];
            int remainingElements = this.objects.length - (index + 1);
            System.arraycopy(this.objects, 0, array, 0, index);
            System.arraycopy(this.objects, index + 1, array, index, remainingElements);
            this.objects = array;
            this.index--;
        }
    }

    public T get(int index) {
        T result = null;
        if (!checkIndex()) {
            System.out.println("Wrong index");
        } else {
            result = (T) this.objects[index];
        }
        return result;
    }

    private boolean checkIndex() {
        return index < 0 || index > this.index;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < index;
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
