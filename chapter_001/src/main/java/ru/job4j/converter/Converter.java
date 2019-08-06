package ru.job4j.converter;

public class Converter {

    private static final int EURO_EXCHANGE = 70;
    private static final int DOLLAR_EXCHANGE = 60;

    public static int rubleToEuro(int ruble) {
        return ruble / EURO_EXCHANGE;
    }

    public static int rubleToDollar(int ruble) {
        return ruble / DOLLAR_EXCHANGE;
    }

    public static int euroToRuble(int euro) {
        return euro * EURO_EXCHANGE;
    }

    public static int dollarToRuble(int dollar) {
        return dollar * DOLLAR_EXCHANGE;
    }

    public static void main(String[] args) {
        int euro = rubleToEuro(140);
        int dollar = rubleToDollar(180);
        int rubles;
        System.out.println("140 rubles are " + euro + " euro.");
        System.out.println("180 rubles are " + dollar + " dollars.");
        rubles = euroToRuble(10);
        System.out.println("10 euro are " + rubles + " rubles");
        rubles = dollarToRuble(10);
        System.out.println("10 dollars are " + rubles + " rubles");

        int in = 140;
        int expected = 2;
        int out = rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println("140 rubles are 2 euro. Test result : " + passed);

        in = 180;
        expected = 3;
        out = rubleToDollar(in);
        passed = expected == out;
        System.out.println("180 rubles are 3 dollar. Test result : " + passed);

        in = 10;
        expected = 700;
        out = euroToRuble(in);
        passed = expected == out;
        System.out.println("10 euro are 700 rouble. Test result : " + passed);

        in = 10;
        expected = 600;
        out = dollarToRuble(in);
        passed = expected == out;
        System.out.println("10 dollars are 600 rouble. Test result : " + passed);
    }
}
