package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void whenCallPositionThenPositionTheSame() {

        BishopBlack bishopBlack = new BishopBlack(Cell.H3);
        Cell result = bishopBlack.position();
        assertThat(result, is(Cell.H3));
    }

    @Test
    public void whenCallCopyThenPositionTheSame() {

        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        BishopBlack result = (BishopBlack) bishopBlack.copy(Cell.C7);
        assertThat(result.position(), is(Cell.C7));
    }

    @Test
    public void whenCallWayRightUpThenReturnArray() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] checked = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result, is(checked));
    }

    @Test
    public void whenCallWayLeftUpArray() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.C1, Cell.A3);
        Cell[] checked = new Cell[]{Cell.B2, Cell.A3};
        assertThat(result, is(checked));
    }

    @Test
    public void whenCallWayRightDownThenReturnArray() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] result = bishopBlack.way(Cell.D4, Cell.G1);
        Cell[] checked = new Cell[]{Cell.E3, Cell.F2, Cell.G1};
        assertThat(result, is(checked));
    }

    @Test
    public void whenCallWayLeftDownThenReturnArray() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] result = bishopBlack.way(Cell.D4, Cell.A1);
        Cell[] checked = new Cell[]{Cell.C3, Cell.B2, Cell.A1};
        assertThat(result, is(checked));
    }

    @Test
    public void whenDiagonalThenTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        boolean checked = true;
        assertThat(checked, is(bishopBlack.isDiagonal(Cell.C8, Cell.G4)));
    }

    @Test
    public void whenNotDiagonalThenFalse() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        boolean checked = false;
        assertThat(bishopBlack.isDiagonal(Cell.C8, Cell.G5), is(checked));
    }
}