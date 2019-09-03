package ru.job4j.stream;

//В школе пришло требование разделить 9А класс на три класса.
//У каждого ученика есть общий балл по всем предметам.  int score;
//score - может быть в диапазоне от 0 до 100.
//Учеников нужно поделить на следующие группы.
//10А диапазон балла [70: 100],
//10Б диапазон балла [50: 70);
//10B диапазон балла (0: 50);
//Задание.
//1. Создайте класс Student. В классе Student должно быть одно поле int score;
//2. Создайте класс School c методом List<Student> collect(List<Student> students, Predict<Student> predict);
//3. Создайте класс - тест SchoolTest с тремя методами для получения списка учеников для классов: А, B, C;
//4. В этом задании нужно использовать Stream API. метод filter и метод collect(Collectors.toList())
//import java.util.stream.Collectors;

import java.util.Objects;

public class Student {

    private int score;

    public Student(int score) {
        if (score >= 0 && score <= 100) {
            this.score = score;
        } else {
            System.out.println("Enter the score from 0 to 100");
        }

    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return "Student{"
                + "score=" + score
                +'}';
    }
}
