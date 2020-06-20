package ru.job4j.tictactoe.players;

import ru.job4j.tictactoe.logic.Logic;
import ru.job4j.tictactoe.models.Mark;

import java.util.Random;

public class ComputerPl extends PlayerImpl {

    private Random random = new Random();

    public ComputerPl(Mark mark, Logic logic) {
        super(mark, logic);
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
