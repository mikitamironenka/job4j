package ru.job4j.srp.operations;

public class Addition implements Operation {
    @Override
    public double operate(double one, double two) {
        return one + two;
    }
}
