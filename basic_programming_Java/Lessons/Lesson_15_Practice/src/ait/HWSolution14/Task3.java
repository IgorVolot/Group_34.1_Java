package ait.HWSolution14;

import java.util.Arrays;

/**
 * @author Andrej Reutow
 * created on 22.09.2023
 */
public class Task3 {
    public static void main(String[] args) {
        int[] mas = new int[10];

        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 90) + 10;
        }
        System.out.println(Arrays.toString(mas));

        Arrays.sort(mas);
        System.out.println(Arrays.toString(mas));

        boolean flag = true;
        for (int i = 1; i < mas.length; i++) {
            if (mas[i] <= mas[i - 1]) {
                flag = false;
                break;
            }
        }
        flag = isIncreasingSequence2(mas);

        if (flag) {
            System.out.println("Массив является строго возрастающей последовательностью");
        } else {
            System.out.println("Массив не является строго возрастающей последовательностью");
        }
    }


    public static boolean isIncreasingSequence(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIncreasingSequence2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {  // Изменили здесь
                return false;
            }
        }
        return true;
    }
}
