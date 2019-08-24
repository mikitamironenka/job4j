package ru.job4j.chess.firuges;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CellTest {

    @Test
    public void whenGetCellThenReturnCell() {

        Cell result = Cell.getCell(0, 0);
        Cell checked = Cell.A1;
        assertThat(checked, is(result));
    }

}