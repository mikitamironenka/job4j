package ru.job4j.loop;

//Метод должен вычислять сумму чётныx чисел в диапазоне от start до finish;

public class Counter {

    public int add(int start, int finish) {
        int sum = 0;

        for(int i = start; i <= finish; i++) {

            if(i % 2 == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }


}
