package ru.job4j.loop;

public class PrimeNumber {

    public int calc(int finish) {
        int out = 0;
        for (int i = 2; i <= finish; i++) {
            int in = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    in++;
                }
            }
            if (in == 1) {
                out++;
            }
        }
        return out;
    }

    public boolean isSimple(int num) {
        if (num < 2) {
            return false;
        }
        double s = Math.sqrt(num);
        for (int i = 2; i <= s; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
