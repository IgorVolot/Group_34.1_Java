package ait.cars.dao;

import ait.cars.model.Car;

import java.util.Arrays;
import java.util.function.Predicate;

public class GarageImpl implements Garage {
    private Car[] cars;
    private int size;

    public GarageImpl(int capacity) {
        cars = new Car[capacity];
    }

    @Override
    public boolean addCar(Car car) {
        if (car == null || findCarByRegNumber(car.getRegNumber()) != null || size == cars.length)
            return false;
        cars[size++] = car;
        return true;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public Car removeCar(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber().equals(regNumber)) {
                Car removedCar = cars[i];
//                cars[i] = cars[--size];
                System.arraycopy(cars, i + 1, cars, i, size - i - 1);
                cars[--size] = null;
                return removedCar;
            }
        }
        return null;
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber().equals(regNumber)) {
                return cars[i];
            }
        }
        return null;
    }

    @Override
    public Car[] findCarsByModel(String model) {
        return findCarByPredicate(c -> c.getModel().equals(model));
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        return findCarByPredicate(c -> c.getCompany().equals(company));
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        return findCarByPredicate(c -> c.getEngine() >= min && c.getEngine() < max);
    }

    @Override
    public Car[] findCarsByColor(String color) {
        return findCarByPredicate(c -> c.getColor().equals(color));
    }

    private Car[] findCarByPredicate(Predicate<Car> predicate) {
        int count = 0;
        Car[] res = new Car[size];
        for (int i = 0; i < size; i++) {
            if (predicate.test(cars[i])) {
                System.arraycopy(cars, i, res, count++, 1);
            }
        }
        Car[] resCopy = Arrays.copyOf(res, count);
        return resCopy;
    }
}
