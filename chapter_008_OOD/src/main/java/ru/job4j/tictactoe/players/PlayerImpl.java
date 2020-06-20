package ru.job4j.tictactoe.players;

import ru.job4j.tictactoe.logic.Logic;
import ru.job4j.tictactoe.models.Mark;

public abstract class PlayerImpl implements Player {

    protected final Mark mark;
    protected final Logic logic;

    public PlayerImpl(Mark mark, Logic logic) {
        this.mark = mark;
        this.logic = logic;
    }

    public abstract void turn();
}
