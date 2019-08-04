package ru.job4j.calculate;

/**
 * Calculate.
 * @author Mikita Mironenka (m.mironenka@gmail.com)
 */
public class Calculate {

    /**
     * Addition
     * @param first first addend
     * @param second second addend
     */
    public static void add(double first, double second) {
        double result = first + second;
        System.out.println(first + " + " + second + " = " + result);
    }

    /**
     * Subtraction
     * @param first minuend
     * @param second subtrahend
     */
    public static void subTrack(double first, double second) {
        double result = first - second;
        System.out.println(first + " - " + second + " = " + result);
    }

    /**
     * Multiplication
     * @param first first multiplier
     * @param second first multiplier
     */
    public static void sub(double first, double second) {
        double result = first * second;
        System.out.println(first + " * " + second + " = " + result);
    }

    /**
     * Division
     * @param first divided
     * @param second divider
     */
    public static void div(double first, double second) {
        double result = first / second;
        System.out.println(first + " : " + second + " = " + result);
    }


    /**
     * Main.
     * @param args - args
     */
    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        sub(2, 1);
        subTrack(10, 5);
    }
}
