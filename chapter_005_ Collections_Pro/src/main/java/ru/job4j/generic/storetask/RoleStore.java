package ru.job4j.generic.storetask;

import ru.job4j.generic.SimpleArray;

public class RoleStore<Role extends Base> extends BaseStore<Role> {

    private int size;

    public RoleStore(int size) {
        super(size);
    }
}
