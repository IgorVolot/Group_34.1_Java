package ait.pomegranates.model;

import ait.pomegranates.dao.Box;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class PomegranateAppl {

    public static void main(String[] args) {

        List<Seed> seeds = getSeeds();

        printTotalSeedsInAllBoxes(seeds);
        printMaxSeedsInEachBox(seeds);
        printBoxNameWithMaxSeeds(seeds);
    }

    private static List<Seed> getSeeds() {
        return List.of(
                new Seed("box1", List.of(), List.of(), 10.8),
                new Seed("box2", List.of(), List.of(), 9.9),
                new Seed("box3", List.of(), List.of(), 11.6),
                new Seed("box4", List.of(), List.of(), 9.8),
                new Seed("box5", List.of(), List.of(), 12.2)
        );
    }

    private static void printTotalSeedsInAllBoxes(List<Seed> seeds) {
        Long seedInPomes = seeds.stream()
                .map(s -> s.seedsNumbers)
                .count();
        Long pomesInBox = seeds.stream()
                .map(p -> p.pomeNumbers)
                .count();
        Long totalBoxes = seeds.stream()
                .map(b -> b.getWeight() / 2)
                .count();
        System.out.println("Total seeds in each box = " + seedInPomes * pomesInBox * totalBoxes);

    }

    private static void printMaxSeedsInEachBox(List<Seed> seeds) {
        Long seedInPome = seeds.stream()
                .map(s -> s.seedsNumbers)
                .count();
        Long pomeInBox = seeds.stream()
                .map(p -> p.pomeNumbers)
                .count();
        System.out.println("Total seeds in each box = " + seedInPome * pomeInBox);
    }

    private static void printBoxNameWithMaxSeeds(List<Seed> seeds) {
        Iterable<String> boxNames = seeds.stream()
                .map(b -> b.getName())
                .collect(Collectors.toList());
        StreamSupport.stream(boxNames.spliterator(), false);

        Map<String, Long> boxName = seeds.stream()
                .map(Box::getName)
                .flatMap(String::lines)
                .collect(Collectors.groupingBy(b -> b, Collectors.counting()));

        Long max = boxName.values().stream()
                .max(Long::compare).orElse(0l);

        boxName.entrySet().stream()
                .filter(s -> max.equals(s.getValue()))
                .forEach(b -> System.out.println(b.getKey()));

    }
}
