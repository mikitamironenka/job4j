package ru.job4j.professions.engineers.programmers;

import ru.job4j.professions.engineers.Engineer;

public class Programmer extends Engineer {

    private String language;
    private String level;

    public Programmer(String language, String level) {
        this.language = language;
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public String getLevel() {
        return level;
    }

    public boolean makeCode() {
        return false;
    }
}
