package ru.job4j.testtask;

//Кофемашина.
// Задание такое.
//Надо реализовать метод выдачи сдачи для автомата.
//int[] changes(int value, int price)
//value = купюра. 50 100 и тд.
//price = цена кофе
//в автомате монеты наминалом 1 2 5 10
//Пример. Мы засунули 50 рублей выбрали кофе за 35. Сдачу автомат должен дать 15 рублей
//Алгоритм должен вернуть наименьшее количество монет.
//Метод вернет массив {10, 5} = 15 рублей
//создать задачу залить в репозитори добавить ссылку

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    private static int[] coins = new int[] {1, 2, 5, 10};

    public static int[] changes(int value, int price) {
        List<Integer> list = new ArrayList<>();
        int oddMoney = value - price;
        while (oddMoney > 0) {
            for (int i = coins.length - 1; i >= 0; i--) {
                if (oddMoney - coins[i] < 0) {
                    continue;
                } else {
                    oddMoney = oddMoney - coins[i];
                    list.add(coins[i]);
                    break;
                }
            }
        }
        int [] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }


    public static void main(String[] args) {

        int [] res = changes(50, 22);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
