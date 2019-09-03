package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {

    public static List<Student> students;

    @Before
    public void createStudents() {
        students = new ArrayList<>();
        students = List.of(
                new Student(1),
                new Student(20),
                new Student(51),
                new Student(60),
                new Student(80),
                new Student(90));
    }


    @Test
    public void whenReturnStudentsWithScoreFrom0To50() {
        School school = new School();
        List<Student> result = school.collect(students, School.returnStudentFrom0To50());
        List<Student> checked = new ArrayList<>();
        checked = List.of(
                new Student(1),
                new Student(20));
        assertThat(result, is (checked));
    }

    @Test
    public void whenReturnStudentsWithScoreFrom50To70() {
        School school = new School();
        List<Student> result = school.collect(students, School.returnStudentFrom50To70());
        List<Student> checked = new ArrayList<>();
        checked = List.of(
                new Student(51),
                new Student(60));
        assertThat(result, is (checked));
    }

    @Test
    public void whenReturnStudentsWithScoreFrom70To100() {
        School school = new School();
        List<Student> result = school.collect(students, School.returnStudentFrom70To100());
        List<Student> checked = new ArrayList<>();
        checked = List.of(
                new Student(80),
                new Student(90));
        assertThat(result, is (checked));
    }

}