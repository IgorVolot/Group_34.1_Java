package ait.HWSolution14;

import java.util.Arrays;

/**
 * @author Andrej Reutow
 * created on 22.09.2023
 */
public class Task1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(createArrayOfIntegers1(10)));
        System.out.println(Arrays.toString(createArrayOfIntegers2(10)));
        System.out.println(Arrays.toString(createArrayOfIntegers3(10)));

        // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }

    public static int[] createArrayOfIntegers1(int n) {
        int[] array = new int[n];
        for (int i = 1; i <= n; i++) {
            array[i - 1] += i * 2;
        }

        return array;
    }

    public static int[] createArrayOfIntegers2(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                array[i] += i;
            }
        }

        return array;
    }

    public static int[] createArrayOfIntegers3(int n) {
        int[] array = new int[n];
        for (int i = 1; i < n; i++) {
            if (i % 2 != 0) {
                array[i] += i * 2;
            }
        }

        return array;
    }
}