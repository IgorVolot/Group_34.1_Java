package ait.practice.yachts.dao;

import ait.practice.yachts.model.Yacht;

import java.util.*;
import java.util.function.Predicate;

public class YachtClubImpl implements YachtClub{
    private TreeSet<Yacht> yachts;
    private int capacity;

    public YachtClubImpl(int capacity) {
        this.capacity = capacity;
        this.yachts = new TreeSet<>();
    }

    @Override
    public boolean addYacht(Yacht yacht) {
        if (yacht == null){
            throw new RuntimeException("Yacht cannot be null");
        }
        if (capacity == yachts.size()){
            return false;
        }
        return yachts.add(yacht);
    }

    @Override
    public Yacht findYacht(String name) {
        return yachts.stream()
                .filter(yacht -> yacht.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public int quantity() {
        return yachts.size();
    }

    @Override
    public void printYachts() {
        yachts.forEach(System.out::println);
    }

    @Override
    public Yacht[] findYachtByMaterial(String material) {
        return yachts.stream()
                .filter(yacht -> yacht.getMaterial().equalsIgnoreCase(material))
                .toArray(Yacht[]::new);
    }

    @Override
    public Yacht[] findYachtByPriceGreaterThan(double costs) {
        return yachts.stream()
                .filter(yacht -> yacht.getCosts() > costs)
                .toArray(Yacht[]::new);
    }

    @Override
    public Yacht[] findYachtByManufactureYear(int yearFrom, int yearTo) {
        return yachts.stream()
                .filter(yacht -> yacht.getYearOfManufacture() >= yearFrom && yacht.getYearOfManufacture() < yearTo)
                .toArray(Yacht[]::new);
    }

    @Override
    public Yacht[] sortYachtByPrice() {
        return yachts.stream()
                .sorted(Comparator.comparing(Yacht::getCosts))
                .toArray(Yacht[]::new);

    }

    @Override
    public double averagePriceOfYachts(Yacht[] yachts) {
        return Arrays.stream(yachts)
                .mapToDouble(Yacht::getCosts)
                .summaryStatistics()
                .getAverage();
    }
}
