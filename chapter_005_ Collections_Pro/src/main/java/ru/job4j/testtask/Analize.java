package ru.job4j.testtask;

//Это задание сводиться к определению разницы между начальным состояние массива и измененным.
//Например. Дан массива чисел.
//Начальное состояние 1 10 13 4 5
//Конечное состояние 1 13 4
//Разница будет будет массив 10 5.
//Это элементарный пример. Ваша задача более сложная.
//метод должен возвращать статистику об изменении коллекции.
//List<User> previous - начальные данные,
//List<User> current - измененные данные.
//Нужно понять:
//Сколько добавлено новых пользователей.
//Сколько изменено пользователей. Изменённым считается объект в котором изменилось имя. а id осталось прежним.
//Сколько удалено пользователей.

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info result = new Info();
        int users = newUsers(previous, current);
        if (users < 0) {
            result.setDeleted(users);
        } else if (users > 0) {
            result.setAdded(users);
        }
        result.setChanged(User.edited);
        return result;
    }

    /**
     * Method to return count of added or deleted users.
     * @param previous list of users before changing (adding, deleting, editing user's names)
     * @param current list of users after changing
     * @return int - count of of added or deleted users.
     */
    public int newUsers(List<User> previous, List<User> current) {
        int result = 0;
        Set<Integer> prevKeys = new HashSet<>();
        Set<Integer> currKeys = new HashSet<>();
        for (User user : previous) {
            prevKeys.add(user.id);
        }
        for (User user : current) {
            currKeys.add(user.id);
        }
        result = currKeys.size() - prevKeys.size();
        return result;
    }

    public static class User {
        int id;
        String name;
        public static int edited = 0;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
            edited++;
        }
    }

    public static class Info {

        int added;
        int changed;
        int deleted;

        public Info() { }

        public int getAdded() {
            return added;
        }

        public void setAdded(int added) {
            this.added = added;
        }

        public int getChanged() {
            return changed;
        }

        public void setChanged(int changed) {
            this.changed = changed;
        }

        public int getDeleted() {
            return deleted;
        }

        public void setDeleted(int deleted) {
            this.deleted = deleted;
        }

        @Override
        public String toString() {
            return "Info{"
                    + "added=" + added
                    + ", changed=" + changed
                    + ", deleted=" + deleted
                    + '}';
        }
    }


}
