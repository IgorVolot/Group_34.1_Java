package ait.recursion;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 6, 9, 11, 13, 15, 17, 19,21};

        Arrays.stream(arr).forEach(a -> System.out.print(a + " | "));
        System.out.println();
        // reverse {21,19,17,15,13,11,9,6,3,1}

        reverseArrayRecursion(arr);
        Arrays.stream(arr).forEach(a -> System.out.print(a + " | "));
        System.out.println();

    }

    private static <T> void reverseArrayRecursion(T[] arr) {
        reverseArrayRecursion(arr, 0, arr.length -1);
    }
    private static <T> void reverseArrayRecursion(T[] arr, int l , int r){
        if (l >= r){
            return;
        }
        T tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
        reverseArrayRecursion(arr, ++l, --r);

    }
}
