package ait.cars.model;

import java.util.Objects;

public class Car {
    private String regNumber;
    private String company;
    private String model;
    private double engine;
    private String color;

    public Car(String regNumber, String company, String model, double engine, String color) {
        this.regNumber = regNumber;
        this.company = company;
        this.model = model;
        this.engine = engine;
        this.color = color;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getCompany() {
        return company;
    }

    public String getModel() {
        return model;
    }

    public double getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Car car = (Car) object;

        return Objects.equals(regNumber, car.regNumber);
    }

    @Override
    public int hashCode() {
        return regNumber != null ? regNumber.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car ");
        sb.append("regNumber='").append(regNumber).append('\'');
        sb.append(", company='").append(company).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", engine=").append(engine);
        sb.append(", color='").append(color);
        return sb.toString();
    }
}
