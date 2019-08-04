package ru.job4j.loop;

public class Mortgage {

    public int year(int amount, int monthly, double percent) {
        int year = 0;
        double sumToPay = amount * (1 + percent/100);

        while( sumToPay >= 0) {

            sumToPay = sumToPay - monthly * 12;
            year++;
        }

        return year ;
    }

    public static void main(String[] args) {



    }
}
