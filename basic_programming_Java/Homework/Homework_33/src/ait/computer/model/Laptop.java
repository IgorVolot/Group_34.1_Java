package ait.computer.model;
/*
 * Copyright (c) 2023.
 *  Igor Volotovskyi
 */

public class Laptop extends Computer {
    private double hours;
    private double weight;


    public Laptop(int article, String brandName, String model, double price, double hours, double weight) {
        super(article, brandName, model, price);
        this.hours = hours;
        this.weight = weight;
    }

    public double getHours() {
        return hours;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Laptop{");
        sb.append("hours=").append(hours);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
