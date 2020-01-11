package ru.job4j.ocp.operations;

public class Subtraction implements SimpleOperation {
    @Override
    public double operate(double one, double two) {
        return one - two;
    }
}
