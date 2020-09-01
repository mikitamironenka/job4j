package ru.job4j.pools_6.threadsafesingletone;

//2. Double checked locking.
//Поле экземпляра обозначено volatile. Это обеспечит решение проблемы видимости, после инициализации поля.
//Первая проверка экземпляра идет до блока синхронизации, что позволяет улучить скорость
// работы по сравнению с single checked locking реализацией.
//В критической секции происходит инициализация экземпляра и запись его в переменную.
//Этот шаблон использовать не рекомендуется. Он уменьшает производительность системы при многопроцессорном окружении.


public class TrackerSingle_4 {

    private static volatile TrackerSingle_4 INSTANCE;

    private TrackerSingle_4() {
    }

    public static TrackerSingle_4 getInstance() {
        if (INSTANCE == null) {
            synchronized (TrackerSingle_4.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TrackerSingle_4();
                }
            }
        }
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingle_4 tracker = TrackerSingle_4.getInstance();
    }
}
