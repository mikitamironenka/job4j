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
        int cells = rows;
        int[][] twoDArray = new int[rows][cells];

        int count = 0;
//        for (int[] array : twoDArray) {
//            for (int elem : array) {
//                if (count < list.size()) {
//                    elem = list.get(count);
//                    System.out.println(elem);
//                    count++;
//                } else {
//                    elem = 0;
//                    count++;
//                }
//            }
//        }
        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                if (count < list.size()) {
                    twoDArray[i][j] = list.get(count);
                    count++;
                } else {
                    twoDArray[i][j] = 0;
                    count++;
                }
            }
        }
        return twoDArray;
    }

    public List<Integer> convert (List<int[]> list) {

        List<Integer> result = new ArrayList<>();

        for (int[] arr : list) {
            for (int num : arr) {
                result.add(num);
            }
        }

        return result;
    }
}
