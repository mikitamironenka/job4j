package ru.job4j.professions.doctors;

import ru.job4j.professions.Profession;

public class Doctor extends Profession {

    private String degree;
    private Diagnose diagnose;
    private Patient patient;

    public String getDegree() {
        return degree;
    }

    public Diagnose getDiagnose() {
        return diagnose;
    }

    public Patient getPatient() {
        return patient;
    }

    public Diagnose heal(Patient patient) {
        Diagnose result = null;
        return result;
    }

}
