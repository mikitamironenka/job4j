package ru.job4j.synchronization_3.userstorage;

import net.jcip.annotations.ThreadSafe;
import java.util.ArrayList;
import java.util.List;

//1. Создать класс - структуру данных для хранение пользователей UserStorage.
//2. В заголовке класса обозначить аннотацию @ThreadSafe из библиотеки/
//3. Хранилище должно иметь методы boolean add (User user), boolean update(User user), boolean delete(User user).
//4. И особый метод transfer(int fromId, int toId, int amount);
//5. Структура данных должна быть потокобезопасная;
//6. В структуре User Должны быть поля int id, int amount.
//amount - это сумма денег на счете пользователя.
//Пример. использования.
//UserStore stoge = new UserStore();
//stoge.add(new User(1, 100));
//stoge.add(new User(2, 200));
//stoge.transfer(1, 2, 50);

@ThreadSafe
public class UserStorage {

    private final List<User> userList = new ArrayList<>();

    public synchronized boolean add (User user) {
        return this.userList.add(user);
    }

    public synchronized boolean update(User user) {
        boolean result = false;
        for (int i = 0; i < this.userList.size(); i++) {
            if (this.userList.get(i).getId() == user.getId()) {
                this.userList.set(i, user);
                result = true;
            }
        }
        return result;
    }

    public synchronized boolean delete(User user) {
        boolean result = false;
        for (int i = 0; i < this.userList.size(); i++) {
            if (this.userList.get(i).getId() == user.getId()) {
                this.userList.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    public synchronized void transfer(int fromId, int toId, int amount) {

        User userFrom = new User(fromId, findById(fromId).getAmount() - amount);
        update(userFrom);
        User userTo = new User(toId, findById(toId).getAmount() + amount);
        update(userTo);
    }

    public User findById(int id) {
        User result = null;
        for (User item : this.userList) {
            if (item != null && item.getId() == id) {
                result = item;
                break;
            }
        }
        return result;
    }

    public synchronized List<User> getUserList() {
        return this.userList;
    }
}
