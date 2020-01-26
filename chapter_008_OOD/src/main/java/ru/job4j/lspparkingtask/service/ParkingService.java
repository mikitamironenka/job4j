package ru.job4j.lspparkingtask.service;

// Существует парковка для грузовых и легковых машин.
// Количество парковочных мест для каждого типа машин задается на этапе создания парковки.
// Легковая машина может занять только место, предназначенное для легковой машины.
// Грузовая машина может разместиться на месте, предназначенном для грузовых машин,
// либо на N парковочных мест для легковых машин, стоящих рядом.
// Необходимо разработать сервис для учета парковки машин.

import ru.job4j.lspparkingtask.places.Place;
import ru.job4j.lspparkingtask.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingService {

    private int carPlaces;
    private int truckPlaces;

    public ParkingService(int carPlaces, int truckPlaces) {
        this.carPlaces = carPlaces;
        this.truckPlaces = truckPlaces;
    }

    private boolean areThereAnyParkingPlaces() {
        return false;
    }

    private boolean isItATruck(Vehicle vehicle) {
        return false;
    }

    private boolean areThereAnyTruckParkingPlaces() {
        return false;
    }

    private List<Place> areThereNCarPlacesForTruck() {
        List<Place> result = new ArrayList<>();
        return result;
    }

    /**
     * Park vehicle
     * @return
     */
    public boolean parkVehicle() {
        return false;
    }

}
