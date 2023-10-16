package ait;

import java.util.Arrays;

/**
 * @author Andrej Reutow
 * created on 25.09.2023
 */
public class Task2 {
//Задача 2: Клонирование массива с использованием циклов for и while
//Описание
//Ваша задача создать копию исходного массива, используя циклы for и while.
//
//Дано
//Массив целых чисел.
//Вывод
//Новый массив, являющийся копией исходного массива.
//Примеры
//Пример 1
//Дано: [1, 2, 3, 4, 5]
//Вывод: [1, 2, 3, 4, 5]

    public static void main(String[] args) {
        int[] arrayToCopy = new int[10];

        fillArray(arrayToCopy, 88);

        System.out.println(Arrays.toString(arrayToCopy));


//        int[] arrayCopy = copyArray(arrayToCopy);
//
//        printArray(arrayToCopy);
//        printArray(arrayCopy);
////        System.out.println(Arrays.toString(arrayToCopy));
////        System.out.println(Arrays.toString(arrayCopy));
//
//        int[] arrayCopy2 = copyArrayTo(arrayToCopy, 3);
//        printArray(arrayCopy2);

        int[] arrayCopy3 = copyArrayFromTo(arrayToCopy, 2, 5);
        printArray(arrayCopy3);
    }

    public static void fillArray(int[] arrayToFill, int from) {
        for (int i = 0; i < arrayToFill.length; i++) {
            arrayToFill[i] = from++;
        }
//          если from = 88
//        arrayToFill[0] = 88;
//        arrayToFill[1] = 89;
//        arrayToFill[2] = 90;
//        arrayToFill[3] = 91;
    }

    public static int[] copyArray(int[] source) {
        int[] newArray = new int[source.length];

        for (int i = 0; i < source.length; i++) {
            newArray[i] = source[i];
        }

        return newArray;
    }

    public static int[] copyArrayTo(int[] source, int toLength) {
        int[] newArray = new int[toLength];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = source[i];
        }

        return newArray;
    }

    public static int[] copyArrayFromTo(int[] source, int fromLength, int toLength) {
        // fromLength = 5
        // toLength = 10
        // size = 10 - 5
        int size = toLength - fromLength;
        int[] newArray = new int[size + 1];
        for (int i = 0, j = fromLength; i < newArray.length; i++, j++) {
            newArray[i] = source[j];
        }

        return newArray;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
