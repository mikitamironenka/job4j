package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArrayDuplicateTest {

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        String[] input = {"a", "b", "c", "a", "d"};
        String[] excepted = {"a", "b", "c", "d"};
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.removeDuplicates(input);

        assertThat(result, is(excepted));
    }

    @Test
    public void whenAllDuplicatesThenArrayWithOneElement() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        String[] input = {"a", "a", "a", "a", "a"};
        String[] excepted = {"a"};
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.removeDuplicates(input);

        assertThat(result, is(excepted));
    }

}