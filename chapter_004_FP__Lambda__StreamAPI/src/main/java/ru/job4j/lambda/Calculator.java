package ru.job4j.lambda;

import java.io.OutputStream;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Calculator {
    public interface Operation {
        double calc(int left, int right);
    }

    public void multiple(int start, int finish, int value, Operation op) {
        for (int index = start; index != finish; index++) {
            System.out.println(
                    op.calc(value, index)
            );
        }
    }

    public void multiple(int start, int finish, int value,
    BiFunction<Integer, Integer, Double> op,
    Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
//        calc.multiple(
//                0, 10, 2,
//                new Operation() {
//                    @Override
//                    public double calc(int left, int right) {
//                        return left * right;
//                    }
//                }
//        );
        //в виде лямбды
//        calc.multiple(
//                0, 10, 2,
//                (value, index) -> value * index
//        );
        //добавим вывод в консоль
//        calc.multiple(
//                0, 10, 2,
//                (value, index) -> {
//                    int result = value * index;
//                    System.out.printf("Multiple %s * %s = %s %n", value, index, result);
//                    return result;
//                }
//        );
        //используем встроенные функции
//        calc.multiple(
//                0, 10, 2,
//                (value, index) -> {
//                    double result = value * index;
//                    System.out.printf("Multiple %s * %s = %s %n", value, index, result);
//                    return result;
//                },
//                result -> System.out.println(result)
//        );
        MathUtil mathUtil = new MathUtil();
        calc.multiple(
               0, 10, 2,
                MathUtil::add,
                result -> System.out.println(result)
        );

        calc.multiple(
                1, 10, 1,
                mathUtil::sub,
                result -> System.out.println(result)
        );
    }
}
