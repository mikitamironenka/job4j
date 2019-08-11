package ru.job4j.condition;

public class Max {

    public int max(int left, int right) {
        int result = left >= right ? left : right;
        return result;
    }

    public int maxFromThree(int first, int second, int third) {
        int max = max(second, third);
        int result = first >= max ? first : max;
        return result;
    }

    public int maxFromFour(int first, int second, int third, int fourth) {
        int max = maxFromThree(second, third, fourth);
        int result = first >= max ? first : max;
        return result;
    }
}
