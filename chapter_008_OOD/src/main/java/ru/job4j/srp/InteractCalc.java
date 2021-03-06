package ru.job4j.srp;

// Используя класс Calculator.
//1. Сделать класс InteractCalc.
//2. В классе должен быть пользовательский ввод.
//3. Повторный выбор операции и переиспользование предыдущего вычисления.
//4. Проект должен следовать SRP.

import ru.job4j.srp.operations.*;

import java.util.Scanner;

public class InteractCalc {

    private Calculator calc;
    private Scanner scanner;

    /**
     * Constructor
     */
    public InteractCalc() {
        this.calc = new Calculator();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Get number for operation
     * @return double number
     */
    public double getNum() {
        System.out.println("Enter the number:");
        double num;
        if (scanner.hasNextDouble()){
            num = scanner.nextDouble();
        } else {
            System.out.println("Wrong enter. Type number again.");
            scanner.next();
            num = getNum();
        }
        return num;
    }

    /**
     * Get operation from user
     * @return char value of operation
     */
    public char getOperation() {
        System.out.println("Type the operation:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Operation is wrong. Type the operation.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    /**
     * Chose operation and make calculation
     */
//    public double calc(double numOne, double numTwo, char operation){
//        double result;
//        switch (operation) {
//            case '+':
//                result = calc.add(numOne, numTwo);
//                break;
//            case '-':
//                result = calc.subTrack(numOne, numTwo);
//                break;
//            case '*':
//                result = calc.sub(numOne, numTwo);
//                break;
//            case '/':
//                result = calc.div(numOne, numTwo);
//                break;
//            default:
//                System.out.println("Operation is wrong. Type the operation.");
//                result = calc(numOne, numTwo, getOperation());
//        }
//        return result;
//    }

    public Operation calculate(char operation){
        Operation result = null;
        switch (operation) {
            case '+':
                result = new Addition();
                break;
            case '-':
                result = new Subtraction();
                break;
            case '*':
                result = new Multiplication();
                break;
            case '/':
                result = new Division();
                break;
            default:
                System.out.println("Operation is wrong. Type the operation.");
                result = calculate(getOperation());
        }
        return result;
    }
    /**
     * Main functionality of calculation
     */
    public void operate() {

        boolean isOperate = true;
        double numOne = getNum();
        double numTwo = getNum();
        char operation = getOperation();
        double result = calculate(operation).operate(numOne, numTwo);
        while (isOperate) {
            System.out.println("The answer is " + result);
            System.out.println("Want some more operation y/n?");
            String answer = scanner.next();
            if (answer.equals("n")) {
                isOperate = false;
            } else {
               operation = getOperation();
               numTwo = getNum();
               result = calculate(operation).operate(result, numTwo);
            }
        }
    }

}
