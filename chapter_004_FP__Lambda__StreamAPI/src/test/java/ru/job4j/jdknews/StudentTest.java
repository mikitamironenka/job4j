package ru.job4j.jdknews;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void whenLevelOfListOfStudent() {
        Sorter sorter = new Sorter();
        Student st1 = new Student("A A A", 80);
        Student st2 = new Student("C C C", 50);
        Student st3 = new Student("B B B", 49);
        Student st4 = new Student("D D D", 99);
        Student st5 = new Student("F F F", 20);
        List<Student> list = List.of(st1, st2, st3, st4, st5);
        List<Student> checked = List.of(st4, st1);
        List<Student> result = sorter.levelOf(list, 80);
        assertThat(result, is(checked));
    }
}