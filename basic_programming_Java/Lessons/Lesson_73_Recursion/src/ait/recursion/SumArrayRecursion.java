package ait.recursion;

import java.util.Arrays;

public class SumArrayRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 9, 11, 13, 15, 17, 19, 21, 10, 5};
        Arrays.stream(arr).forEach(a -> System.out.print(a + " | "));
        System.out.println();

        int sum = sumArrayRecursion(arr, 0);
        System.out.println("Sum of array elements = " + sum);
    }

    private static int sumArrayRecursion(int[] arr, int i) {
        int sum = 0;
        if (i == arr.length - 1){
            sum = arr[i];
        } else {
            sum = arr[i] + sumArrayRecursion(arr, i + 1);
        }
        return sum;
    }
}
