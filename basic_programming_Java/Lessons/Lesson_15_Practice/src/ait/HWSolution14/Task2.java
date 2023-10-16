package ait.HWSolution14;

import java.util.Arrays;

/**
 * @author Andrej Reutow
 * created on 24.09.2023
 */
public class Task2 {

    public static void main(String[] args) {
        int[] source = {10, 4, 2, 3, 1};

        int elementN = 10;

        int minElementIndex = findMinElementIndex(source);
        int elementIndex = findElementIndex(source, elementN);

        if (elementIndex >= 0) {
            source[elementIndex] = source[minElementIndex];
        } else {
            System.out.println("Element " + elementN + " not found");
        }

        System.out.println(Arrays.toString(source));
    }

    private static int findElementIndex(int[] source, int element) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] == element) {
                return i;
            }
        }

        return -1;
    }

    private static int findMinElementIndex(int[] source) {
        int minElementIndex = 0;
        int min = source[minElementIndex];
        for (int i = 0; i < source.length; i++) {
            if (source[i] < min) {
                min = source[i];
                minElementIndex = i;
            }
        }

        return minElementIndex;
    }


}