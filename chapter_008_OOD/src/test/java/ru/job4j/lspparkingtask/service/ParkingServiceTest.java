package ru.job4j.lspparkingtask.service;

import jdk.jfr.Description;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.lspparkingtask.vehicles.Car;
import ru.job4j.lspparkingtask.vehicles.Truck;

import static org.junit.Assert.*;

public class ParkingServiceTest {



    @Test
    public void whenCarCanParkThenShouldReturnTrue() {
        ParkingService parkingService = new ParkingService(10, 0);
        Car car = new Car();

        assertTrue(parkingService.canPark(car));
    }

    @Test
    public void whenTruckCanParkThenShouldReturnTrue() {
        ParkingService parkingService = new ParkingService(10, 1);
        Truck truck = new Truck();

        assertTrue(parkingService.canPark(truck));
    }

    @Test
    public void whenTruckCanParkOnCarPlacesThenShouldReturnTrue() {
        ParkingService parkingService = new ParkingService(10, 0);
        Truck truck = new Truck();

        assertTrue(parkingService.canPark(truck));
    }

    @Test
    public void whenCarParkThenShouldReturnTrue() {
        ParkingService parkingService = new ParkingService(10, 1);
        Car car = new Car();

        assertTrue(parkingService.parkVehicle(car));
    }

    @Test
    public void whenTruckParkThenShouldReturnTrue() {
        ParkingService parkingService = new ParkingService(10, 1);
        Truck truck = new Truck();

        assertTrue(parkingService.parkVehicle(truck));
    }

    @Test
    public void whenTruckCantParkThenShouldReturnFalse() {
        ParkingService parkingService = new ParkingService(10, 0);
        Truck truck = new Truck();

        assertFalse(parkingService.parkVehicle(truck));
    }

    @Description("Если легковая машина будет парковаться на место грузовой, то метод должен вернуть false.")
    @Test
    public void whenCarParkOnTruckPlaceThenShouldReturnFalse() {
        ParkingService parkingService = new ParkingService(10, 1);
        Car car = new Car();

        assertFalse(parkingService.parkVehicle(car));
    }

    @Test
    public void whenNoFreeParkingPlacesForTruckThenFalse() {
        ParkingService parkingService = new ParkingService(10, 1);
        Truck truck = new Truck();

        assertFalse(parkingService.parkVehicle(truck));
    }

    @Test
    public void whenNoFreeParkingPlacesForCarThenFalse() {
        ParkingService parkingService = new ParkingService(10, 1);
        Car car = new Car();

        assertFalse(parkingService.parkVehicle(car));
    }

}