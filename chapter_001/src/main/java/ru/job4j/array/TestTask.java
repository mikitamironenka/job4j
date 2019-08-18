package ru.job4j.array;
//Даны два массива, отсортированные по возрастанию.
//Переместить данные из этих двух массивов в третий, чтобы
//элементы в нём также были отсортированы по возрастанию.


public class TestTask {

    public static void main(String[] args) {

        int[] ar1 = new int[]{0, 3, 7, 10, 11};
        int[] ar2 = new int[]{1, 2, 5, 8, 20, 100, 102};
        int[] result = createArray(ar1, ar2);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }

    public static int[] createArray(int[] ar1, int[] ar2) {
        int[] result = new int[ar1.length + ar2.length];
        int i = 0, j = 0, k = 0;
        while (i < ar1.length && j < ar2.length) {
            result[k++] = (ar1[i] < ar2[j] ? ar1[i++] : ar2[j++]);
        }
        while (i < ar1.length) {
            result[k++] = ar1[i++];
        }
        while (j < ar2.length) {
            result[k++] = ar2[j++];
        }
        return result;
    }
}
