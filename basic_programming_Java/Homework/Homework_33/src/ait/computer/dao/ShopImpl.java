package ait.computer.dao;
/*
 * Copyright (c) 2023.
 *  Igor Volotovskyi
 */

import ait.computer.model.Computer;
import ait.computer.model.Laptop;
import ait.computer.model.SmartPhone;

public class ShopImpl implements Shop {
    private Computer[] computers;
    private int size;

    public ShopImpl(int quantity) {
        computers = new Computer[quantity];
    }

    @Override
    public boolean addComputer(Computer computer) {
        return false;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public Computer removeComputer(int article) {
        return null;
    }

    @Override
    public Computer findComputer(int article) {
        return null;
    }

    @Override
    public Computer[] findComputerByBrand(String brandName) {
        return new Computer[0];
    }

    @Override
    public Laptop[] findLaptopByModel(String model) {
        return new Laptop[0];
    }

    @Override
    public Laptop[] findLaptopBySsd(int ssd) {
        return new Laptop[0];
    }

    @Override
    public Laptop[] findLaptopByHours(double min, double max) {
        return null;
    }

    @Override
    public SmartPhone[] findSmartPhoneByImei(long imei) {
        return null;
    }

    @Override
    public SmartPhone[] findSmartPhoneByWeight(double min, double max) {
        return null;
    }

    @Override
    public Computer[] findComputerByPrice(double min, double max) {
        return null;
    }

    @Override
    public boolean setPrice(int article, double price) {
        return false;
    }
}
