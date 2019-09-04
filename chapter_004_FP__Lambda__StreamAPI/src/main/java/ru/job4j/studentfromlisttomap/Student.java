package ru.job4j.studentfromlisttomap;

import java.util.Objects;

public class Student {

    private int score;
    private String name;
    private String surname;

    public Student(String name, String surname, int score) {
        if (score >= 0 && score <= 100) {
            this.score = score;
        } else {
            System.out.println("Enter the score from 0 to 100");
        }
        this.name = name;
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, name, surname);
    }

    @Override
    public String toString() {
        return "Student{"
                + "score= " + score
                + "name= " + name
                + "surname= " + surname
                +'}';
    }
}
