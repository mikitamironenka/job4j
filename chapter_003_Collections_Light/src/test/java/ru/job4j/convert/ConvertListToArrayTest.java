package ru.job4j.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertListToArrayTest {

    @Test
    public void when7ElementsThen9() {
        ConvertListToArray list = new ConvertListToArray();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0 ,0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenConvertListArraysThenReturnList() {

        ConvertListToArray converter = new ConvertListToArray();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List<Integer> result = converter.convert(list);
        List<Integer> checked = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        assertThat(result, is(checked));
    }

}