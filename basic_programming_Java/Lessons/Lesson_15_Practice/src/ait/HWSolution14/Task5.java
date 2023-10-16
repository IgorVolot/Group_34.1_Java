package ait.HWSolution14;

/**
 * @author Andrej Reutow
 * created on 22.09.2023
 */
public class Task5 {

    public static void main(String[] args) {
        int[] arr1 = {1, -10, 70, 101};
        int[] arr2 = {1, 99};

        findIndexes(arr1, arr2);
    }

    public static void findIndexes(int[] arr1, int[] arr2) {
        for (int j = 0; j < arr2.length; j++) {
            int num = arr2[j];
            boolean found = false;
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] == num) {
                    System.out.println("Число " + num + ", найдено, индекс " + i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Число " + num + ", индекс не найдено");
            }
        }
    }
}
