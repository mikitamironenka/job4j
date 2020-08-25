package ru.job4j.synchronization_3.userstorage;

import org.junit.Test;
import ru.job4j.synchronization_3.threadsafelist.SingleLockList;

import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserStorageTest {

    @Test
    public void whenAddTwoUserThenReturnTwo() throws InterruptedException {
        User userOne = new User(1, 50);
        User userTwo = new User(2, 100);

        UserStorage userStorage = new UserStorage();

        Thread first = new Thread(() -> userStorage.add(userOne));
        Thread second = new Thread(() -> userStorage.add(userTwo));
        first.start();
        second.start();
        first.join();
        second.join();
        assertThat(userStorage.getUserList().size(), is(2));
    }

    @Test
    public void whenRemoveUserThenSizeOne() {
        User userOne = new User(1, 50);
        User userTwo = new User(2, 100);

        UserStorage userStorage = new UserStorage();
        userStorage.add(userOne);
        userStorage.add(userTwo);
        assertTrue(userStorage.delete(userOne));
        assertThat(userStorage.getUserList().size(), is(1));
    }

    @Test
    public void whenUpdateUserThenAmountIsDiff() {
        User userOne = new User(1, 50);
        User userTwo = new User(2, 100);
        User userTwoNew = new User(2, 150);

        UserStorage userStorage = new UserStorage();
        userStorage.add(userOne);
        userStorage.add(userTwo);
        userStorage.update(userTwoNew);

        assertThat(userStorage.getUserList().get(1).getAmount(), is(150));
        assertThat(userStorage.getUserList().size(), is(2));
    }

    @Test
    public void whenTransferThenAmountIsDiff() {
        User userOne = new User(1, 50);
        User userTwo = new User(2, 100);

        UserStorage userStorage = new UserStorage();
        userStorage.add(userOne);
        userStorage.add(userTwo);
        userStorage.transfer(1, 2, 50);

        assertThat(userStorage.getUserList().get(0).getAmount(), is(0));
        assertThat(userStorage.getUserList().get(1).getAmount(), is(150));
    }

}