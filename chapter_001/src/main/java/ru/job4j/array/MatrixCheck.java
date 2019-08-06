package ru.job4j.array;

public class MatrixCheck {

    public boolean mono(boolean[][] data) {
        boolean result = true;

        if (data.length == 2) {
            if (data[0][0] != data[1][1] || data[0][1] != data[1][0]) {
                result = false;
            }
        } else {
            for (int i = 0; i < data.length; i++) {
                if (data[1][1] != data[i][i] || data[1][1] != data[data.length - 1 - i][i]) {
                    result = false;
                }
            }
        }
        return result;
    }
}
