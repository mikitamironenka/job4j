package ru.job4j.lspparkingtask.service;

// Существует парковка для грузовых и легковых машин.
// Количество парковочных мест для каждого типа машин задается на этапе создания парковки.
// Легковая машина может занять только место, предназначенное для легковой машины.
// Грузовая машина может разместиться на месте, предназначенном для грузовых машин,
// либо на N парковочных мест для легковых машин, стоящих рядом.
// Необходимо разработать сервис для учета парковки машин.

import ru.job4j.lspparkingtask.vehicles.Vehicle;

public class ParkingService {

    private int carPlaces;
    private int truckPlaces;

    public ParkingService(int carPlaces, int truckPlaces) {
        this.carPlaces = carPlaces;
        this.truckPlaces = truckPlaces;
    }

    /**
     * Park vehicle
     * @return
     */
    public boolean parkVehicle(Vehicle vehicle) {
        return false;
    }

    public boolean canPark(Vehicle vehicle) {
        return false;
    }

}
