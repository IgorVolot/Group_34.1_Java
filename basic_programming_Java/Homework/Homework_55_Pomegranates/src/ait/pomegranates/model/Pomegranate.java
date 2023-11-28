package ait.pomegranates.model;

import ait.pomegranates.dao.Box;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Pomegranate extends Box {
    private static final int MIN = 10;
    private static final int MAX = 20;
    private List<Seed> seeds;
    Stream<Integer> pomeNumbers = getPomeRandNums(MIN, MAX);
    int totalGranatesInBox = totalGranatesInBox(pomeNumbers);

    public Pomegranate(String boxName, List<Pomegranate> granates, List<Seed> seeds) {
        super(boxName, granates);
        this.seeds = seeds;
    }
//    public Pomegranate(String boxName) {
//        super(boxName);
//    }

    private int totalGranatesInBox(Stream<Integer> stream){
        return stream.mapToInt(Integer::intValue).sum();
    }

    private Stream<Integer> getPomeRandNums(int min, int max) {
        return new Random()
                .ints(min, max)
                .boxed();
    }
}
