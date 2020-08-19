package ru.job4j.tictactoe.logic;

import ru.job4j.tictactoe.models.Mark;

public interface Actions {

    boolean isWinX();

    boolean isWinO();

    boolean turn(Mark mark, int x, int y);

    void restart();

    void end();

    boolean isEnded();

    int width();

    int height();

    boolean noMove();

    void draw();

    void nextTurn();
}
