package ait.computer.model;

/*
 * Copyright (c) 2023.
 *  Igor Volotovskyi
 */

public class SmartPhone extends Computer {
    private double hours;
    private double weight;
    private long imei;

    public SmartPhone(int article, String brandName, String model, double price, double hours, double weight, long imei) {
        super(article, brandName, model, price);
        this.hours = hours;
        this.weight = weight;
        this.imei = imei;
    }

    public double getHours() {
        return hours;
    }

    public double getWeight() {
        return weight;
    }

    public long getImei() {
        return imei;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        SmartPhone that = (SmartPhone) object;

        return imei == that.imei;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (imei ^ (imei >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SmartPhone{");
        sb.append("hours=").append(hours);
        sb.append(", weight=").append(weight);
        sb.append(", imei=").append(imei);
        sb.append('}');
        return sb.toString();
    }
}
