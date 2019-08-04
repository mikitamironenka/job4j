package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        boolean booleanInData = data[0];
        for (int i = 0; i < data.length; i++) {
            if(data[i] == booleanInData) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
