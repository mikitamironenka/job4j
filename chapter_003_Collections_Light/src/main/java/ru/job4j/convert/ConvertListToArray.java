package ru.job4j.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//public int[][] toArray (List<Integer> list, int rows) {} -
// метод toArray должен равномерно разбить лист на количество строк двумерного массива.
// В методе toArray должна быть проверка - если количество элементов не кратно количеству строк -
// оставшиеся значения в массиве заполнять нулями.


public class ConvertListToArray {

    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? rows : list.size() / rows + 1;
        int[][] twoDArray = new int[rows][cells];

        int i = 0, j = 0;
        for (int num : list) {
            if (j == cells) {
                j = 0;
                i++;
            }
            twoDArray[i][j] = num;
            j++;
        }
        return twoDArray;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] arr : list) {
            for (int num : arr) {
                result.add(num);
            }
        }
        return result;
    }
}
