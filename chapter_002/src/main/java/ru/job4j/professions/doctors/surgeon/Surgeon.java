package ru.job4j.professions.doctors.surgeon;

import ru.job4j.professions.doctors.Doctor;
import ru.job4j.professions.doctors.Patient;

public class Surgeon extends Doctor {

    private Scalpel scalpel;


    public boolean makeOperation(Scalpel scalpel, Patient patient) {
        return false;
    }
}
