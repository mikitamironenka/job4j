package ru.job4j.jsoupparser;

import java.util.Date;

public class Vacancy {

    private String text;
    private String link;
    private Date date;
    private String stringDate;

    public Vacancy() { }

    public Vacancy(String text, String link, Date date) {
        this.text = text;
        this.link = link;
        this.date = date;
    }

    public Vacancy(String text, String link, String stringDate) {
        this.text = text;
        this.link = link;
        this.stringDate = stringDate;
    }

    public String getStringDate() {
        return stringDate;
    }

    public void setStringDate(String stringDate) {
        this.stringDate = stringDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Vacancy{"
                + "vacancy='" + text
                + ", link='" + link
                + ", date=" + stringDate
                + '}';
    }
}
