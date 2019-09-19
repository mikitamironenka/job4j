package ru.job4j.generic.storetask;

import ru.job4j.generic.SimpleArray;

public class UserStore<User extends Base> extends BaseStore<User> {

    private int size;

    public UserStore(int size) {
        super(size);
    }
}
