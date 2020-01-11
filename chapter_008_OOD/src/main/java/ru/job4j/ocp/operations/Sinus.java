package ru.job4j.ocp.operations;

public class Sinus implements EngineerOperation {
    @Override
    public double operate(double number) {
        return Math.sin(number);
    }
}
