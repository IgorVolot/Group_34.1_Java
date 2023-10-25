package ait.wardrobe.test;
/*
 * Copyright (c) 2023.
 * Igor Volotovskyi
 */

import ait.wardrobe.model.Wardrobe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class WardrobeTest {

    private static final int SIZE = 10;
    private static final int MAX = 5;
    private static final int MIN = 1;
    static Random random = new Random();
    Wardrobe[] wardrobes;


    @BeforeEach
    void setUp() {
        wardrobes = new Wardrobe[SIZE];
        for (int i = 0; i < wardrobes.length; i++) {
            double height = MIN + random.nextInt(MAX);
            double width = MIN + random.nextInt(MAX);
            double depth = MIN + random.nextInt(MAX);
            wardrobes[i] = new Wardrobe(height, width, depth);
        }
    }

    private void printArray(Object[] arr, String title) {
        System.out.println("======= " + title + " =========");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    void testNaturalOrderWardrobe() {
        printArray(wardrobes, "Test Comparable before sort");
        Arrays.sort(wardrobes);
        printArray(wardrobes, "Test Comparable after sort");
        int index = Arrays.binarySearch(wardrobes, new Wardrobe(2.5, 4, 1));
        System.out.println("index = " + index);
    }

    @Test
    void testAreaComparator() {
        printArray(wardrobes, "Test Area Comparator before sort");
        Comparator<Wardrobe> comparator = (w1, w2) -> Double.compare(w1.area(), w2.area());
        Arrays.sort(wardrobes, comparator);
        printArray(wardrobes, "Test Area Comparator after sort");
        int index = Arrays.binarySearch(wardrobes, new Wardrobe(2, 4, 1), comparator);
        System.out.println("index = " + index);
    }

    @Test
    void testVolumeComparator() {
        printArray(wardrobes, "Test Volume Comparator before sort");
        Comparator<Wardrobe> comparator = (w1, w2) -> Double.compare(w1.volume(), w2.volume());
        Arrays.sort(wardrobes, comparator);
        printArray(wardrobes, "Test Volume Comparator after sort");
        int index = Arrays.binarySearch(wardrobes, new Wardrobe(2, 4, 1), comparator);
        System.out.println("index = " + index);
    }

    @Test
    void testHeightVolumeComparator() {
        printArray(wardrobes, "Test Height Volume Comparator before sort");
        Comparator<Wardrobe> comparator = (w1, w2) -> {
//            int res = Double.compare(w1.getHeight(), w2.getHeight());
            int res = w1.compareTo(w2);
            return res != 0 ? res : Double.compare(w1.volume(), w2.volume());
        };
        Arrays.sort(wardrobes, comparator);
        printArray(wardrobes, "Test Height Volume Comparator after sort");
        int index = Arrays.binarySearch(wardrobes, new Wardrobe(2, 4, 1), comparator);
        System.out.println("index = " + index);
    }
}