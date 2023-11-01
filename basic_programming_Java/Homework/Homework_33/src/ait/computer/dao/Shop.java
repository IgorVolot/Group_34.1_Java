package ait.computer.dao;/*
 * Copyright (c) 2023.
 *  Igor Volotovskyi
 */

import ait.computer.model.Computer;
import ait.computer.model.Laptop;
import ait.computer.model.SmartPhone;

public interface Shop {
    boolean addComputer(Computer computer);

    int quantity();

    Computer removeComputer(int article);

    Computer findComputer(int article);

    Computer[] findComputerByBrand(String brandName);

    Laptop[] findLaptopByModel(String model);

    Laptop[] findLaptopBySsd(int ssd);

    Laptop[] findLaptopByHours(double min, double max);

    SmartPhone[] findSmartPhoneByImei(long imei);

    SmartPhone[] findSmartPhoneByWeight(double min, double max);
    Computer[] findComputerByPrice(double min, double max);

    boolean setPrice(int article, double price);
}

