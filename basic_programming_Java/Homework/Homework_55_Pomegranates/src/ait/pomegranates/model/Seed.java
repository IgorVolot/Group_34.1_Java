package ait.pomegranates.model;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Seed extends Pomegranate{
    private static final int MIN = 400;
    private static final int MAX = 700;
    private double weight;

    Stream<Integer> seedsNumbers = getSeedsRandNums(MIN, MAX);

    int totalSeedsInGranate = totalSeedsInPome(seedsNumbers);

    public Seed(String boxName, List<Pomegranate> granates, List<Seed> seeds, double weight) {
        super(boxName, granates, seeds);
        this.weight = weight;
    }
    //    public Seed(String boxName) {
//        super(boxName);
//    }

    public double getWeight() {
        return weight;
    }

    private int totalSeedsInPome(Stream<Integer> stream){
        return stream.mapToInt(Integer::intValue).sum();
    }

    private Stream<Integer> getSeedsRandNums(int min, int max) {
        return new Random()
                .ints(min, max)
                .boxed();
    }
}
