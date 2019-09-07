package ru.job4j.jdknews;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sorter {

    public List<Student> levelOf(List<Student> students, int bound) {
        List<Student> result = students.stream()
                .flatMap(Stream :: ofNullable)
                .sorted(Comparator.comparingInt(Student::getScore).reversed())

                .takeWhile(v -> v.getScore() >= bound)
                .collect(Collectors.toList());
        return result;
    }
}
