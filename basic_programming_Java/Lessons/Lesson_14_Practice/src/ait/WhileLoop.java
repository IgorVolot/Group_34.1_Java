package ait;

import java.util.Scanner;

/**
 * @author Andrej Reutow
 * created on 22.09.2023_000_000
 */
public class WhileLoop {

    public static void main(String[] args) {
        // 0 ... 3_000_000

//        int number = 10;
//        boolean condition = number <= 100;
//        while (condition) {
//            System.out.println(number); // 10 ... 100
//            number++;
//        }

//        do {
//            System.out.println(number);
//            number++;
//        } while (false); // 10 <= 5 - false

        Scanner scanner = new Scanner(System.in);
        int selectedMenu = 3;

        int arrayL = scanner.nextInt(); // 5
        int[] array = new int[arrayL]; // l = 5

        System.out.println("Введите желаемый индекс:");
        int setIndex = scanner.nextInt(); // 2
        int value = scanner.nextInt(); // 777
        array[setIndex] = value; // {0, 0, 777, 0, ... }

//        do {
//            System.out.println("1 - спать");
//            System.out.println("2 - вставать");
//            System.out.println("3 - выход");
//            selectedMenu = scanner.nextInt();
//        } while (selectedMenu != 3); // false, 3 -> 1 1 != 3 = true

//        while (selectedMenu != 3) { // false
//            System.out.println("1 - спать");
//            System.out.println("2 - вставать");
//            System.out.println("3 - выход");
//            selectedMenu = scanner.nextInt();
//        }

        menu();
        System.out.println("END");


        int a = 1;
        int b = 1;
        add(a, b);
    }

    public static void menu() {

        Scanner scanner = new Scanner(System.in);
        int selectedMenu = 0;
        while (true) { // false
            System.out.println("1 - спать");
            System.out.println("2 - вставать");
            System.out.println("3 - выход");
            selectedMenu = scanner.nextInt();
            if (selectedMenu == 3) {
                break;
            }
        }
    }

    public static void add(int a, int b) {
        int result = a + b;
        System.out.println(result);
    }
}