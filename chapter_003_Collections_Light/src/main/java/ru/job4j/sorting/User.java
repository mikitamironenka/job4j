package ru.job4j.sorting;

import java.util.Objects;

public class User implements Comparable<User> {

    private final String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(User u) {
        return Integer.valueOf(age).compareTo(Integer.valueOf(u.age));
    }



    @Override
    public String toString() {
        return "User{"
                + "name='" + name
                + '\''
                + ", age=" + age
                + '}';
    }
}
