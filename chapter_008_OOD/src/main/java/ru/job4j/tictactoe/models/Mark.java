package ru.job4j.tictactoe.models;

public enum Mark {

    X('X'),
    O('O'),
    NULL(' ');

    private char mark;

    Mark(char c) {
        this.mark = c;
    }

    public char getMark() {
        return mark;
    }
}
