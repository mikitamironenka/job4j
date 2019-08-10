package ru.job4j.array;

/**
 * Find index
 */
public class FindLoop {

    public int indexOf(int[] data, int el) {
        int result = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                result = index;
                break;
            }
        }
        return result;
    }

    public int indexOf(int[] data, int el, int start, int finish) {
        int result = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int i = start; i < finish; i++) {
            if (data[i] == el) {
                result = i;
            }
        }
        return result;
    }

    public int[] sort(int[] data) {
        int temp;
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = i; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
        return data;
    }

}
