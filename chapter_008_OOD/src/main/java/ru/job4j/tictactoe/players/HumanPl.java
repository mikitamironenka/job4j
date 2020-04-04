package ru.job4j.tictactoe.players;

import ru.job4j.tictactoe.logic.Logic;
import ru.job4j.tictactoe.models.Mark;

import java.util.Scanner;

public class HumanPl extends PlayerImpl {

    /**
     * Constructor
     * @param mark player mark
     * @param logic Logic
     */
    public HumanPl(Mark mark, Logic logic) {
        super(mark, logic);
    }

    /**
     * Player turn
     */
    @Override
    public void turn() {
        boolean makeTurn = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Input coordinates your turn (separated by spaces):");
            String answer = scanner.nextLine();
            if (answer.matches("\\d\\s\\d")) {
                String[] parts = answer.split("\\s", 2);
                makeTurn = this.logic.turn(mark, Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));
            }
        } while (!makeTurn);
    }
}
