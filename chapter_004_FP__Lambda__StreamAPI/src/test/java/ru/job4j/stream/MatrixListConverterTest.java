package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixListConverterTest {

    @Test
    public void whenToListThenReturnList() {
        MatrixListConverter converter = new MatrixListConverter();
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        List<Integer> result = converter.toList(matrix);
        List<Integer> checked = List.of(1, 2, 3, 4);
        assertThat(result, is(checked));
    }
}