package ru.job4j.professions.doctors;

public class Patient {

    private String name;
    private String surname;

    public Patient(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
