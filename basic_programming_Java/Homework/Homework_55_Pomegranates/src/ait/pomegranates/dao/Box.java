package ait.pomegranates.dao;

import ait.pomegranates.model.Pomegranate;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Box {
    private static final int MIN = 100;
    private static final int MAX = 200;
    private String boxName;
    private List<Pomegranate> granates;

    Stream<Integer> boxNumbers = getBoxRandomNumbers(MIN, MAX);

    int totalBoxes = totalBoxes(boxNumbers);

    public Box(String boxName, List<Pomegranate> granates) {
        this.boxName = boxName;
        this.granates = granates;
    }

//    boxNumberspublic Box(String boxName) {
//        this.boxName = boxName;
//    }

    public String getName() {
        return boxName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Box{");
        sb.append("name='").append(boxName).append('\'');
        sb.append(", granates=").append(granates);
        sb.append('}');
        return sb.toString();
    }
    private int totalBoxes(Stream<Integer> stream){
        return stream.mapToInt(Integer::intValue).sum();
    }

    private Stream<Integer> getBoxRandomNumbers(int min, int max) {
        return new Random()
                .ints(min, max)
                .boxed();
    }
}
