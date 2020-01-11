package ru.job4j.ocp.operations;

public class Addition implements SimpleOperation {
    @Override
    public double operate(double one, double two) {
        return one + two;
    }
}
