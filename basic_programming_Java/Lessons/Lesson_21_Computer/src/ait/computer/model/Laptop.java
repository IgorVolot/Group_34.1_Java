package ait.computer.model;

public class Laptop extends Computer {
    private double hours;
    private double weight;

    public Laptop(String cpu, int ram, int ssd, String brand, double hours, double weight) {
        super(cpu, ram, ssd, brand);
        this.hours = hours;
        this.weight = weight;
    }

    public Laptop(String cpu, int ram, String brand, double hours, double weight) {
        super(cpu, ram, brand);
        this.hours = hours;
        this.weight = weight;
    }

    public double getHours() {
        return this.hours;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String toString() {
        String var10000 = super.toString();
        return var10000 + ", Hours: " + this.hours + ", Weight: " + this.weight;
    }
}
