package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        List<Integer> integers = new ArrayList<>();
        while (it.hasNext()) {
            Iterator<Integer> iterator = it.next();
            while (iterator.hasNext()) {
                integers.add(iterator.next());
            }
        }
        return integers.iterator();
    }
}
