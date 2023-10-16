package ait.arrays.model;
/*
       Создать массив на 20 элементов, случайные целые числа от -50 до 30.
       Сколько положительных, отрицательных?
       сколько четных? сколько нечетных
       Максимальное, минимальное число?
       Сортировка.
       Есть ли заданное число? - найти его индекс.
 */

import java.util.Arrays;

public class ArrayAppl {
    public static void main(String[] args) {

        int[] numbers = Methods.fillArray(20, -50, 30);
        Methods.printArray(numbers);

        System.out.println();
        int num = Methods.positiveNum(numbers);
        System.out.println("Positive num = " + num);

        num = Methods.negativeNum(numbers);
        System.out.println("Negative num = " + num);

        num = Methods.evenNum(numbers);
        System.out.println("Even num = " + num);

        num = Methods.oddNum(numbers);
        System.out.println("Odd num = " + num);

        num = Methods.indexMaxEl(numbers);
        System.out.println("Index of Max num = " + num);

        num = Methods.maxNum(numbers);
        System.out.println("Max num = " + num);

        num = Methods.indexMinEl(numbers);
        System.out.println("Index of Min num = " + num);

        num = Methods.minNum(numbers);
        System.out.println("Min num = " + num);
        int indexMin = Methods.indexMinEl(numbers);
        System.out.println("Min num = " + numbers[indexMin]);

        int[] sorted = Methods.bubbleSort(numbers);
        Methods.printArray(sorted);

    }
}
