package ru.job4j.lambda;

//1. Реализовать метод подсчета функции в диапазоне.
//List<Double> diapason(int start, int end, Function<Double, Double> func);
//2. Реализации функций в тестах.
//    - линейная.
//    - квадратичная.
//    - логарифмическая.
//Пример:
//@Test
//public void whenLinearFunctionThenLinearResults() {
//    List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
//    List<Double> expected = Arrays.asList(11D, 13D, 15D);
//    assertThat(result, is(expected));
//}
//3. Необходимо использовать только встроенные функциональные интерфейсы

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CountFunction {

    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
//        double first = start;
//        while (first < end) {
//            list.add(func.apply(first))
//        }

        for (int index = start; index < end; index++) {
            list.add(func.apply((double) index));
        }
        return list;
    }
}
