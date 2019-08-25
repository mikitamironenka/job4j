package ru.job4j.sorting;

import java.util.*;

//В классе SortUser написать метод public Set<User> sort (List<User>),
// который будет возвращать TreeSet пользователей, отсортированных по возрасту в порядке возрастания.
// public List<User> sortNameLength (List<User>) - в этом методе необходимо определить Comparator
// для метода Collections.sort и отсортировать List<User> по длине имени.
//public List<User> sortByAllFields (List<User>) - в этом методе необходимо определить Comparator
// для метода Collections.sort и отсортировать List<User> по обоим полям,
// сначала сортировка по имени в лексикографическом порядке, потом по возрасту.

public class SortUser {

    public Set<User> sort (List<User> list) {
        Set<User> set = new TreeSet<>();
        for (User user : list) {
            set.add(user);
        }
        return set;
    }

    public List<User> sortNameLength(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.valueOf(o1.getName().length())
                        .compareTo(Integer.valueOf(o2.getName().length()));
            }
        });
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                final int result = o1.getName().compareTo(o2.getName());
                return result != 0 ? result : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return list;
    }
}
