package ru.job4j.ocp.operations;

public class Division implements SimpleOperation {
    @Override
    public double operate(double one, double two) {
        return one / two;
    }
}
