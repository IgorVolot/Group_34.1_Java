package ait.arrays;

import ait.arrays.tools.ArrayTools;

public class ArraysAppl {
    public static void main(String[] args) {
        int[] arr = new int[10];
        ArrayTools.fillArray(arr, 10, 99);
        ArrayTools.printArray(arr);
        int res = ArrayTools.minArray(arr);
        System.out.println("Min = " + res);
        ArrayTools.bubbleSort(arr);
        ArrayTools.printArray(arr);
    }
}
