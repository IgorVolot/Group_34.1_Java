package ait.practice.yachts.model;

import java.util.Objects;

public class Yacht implements Comparable<Yacht> {
    private String name;
    private String manufacture;
    private int yearOfManufacture;
    private double length;
    private String material;
    private double costs;

    public Yacht(String name, String manufacture, int yearOfManufacture, double length, String material, double costs) {
        this.name = name;
        this.manufacture = manufacture;
        this.yearOfManufacture = yearOfManufacture;
        this.length = length;
        this.material = material;
        this.costs = costs;
    }

    public String getName() {
        return name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public double getLength() {
        return length;
    }

    public String getMaterial() {
        return material;
    }

    public double getCosts() {
        return costs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Yacht yacht = (Yacht) o;

        return Objects.equals(name, yacht.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Yacht{");
        sb.append("name='").append(name).append('\'');
        sb.append(", manufacture='").append(manufacture).append('\'');
        sb.append(", yearOfManufacture=").append(yearOfManufacture);
        sb.append(", length=").append(length);
        sb.append(", material='").append(material).append('\'');
        sb.append(", costs=").append(costs);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Yacht o) {
        return getName().compareTo(o.getName());
    }
}
