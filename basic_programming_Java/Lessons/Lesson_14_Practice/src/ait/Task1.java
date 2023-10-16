package ait;

import java.util.Arrays;

/**
 * @author Andrej Reutow
 * created on 22.09.2023
 * <p>
 * Определить закономерность, согласно которой формируется та или иная числовая последовательность.
 * Написать методы, которые формируют первые N элементов данной последовательности в виде целочисленного массива и выводит элементы массива на экран.
 * <p>
 * Дано:
 * <p>
 * последовательность 1: 2, 4, 6, 8, 10, 12, 14, 16, 18, 20
 * последовательность 2: 0, 0, 2, 0, 4, 0, 6, 0, 8, 0
 * последовательность 3: 0, 2, 0, 6, 0, 10, 0, 14, 0, 18
 * </p>
 */
public class Task1 {

    public static void main(String[] args) {
        int arrayLength = 10; // число N из условия задачи

        int[] array = new int[arrayLength]; // длина массива 10
        // 2, 4, 6, 8, 10, 12, 14, 16, 18, 20

        sequence1(array);

        System.out.println(Arrays.toString(array));
    }

    // 2, 4, 6, 8, 10, 12, 14, 16, 18, 20
    public static void sequence1(int[] array) {
        array[0] = 2;
        for (int i = 0; i < array.length - 1; i++) {
            array[i + 1] = array[i] + 2;
        }

//        for (int i = 1; i < array.length; i++) {
//            array[i] = array[i - 1] + 2;
//        }
    }
}