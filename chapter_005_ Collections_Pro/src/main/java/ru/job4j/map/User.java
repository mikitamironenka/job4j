package ru.job4j.map;

import java.util.*;
//Создать два объекта User, которые имеют одинаковые поля.
//Создать карту Map<User, Object>
//Добавить два объекта. Вывести карту на печать. Описать полученный результат словами.
//Объясните полученный результат почему так получилось.

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>();
        User userOne = new User("Mike", 2, new GregorianCalendar(1980, 1, 1));
        User userTwo = new User("Mike", 2, new GregorianCalendar(1980, 1, 1));
        map.put(userOne, new Object());
        map.put(userTwo, new Object());
        System.out.println(map);
        System.out.println(userOne.hashCode());
        System.out.println(userTwo.hashCode());
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name
                + ", children=" + children
                + ", birthday=" + birthday.getTime()
                + '}';
    }
}
