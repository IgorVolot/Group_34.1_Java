package ait.computer.model;

/*
 * Copyright (c) 2023.
 * Igor Volotovskyi
 */

public class Smartphone extends Laptop {
    private long imei;

    public Smartphone(String cpu, int ram, int ssd, String brand, double hours, double weight, long imei) {
        super(cpu, ram, ssd, brand, hours, weight);
        this.imei = imei;
    }

    public long getImei() {
        return this.imei;
    }

    public String toString() {
        String var10000 = super.toString();
        return var10000 + ", IMEI: " + this.imei;
    }
}
