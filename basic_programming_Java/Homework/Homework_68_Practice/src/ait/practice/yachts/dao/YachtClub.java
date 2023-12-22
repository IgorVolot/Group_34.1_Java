package ait.practice.yachts.dao;

import ait.practice.yachts.model.Yacht;

import java.util.Set;

public interface YachtClub {
    boolean addYacht(Yacht yacht);

    Yacht findYacht(String name);

    int quantity();

    void printYachts();

    Yacht[] findYachtByMaterial(String material);

    Yacht[] findYachtByPriceGreaterThan(double costs);

    Yacht[] findYachtByManufactureYear(int yearFrom, int yearTo);

    Yacht[] sortYachtByPrice();

    double averagePriceOfYachts(Yacht[] yachts);
}
