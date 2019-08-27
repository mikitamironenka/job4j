package ru.job4j.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserConvertTest {

    @Test
    public void whenConvertListThenMap() {
        User userOne = new User(1, "Max", "NY");
        User userTwo = new User(2, "Mix", "LA");
        User userThree = new User(3, "Nik", "SF");
        List<User> list = new ArrayList<>(List.of(userOne, userTwo, userThree));
        UserConvert userConvert = new UserConvert();
        HashMap<Integer, User> result = userConvert.process(list);
        HashMap<Integer, User> checked = new HashMap<>();
        checked.put(1, userOne);
        checked.put(2, userTwo);
        checked.put(3, userThree);
        assertThat(result, is(checked));
    }

}