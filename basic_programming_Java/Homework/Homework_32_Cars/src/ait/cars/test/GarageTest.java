package ait.cars.test;

import ait.cars.dao.Garage;
import ait.cars.dao.GarageImpl;
import ait.cars.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {
    private Garage garage;
    Car[] car;

    @BeforeEach
    void setUp() {
        garage = new GarageImpl(7);
        car = new Car[6];
        car[0] = new Car("AA0001", "Company1", "Model2", 3.5, "black");
        car[1] = new Car("AA0002", "Company3", "Model2", 6., "black");
        car[2] = new Car("AA0003", "Company3", "Model3", 4.2, "white");
        car[3] = new Car("AA0004", "Company4", "Model4", 2.4, "grey");
        car[4] = new Car("AA0005", "Company5", "Model5", 8.6, "red");
        car[5] = new Car("AA0006", "Company4", "Model6", 1.8, "white");
        for (int i = 0; i < car.length; i++) {
            garage.addCar(car[i]);
        }
    }

    @Test
    void addCar() {
        assertFalse(garage.addCar(null));
        assertFalse(garage.addCar(car[2]));
        Car cars = new Car("BB001", "Company2", "Model2", 6., "black");
        assertTrue(garage.addCar(cars));
        assertEquals(7, garage.quantity());
        cars = new Car("BB002", "Company2", "Model2", 6., "black");
        assertFalse(garage.addCar(cars));
    }

    @Test
    void removeCar() {
        Car cars = garage.removeCar("AA0002");
        assertEquals(car[1], cars);
        assertEquals(5, garage.quantity());
        assertNull(garage.removeCar("AA0002"));
    }

    @Test
    void findCarByRegNumber() {
        assertEquals(car[4], garage.findCarByRegNumber("AA0005"));
        assertNull(garage.findCarByRegNumber("PTNPNX"));
    }

    @Test
    void quantity() {
        assertEquals(6, garage.quantity());
    }

    @Test
    void findCarsByModel() {
        Car[] expected = {car[0], car[1]};
        Car[] actual = garage.findCarsByModel("Model2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findCarsByCompany() {
        Car[] expected = {car[3], car[5]};
        Car[] actual = garage.findCarsByCompany("Company4");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findCarsByEngine() {
        Car[] expected = {car[0], car[2]};
        Car[] actual = garage.findCarsByEngine(3.0, 6.0);
        assertArrayEquals(expected, actual);
    }

    @Test
    void findCarsByColor() {
        Car[] actual = garage.findCarsByColor("black");
        Car[] expected = {car[0], car[1]};
        assertArrayEquals(expected, actual);
    }
}