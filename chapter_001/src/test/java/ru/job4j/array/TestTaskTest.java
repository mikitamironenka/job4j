package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestTaskTest {

    @Test
    public void whenMergeArraysThenReturnArray() {
        int[] checked = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] one = new int[]{1, 3, 7};
        int[] two = new int[]{2, 4, 5, 6};
        assertArrayEquals(checked, TestTask.createArray(one, two));
    }

}