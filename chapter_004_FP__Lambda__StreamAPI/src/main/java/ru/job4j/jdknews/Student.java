package ru.job4j.jdknews;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Необходимо реализовать метод List<Student> levelOf(List<Student> students, int bound);
//Метод должен вернуть список студентов у которых балл аттестата больше bound.
//Во входящем списки могут быть null элементы.
//Порядок действий.
// - Отсортировать список.
// - Используя метод flatMap убрать null
// - Используя метод takeWhile получить нужный поток.
// - Сохранить поток в List.

public class Student implements Comparator<Student> {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }



    @Override
    public int compare(Student o1, Student o2) {
        return o1.score - o2.score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public String toString() {
        return "Student{"
                + "score= " + score
                + "name= " + name
                +'}';
    }

}
