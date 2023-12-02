package ait.practiice.car_garage.dao;

import ait.practiice.car_garage.model.Car;

import java.util.HashSet;
import java.util.Set;

public class GarageSetImpl implements Garage {
    private Set<Car> cars;
    private int size;
    private int capacity;

    public GarageSetImpl(int capacity) {
        cars = new HashSet<>();
        this.size = 0;
        this.capacity = capacity;
    }

    @Override
    public boolean addCar(Car car) {
        if (car == null) {
            throw new RuntimeException("null");
        }
        if (capacity == cars.size() || cars.contains(car.getRegNumber())) {
            return false;
        }
        return cars.add(car);
    }

    @Override
    public Car removeCar(String regNumber) {
        Car car = findCarByRegNumber(regNumber);
        cars.remove(car);
        return car;
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {
        return cars.stream()
                .filter(c -> c.getRegNumber().equals(regNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Car[] findCarsByModel(String model) {
        return cars.stream()
                .filter(c -> c.getModel().equals(model))
                .toArray(Car[]::new);
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        return cars.stream()
                .filter(c -> c.getCompany().equals(company))
                .toArray(Car[]::new);
    }

    @Override
    public Car[] findCarsByColor(String color) {
        return cars.stream()
                .filter(c -> c.getColor().equals(color))
                .toArray(Car[]::new);
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        return cars.stream()
                .filter(c -> c.getEngine() >= min && c.getEngine() <= max)
                .toArray(Car[]::new);
    }

    @Override
    public int size() {
        return cars.size();
    }
}
