package ru.job4j.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//В классе SortUser написать метод public Set<User> sort (List<User>),
// который будет возвращать TreeSet пользователей, отсортированных по возрасту в порядке возрастания.

public class SortUser {

    public Set<User> sort (List<User> list) {
        Set<User> set = new TreeSet<>();
        for (User user : list) {
            set.add(user);
        }
        return set;
    }

    public static void main(String[] args) {

        User user1 = new User("D", 10);
        User user2 = new User("A", 20);
        User user3 = new User("B", 5);
        User user4 = new User("C", 100);
        List<User> list = new ArrayList<>(List.of(user1, user2, user3, user4));
        SortUser sortUser = new SortUser();
        Set<User> set = sortUser.sort(list);
        Set<User> set2 = sortUser.sort(list);
        set2.add(user1);
        set2.add(user2);
        set2.add(user3);
        set2.add(user4);
        for (User user : set2) {
            System.out.println(user.toString());
        }
        for (User user : set) {
            System.out.println(user.toString());
        }
    }
}
