package ru.job4j.sorting;

import java.util.Comparator;

//Вам нужно реализовать компаратор для сравнения двух массивов символов.
//Необходимо реализовать поэлементное сравнение двух списков, т.е. сравниваем элементы двух списков,
// находящихся на одних и тех же позициях (под одним и тем же индексом).
// Сравнение в лексикографическом порядке.
//В этом задании нельзя использовать метод String.compareTo.
//Вы можете использовать
//String.charAt(int index)
//Integer.compare(int left, int right),
//Character.compare(char left, char right);

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        char[] leftChars = left.toCharArray();
        char[] rightChars = right.toCharArray();

        int result = 0;
        int length = leftChars.length < rightChars.length ? leftChars.length : rightChars.length;

        for (int i = 0; i < length; i++) {
            int temp = Character.compare(leftChars[i], rightChars[i]);
            if (temp == 0) {
                continue;
            } else {
                result = temp;
                break;
            }
        }
        if (result == 0 && leftChars.length < rightChars.length) {
            result = -1;
        } else if (result == 0 && leftChars.length > rightChars.length) {
            result = 1;
        }
        return result;
    }
}
