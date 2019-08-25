package ru.job4j.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTest {

    @Test
    public void whenSortThenReturnSortingSetAscending() {
        User user1 = new User("A", 10);
        User user2 = new User("B", 20);
        User user3 = new User("C", 5);
        User user4 = new User("D", 100);
        List<User> list = new ArrayList<>(List.of(user1, user2, user3, user4));
        SortUser sortUser = new SortUser();
        Set<User> set = sortUser.sort(list);
        Set<User> checked = new TreeSet<>();
        checked.add(user1);
        checked.add(user2);
        checked.add(user3);
        checked.add(user4);
        assertThat(set, is(checked));
    }

}