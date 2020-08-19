package ru.job4j.tictactoe;

import ru.job4j.tictactoe.logic.Actions;
import ru.job4j.tictactoe.logic.Logic;
import ru.job4j.tictactoe.models.Status;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class Game {

    private Map<Status, Consumer<Status>> dispatch = new HashMap<>();
    private Actions logic = new Logic();

    public Game() {
        this.init();
    }

    private void init() {
        dispatch.put(Status.NOT_WIN, this::handleNotWin);
        dispatch.put(Status.WIN_X, this::handleWinX);
        dispatch.put(Status.WIN_O, this::handleWinO);
        dispatch.put(Status.NO_TURN, this::handleNoTurn);
    }

    private void handleNoTurn(Status status) {
        System.out.println("No turn!");
        requestForNewGame();
    }

    private void handleNotWin(Status status) {
        System.out.println("Next turn:");
        this.logic.nextTurn();
    }


    private void handleWinX(Status status) {
        System.out.println("Win X player!");
        requestForNewGame();
    }


    private void handleWinO(Status status) {
        System.out.println("Win O player!");
        requestForNewGame();
    }


    private void requestForNewGame() {
        System.out.println("Restart game (y - restart, another - exit)?");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if ("y".equals(answer.toLowerCase())) {
            logic.restart();
        } else {
            logic.end();
        }
    }

    public void start() {
        while (!logic.isEnded()) {
            this.logic.draw();
            Status status = requestStatus();
            this.dispatch.get(status).accept(status);
        }
    }


    private Status requestStatus() {
        Status status = (this.logic.noMove() ? Status.NO_TURN : Status.NOT_WIN);
        status = (logic.isWinO() ? Status.WIN_O : status);
        status = (logic.isWinX() ? Status.WIN_X : status);
        return status;
    }


    public static void main(String[] args) {
        new Game().start();
    }
}
