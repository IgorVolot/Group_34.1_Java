package ait.pomegranate;

import ait.pomegranate.model.Box;
import ait.pomegranate.model.Pomegranate;
import ait.pomegranate.model.Seed;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PomegranateAppl {
    private static final int MIN_BOX = 100;
    private static final int MAX_BOX = 200;
    private static final int MIN_POMEGRANATE = 10;
    private static final int MAX_POMEGRANATE = 20;
    private static final int MIN_SEEDS = 400;
    private static final int MAX_SEEDS = 700;
    private static Random random = new Random();

    public static void main(String[] args) {
        List<Box> boxes = getRandomBoxes();

        int totalSeeds = boxes.stream()
                .mapToInt(Box::countSeeds)
                .sum();
        System.out.println("Total seeds = " + totalSeeds);

        int maxSeedsInBox = boxes.stream()
                .mapToInt(b -> b.countSeeds())
                .max()
                .orElse(0);
        boxes.stream()
                .filter(b -> b.countSeeds() == maxSeedsInBox)
                .forEach(b -> System.out.println("Max seeds in " + b.getName() + " => " + b.countSeeds()));
    }

    private static List<Box> getRandomBoxes() {
        return IntStream.range(0, MIN_BOX + random.nextInt(MAX_BOX - MIN_BOX + 1))
                .mapToObj(b -> (Box) getBox(b))
                .collect(Collectors.toList());

    }

    private static Box getBox(int b) {
        List<Pomegranate> pomegranates = getRandomPomes();
        Box result = new Box("Box # " + b, pomegranates);
        return result;
    }

    private static List<Pomegranate> getRandomPomes() {
        return IntStream.range(0, MIN_POMEGRANATE + random.nextInt(MAX_POMEGRANATE - MIN_POMEGRANATE + 1))
                .mapToObj(g -> (Pomegranate) getGranate(g))
                .collect(Collectors.toList());


    }

    private static Pomegranate getGranate(int g) {
        List<Seed> seeds = getRandomSeeds();
        Pomegranate result = new Pomegranate(seeds);
        return result;
    }

    private static List<Seed> getRandomSeeds() {
        return random.ints(MIN_SEEDS + random.nextInt(MAX_SEEDS - MIN_SEEDS + 1), 2, 5)
                .mapToObj(Seed::new)
                .collect(Collectors.toList());
    }

//    private static List<Seed> getRandomSeeds() {
//        return IntStream.range(0, MIN_SEEDS + random.nextInt(MAX_SEEDS - MIN_SEEDS + 1))
//                .mapToObj(Seed::new)
//                .collect(Collectors.toList());
//    }
}
