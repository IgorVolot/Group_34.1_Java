package ait.HWSolution14;

/**
 * @author Andrej Reutow
 * created on 22.09.2023
 */
public class Task4 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int evenCount = 0;

        // Подсчет количества четных чисел в массиве
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num % 2 == 0) {
                evenCount++;
            }
        }

        // Создание массива для четных чисел
        int[] evenArr = new int[evenCount];
        int index = 0;

        // Заполнение массива четными числами
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenArr[i] = arr[i];
            }
        }

        // Сортировка второго массива
        for (int i = 0; i < evenArr.length; i++) {
            for (int j = 0; j < evenArr.length - i - 1; j++) {
                if (evenArr[j] > evenArr[j + 1]) {
                    int temp = evenArr[j];
                    evenArr[j] = evenArr[j + 1];
                    evenArr[j + 1] = temp;
                }
            }
        }

        // Вывод обоих массивов
        System.out.print("Исходный массив: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Массив четных чисел: ");
        for (int num : evenArr) {
            System.out.print(num + " ");
        }
    }
}
