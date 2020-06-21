package ru.job4j.tictactoe.players;

import ru.job4j.tictactoe.logic.Actions;
import ru.job4j.tictactoe.models.Mark;

import java.util.Random;

public class ComputerPl implements Turn {

    private Random random = new Random();
    private final Mark mark;
    private final Actions logic;

    public ComputerPl(Mark mark, Actions logic) {
        this.mark = mark;
        this.logic = logic;
    }

    @Override
    public void turn() {
        boolean makeTurn = false;
        int x, y;
        System.out.print("Computer turn: ");
        do {
            int turn = random.nextInt(this.logic.height() * this.logic.width());
            x = turn % this.logic.width();
            y = turn / this.logic.height();
            makeTurn = this.logic.turn(mark, x, y);
        } while (!makeTurn);
        System.out.printf("%s %s%s", x, y, System.lineSeparator());
    }
}
