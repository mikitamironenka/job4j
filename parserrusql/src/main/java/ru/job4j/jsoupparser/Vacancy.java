package ru.job4j.jsoupparser;

public class Vacancy {

    private String name;
    private String text;
    private String link;

    public Vacancy() { }

    public Vacancy(String name, String text, String link) {
        this.name = name;
        this.text = text;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "vacancy = " + name
                + ", text = " + text
                + ", link= " + link
                ;
    }
}
