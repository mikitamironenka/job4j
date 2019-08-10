package ru.job4j.loop;

public class Mortgage {

    public int year(int amount, int monthly, double percent) {
        int year = 0;
        double payment = amount * (1 + percent / 100);
        while (payment >= 0) {
            payment = payment - monthly * 12;
            year++;
        }
        return year;
    }
}
