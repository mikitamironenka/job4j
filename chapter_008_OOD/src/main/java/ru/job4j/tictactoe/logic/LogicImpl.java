package ru.job4j.tictactoe.logic;

import ru.job4j.tictactoe.field.Field;
import ru.job4j.tictactoe.field.FieldImpl;
import ru.job4j.tictactoe.field.SingleSymbols;
import ru.job4j.tictactoe.models.Mark;
import ru.job4j.tictactoe.players.ComputerPl;
import ru.job4j.tictactoe.players.HumanPl;
import ru.job4j.tictactoe.players.Player;

public class LogicImpl implements Logic {

    private Field board = new FieldImpl(new SingleSymbols());
    private boolean exit = false;
    private Player[] players = new Player[2];
    private int currentPlayer;

    public LogicImpl() {
        this.restart();
        players[0] = new HumanPl(Mark.X, this);
        players[1] = new ComputerPl(Mark.O, this);
    }

    @Override
    public boolean isWinX() {
        return isWin(Mark.X);
    }


    @Override
    public boolean isWinO() {
        return isWin(Mark.O);
    }

    @Override
    public void restart() {
        this.currentPlayer = 0;
        this.board.clear();
    }

    @Override
    public boolean turn(Mark mark, int x, int y) {
        boolean result = false;
        if (this.board.isEmpty(x, y)) {
            result = true;
            this.board.markCellAs(mark, x, y);
        }
        return result;
    }

    @Override
    public void end() {
        this.exit = true;
    }

    @Override
    public boolean isEnded() {
        return this.exit;
    }

    @Override
    public int height() {
        return this.board.getHeight();
    }

    @Override
    public boolean noMove() {
        return false;
    }

    @Override
    public void draw() {
        this.board.draw();
    }


    @Override
    public void nextTurn() {
        players[this.currentPlayer].turn();
        this.currentPlayer = (this.currentPlayer + 1) % players.length;
    }

    @Override
    public int width() {
        return this.board.getWidth();
    }

    private boolean isWin(Mark mark) {
        boolean result = false;
        for (int i = 0; i < this.board.getWidth(); i++) {
            result = result
                | (this.board.getSymbol(i, 0) == mark
                && this.board.getSymbol(i, 1) == mark
                && this.board.getSymbol(i, 2) == mark)
                | (this.board.getSymbol(0, i) == mark
                && this.board.getSymbol(1, i) == mark
                && this.board.getSymbol(2, i) == mark);
        }
        result = (
            result
                | (this.board.getSymbol(0, 0) == mark
                && this.board.getSymbol(1, 1) == mark
                && this.board.getSymbol(2, 2) == mark)
                | (this.board.getSymbol(0, 2) == mark
                && this.board.getSymbol(1, 1) == mark
                && this.board.getSymbol(2, 0) == mark)
        );
        return result;
    }
}
