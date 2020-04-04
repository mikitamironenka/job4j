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

    /**
     * Constructor
     */
    public LogicImpl() {
        this.restart();
        players[0] = new HumanPl(Mark.X, this);
        players[1] = new ComputerPl(Mark.O, this);
    }

    /**
     * Check win player with X-marks
     * @return true if X-marks three-in-line
     */
    @Override
    public boolean isWinX() {
        return isWin(Mark.X);
    }

    /**
     * Check win player with O-marks
     * @return true if O-marks three-in-line
     */
    @Override
    public boolean isWinO() {
        return isWin(Mark.O);
    }

    /**
     * restart logic for new game
     */
    @Override
    public void restart() {
        this.currentPlayer = 0;
        this.board.clear();
    }

    /**
     * Make turn
     * @param mark X-mark or O-mark
     * @param x coordinate by x axis (horizontal)
     * @param y coordinate by y axis (vertical)
     * @return true if turn made or false - if not
     */
    @Override
    public boolean turn(Mark mark, int x, int y) {
        boolean result = false;
        if (this.board.isEmpty(x, y)) {
            result = true;
            this.board.markCellAs(mark, x, y);
        }
        return result;
    }

    /**
     * end game
     */
    @Override
    public void end() {
        this.exit = true;
    }

    /**
     * check is game ended
     * @return true if game check as ended
     */
    @Override
    public boolean isEnded() {
        return this.exit;
    }

    /**
     * height
     * @return integer value of height
     */
    @Override
    public int height() {
        return this.board.getHeight();
    }

    /**
     * Check for turn
     * @return true - if no empty cells or false - if empty cells exist.
     */
    @Override
    public boolean noMove() {
        return false;
    }

    /**
     * draw board
     */
    @Override
    public void draw() {
        this.board.draw();
    }

    /**
     * Next turn
     */
    @Override
    public void nextTurn() {
        players[this.currentPlayer].turn();
        this.currentPlayer = (this.currentPlayer + 1) % players.length;
    }

    /**
     * width
     * @return integer value of width
     */
    @Override
    public int width() {
        return this.board.getWidth();
    }

    /**
     * Check wining by mark
     * @param mark checked mark
     * @return true if present three-in-line marks, false - if not three-in-line marks.
     */
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
