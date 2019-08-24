package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;
import ru.job4j.chess.firuges.white.BishopWhite;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void whenMoveThenReturnTrue() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean result = logic.move(Cell.C1, Cell.G5);
        assertThat(result, is(true));
    }

    @Test
    public void whenMoveThenReturnFalse() {
        Logic logic = new Logic();
        logic.add(new BishopWhite(Cell.D2));
        logic.add(new PawnBlack(Cell.E3));
        logic.add(new BishopBlack(Cell.C1));
        boolean result = logic.move(Cell.C1, Cell.G5);
        assertThat(result, is(false));
    }

}