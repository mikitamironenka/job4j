package ru.job4j.convert;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {

    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();

        for (int[] arr : array) {
            for (int num : arr) {
                list.add(num);
            }
        }
        return list;
    }
}
