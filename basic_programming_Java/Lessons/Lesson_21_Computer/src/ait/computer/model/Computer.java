package ait.computer.model;

public class Computer {
    protected String cpu;
    protected int ram;
    protected int ssd;
    protected String brand;

    public Computer() {
    }

    public Computer(String cpu, int ram, int ssd, String brand) {
        this.cpu = cpu;
        this.ram = ram;
        this.ssd = ssd;
        this.brand = brand;
    }

    public Computer(String cpu, int ram, String brand) {
        this.cpu = cpu;
        this.ram = ram;
        this.brand = brand;
    }

    public String getCpu() {
        return this.cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return this.ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getSsd() {
        return this.ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String toString() {
        String var10000 = this.brand;
        return "Brand: " + var10000 + ", CPU: " + this.cpu + ", RAM: " + this.ram + (this.ssd != 0 ? ", SSD: " + this.ssd : "");
    }
}
