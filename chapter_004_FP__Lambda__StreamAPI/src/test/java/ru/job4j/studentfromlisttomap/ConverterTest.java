package ru.job4j.studentfromlisttomap;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConverterTest {

    @Test
    public void whenConvertListToMapThenReturnMap() {
        Converter converter = new Converter();
        Student st1 = new Student("Aaa", "Aaaaaa", 75);
        Student st2 = new Student("Bbb", "Bbbbbb", 32);
        Student st3 = new Student("Ccc", "Cccccc", 80);
        Student st4 = new Student("Ccc", "Cccccc", 80);
        List<Student> list = List.of(st1, st2, st3, st4);
        Map<String, Student> result = converter.convertListToMap(list);
        Map<String, Student> checked = Map.of(st1.getSurname(), st1, st2.getSurname(), st2, st3.getSurname(), st3);
        assertThat(result, is(checked));
    }
}