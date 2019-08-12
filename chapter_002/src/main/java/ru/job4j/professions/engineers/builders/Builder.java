package ru.job4j.professions.engineers.builders;

import ru.job4j.professions.engineers.Engineer;

public class Builder extends Engineer {

    private Hammer hammer;
    private int nail;

    public Hammer getHammer() {
        return hammer;
    }

    public int getNail() {
        return nail;
    }

    public void hammerNail(Hammer hammer, int nail){}
}
