package ait.computer.model;

/*
 * Copyright (c) 2023.
 *  Igor Volotovskyi
 */

import ait.computer.dao.ShopImpl;

public class Computer extends ShopImpl {
    private String cpu;
    private int ram;
    private int ssd;

    public Computer(int article, String brandName, String model, double price) {
        super(article, brandName, model, price);
    }

    public String getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public int getSsd() {
        return ssd;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Computer{");
        sb.append("cpu='").append(cpu).append('\'');
        sb.append(", ram=").append(ram);
        sb.append(", ssd=").append(ssd);
        sb.append('}');
        return sb.toString();
    }
}
