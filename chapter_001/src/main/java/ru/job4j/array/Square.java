package ru.job4j.array;

/**
 * Square numbers in array
 */
public class Square {

    /**
     * Square numbers
     * @param bound
     * @return array with square numbers
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        for (int i = 0; i <= rst.length - 1; i++) {

            rst[i] = (int) Math.pow((i + 1), 2);
        }
        return rst;
    }
}
