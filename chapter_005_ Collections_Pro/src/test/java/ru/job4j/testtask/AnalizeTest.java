package ru.job4j.testtask;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalizeTest {

    @Test
    public void whenCountNewUsers() {
        Analize analize = new Analize();
        Analize.User one = new Analize.User(1, "1");
        Analize.User two = new Analize.User(2, "2");
        Analize.User three = new Analize.User(3, "3");
        Analize.User four = new Analize.User(4, "4");
        Analize.User five = new Analize.User(5, "5");
        Analize.User six = new Analize.User(5, "5");

        List<Analize.User> previous = new ArrayList<>();
        previous.add(one);
        previous.add(two);
        previous.add(three);
        List<Analize.User> current = new ArrayList<>(previous);

        current.add(four);
        current.add(five);
        current.add(six);
        previous.get(0).setName("111");
        int result = analize.newUsers(previous, current);
        Assert.assertThat(result, is(2));
        assertThat(Analize.User.edited, is(2));
    }

    @Test
    public void whenAddEditDeleteUsers() {
        Analize analize = new Analize();
        Analize.User one = new Analize.User(1, "1");
        Analize.User two = new Analize.User(2, "2");
        Analize.User three = new Analize.User(3, "3");
        Analize.User four = new Analize.User(4, "4");
        Analize.User five = new Analize.User(5, "5");
        Analize.User six = new Analize.User(5, "5");

        List<Analize.User> previous = new ArrayList<>();
        previous.add(one);
        previous.add(two);
        previous.add(three);
        List<Analize.User> current = new ArrayList<>(previous);

        current.add(four);
        current.add(five);
        current.add(six);
        previous.get(0).setName("111");

        Analize.Info result = analize.diff(previous, current);
        assertThat(result.getAdded(), is(2));
        assertThat(result.getDeleted(), is(0));
        assertThat(result.getChanged(), is(1));
    }


}