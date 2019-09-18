package ru.job4j.generic.storetask;

//Сделать интерфейс Store<T extends Base>,
//где Base - это абстрактный класс для моделей c методами String getId();
//Пример приведен выше.
//1. Сделать два класса User, и Role, которые наследуют Base класс.
//2. Сделать два класса хранилища UserStore и RoleStore. Внутри для хранения данных использовать SimpleArray.
//3. Помните. про инкапсуляцию. Вам нельзя изменять интерфейс Store. Например. replace(int index,  T model)
// - нельзя делать. Так как мы изменили входящий параметр.
//4. После реализации проверьте можно ли избавиться от дублирования кода в вашем проекте.
// UserStore и RoleStore будут иметь один и тот же функционал. Общий для них функционал необходимо вынести
// в абстрактный класс AbstractStore.
//5. Помните, что хранилище должны быть жестко ограничены хранимым типом.
// Например для UserStore тип хранимых данных должен быть User.


public abstract class Base {

    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
