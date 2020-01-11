package ru.job4j.ocp.operations;

public class Multiplication implements SimpleOperation {
    @Override
    public double operate(double one, double two) {
        return one * two;
    }
}
