package ait.arrays.model;

public class Methods {
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void split() {
        System.out.println("-------------------------------------------------------");
    }

    public static int[] fillArray(int n, int a, int b) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (b - a + 1) + a);
        }
        return arr;
    }

    public static int positiveNum(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                counter++;
            }
        }
        return counter;
    }

    public static int negativeNum(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                counter++;
            }
        }
        return counter;
    }

    public static int evenNum(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }

    public static int oddNum(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                counter++;
            }
        }
        return counter;
    }

    public static int indexMaxEl(int[] arr) {
        int max = arr[0];
        int indexMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                indexMax = i;
            }
        }
        return indexMax;
    }

    public static int maxNum(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int indexMinEl(int[] arr) {
        int min = arr[0];
        int indexMin = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                indexMin = i;
            }
        }
        return indexMin;
    }

    public static int minNum(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
