package ru.job4j.pools_6.threadsafesingletone;

//Его работа стабильна и не влияет не производительность системы.
//Вывод.
//Если у вас нет необходимости в ленивой загрузки используется шаблоны из первой группы.
// Например. инициализация кеша или базы данных.
//Если в приложении есть затратные ресурсы нужно использовать шаблоны с ленивой загрузкой.
// Здесь можно использовать только один шаблон - это Holder.
//Другие шаблоны будут отрицательно влиять на производительность системы.

public class TrackerSingle_5 {

    private TrackerSingle_5() {
    }

    public static TrackerSingle_5 getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSingle_5 INSTANCE = new TrackerSingle_5();
    }

    public static void main(String[] args) {
        TrackerSingle_5 tracker = TrackerSingle_5.getInstance();
    }
}
