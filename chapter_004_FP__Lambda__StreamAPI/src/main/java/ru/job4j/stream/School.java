package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static Predicate<Student> returnStudentFrom70To100() {
        return p -> p.getScore() >= 70 && p.getScore() <= 100;
    }

    public static Predicate<Student> returnStudentFrom50To70() {
        return p -> p.getScore() >= 50 && p.getScore() < 70;
    }

    public static Predicate<Student> returnStudentFrom0To50() {
        return p -> p.getScore() >= 0 && p.getScore() < 50;
    }
}
