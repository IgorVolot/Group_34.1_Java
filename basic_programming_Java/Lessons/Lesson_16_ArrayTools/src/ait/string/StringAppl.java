package ait.string;

import java.util.Scanner;

public class StringAppl {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(str);
        char c = 'K';
        str = str + " world";  //concatenation
        System.out.println(str);
        str = 8 + 1 + str + 8 + 1;
        System.out.println(str);
        greeting("Peter");
        greeting("John");
//        bank("Mon");
//        bank("Thu");
//        bank("Sat");
        Scanner scanner = new Scanner(System.in);
//        while (true) {
        System.out.println("Enter name of week days:");
        String day = scanner.next();
        bank(day);
//        }
        System.out.println("Enter radius:");
        double radius = scanner.nextDouble();
        double length = 2 * 3.1415926 * radius;
        System.out.println("Circle length = " + length);
        System.out.println("Enter week numbers");
        int week = scanner.nextInt();
        scheduler(week);
    }

    public static void greeting(String name) {
        String str = "Welcome " + name + "!";
        System.out.println(str);
    }

    public static void scheduler(int week) {
        // John 1,5..., Peter 2,6..., Mary 3,7.., Rabindranate 4,8...
        if (week < 1 || week > 52) {
            System.out.println("Wrong week");
            return;
        }
        switch (week % 4) {
            case 1:
                System.out.println("John");
                break;
            case 2:
                System.out.println("Peter");
                break;
            case 3:
                System.out.println("Mary");
                break;
            case 0:
                System.out.println("Rabindranate");
                break;
        }
    }

    public static void bank(String day) {
        switch (day) {
            case "Mon":
            case "Wed":
            case "Fri":
                System.out.println("8:30 - 13:30");
                break;
            case "Tue":
            case "Thu":
                System.out.println("8:30 - 13:00 and 16:00 - 18:00");
                break;
            case "Sat":
            case "Sun":
                System.out.println("Closed");
                break;
            default:
                System.out.println("Wrong day");
        }
    }
}
