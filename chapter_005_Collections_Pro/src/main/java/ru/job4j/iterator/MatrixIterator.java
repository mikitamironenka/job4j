package ru.job4j.iterator;

//Необходимо создать итератор для двухмерного массива.
//int[][] value = {
//   {1, 2}
//   {3, 4}
//};
//метод next = должен вернуть последовательно 1, 2, 3, 4.
//Старайтесь написать универсальное решение, чтобы оно не было жестко ориентировано на тестовый пример.
//И хотя в примере указана квадратная матрица, программа должна корректно обрабатывать и jagged array тоже.
//Пример jagged array - {{1},{2, 3, 4, 5,},{6, 7}, {8, 9, 10, 11, 12, 13, 14}}
//Не используйте в данном задании коллекции из JDK, вспомогательные массивы и т.д.
//Постарайтесь реализовать последовательным проходом по массиву.

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {

    private final int[][] value;

    public MatrixIterator(int[][] value) {
        this.value = value;
    }

    private int row = 0;
    private int column = 0;

    @Override
    public boolean hasNext() {
        return this.row != this.value.length;
    }

    private void resetIndexes() {
        if (column == value[row].length) {
            column = 0;
            row++;
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int next = value[row][column++];
        resetIndexes();
        return next;
    }
}
