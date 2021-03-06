package ru.job4j.srp;



public class Calculator {
    /**
     * Addition
     * @param first first addend
     * @param second second addend
     */
    public double add(double first, double second) {
        return first + second;
    }

    public double add(double first, double second, double third) {
        return add(first, add(second, third));
    }

    /**
     * Subtraction
     * @param first minuend
     * @param second subtrahend
     */
    public double subTrack(double first, double second) {
        return first - second;
    }

    /**
     * Multiplication
     * @param first first multiplier
     * @param second first multiplier
     */
    public double sub(double first, double second) {
        return first * second;
    }

    /**
     * Division
     * @param first divided
     * @param second divider
     */
    public double div(double first, double second) {
        return first / second;
    }
}
