package ru.job4j.ocp.operations;

public class Cosinus implements EngineerOperation {
    @Override
    public double operate(double number) {
        return Math.cos(number);
    }
}
