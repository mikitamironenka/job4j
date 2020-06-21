package ru.job4j.tictactoe.field;

import ru.job4j.tictactoe.models.Mark;

public interface FieldActions {

    int getWidth();

    int getHeight();

    void draw();

    void clear();

    void markCellAs(Mark mark, int x, int y);

    Mark getSymbol(int x, int y);

    boolean isEmpty(int x, int y);

    String getGridWithValues();
}
