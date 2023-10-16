package ait.computer;

import ait.computer.model.Computer;
import ait.computer.model.Laptop;
import ait.computer.model.Smartphone;

public class ComputerAppl {
    public static void main(String[] args) {
        double a = 10.0;
        int b = (int)a;
        Computer[] shop = new Computer[]{new Computer("i5", 12, 512, "HP"),
                new Laptop("i7", 16, 512, "Asus", 3.0, 2.1),
                new Laptop("i7", 24, 1024, "Asus", 3.0, 2.1),
                new Smartphone("Snapdragon", 8, 128, "Samsung", 24.0, 0.15, 123456789098L), null};
        printArray(shop);
        int total = getTotalSSDCapacity(shop);
        System.out.println("Total SSD capacity= " + total);
        Laptop laptop1 = (Laptop)shop[1];
        laptop1.setHours(4.5);
        System.out.println(laptop1);
        double totalHours = getTotalHoursCapacity(shop);
        System.out.println("Total hours capacity= " + totalHours);
        int totalSsdOfLaptops = getTotalSsdCapacityOfLaptops(shop);
        System.out.println("Total SSD capacity of Laptops only = " + totalSsdOfLaptops);
    }

    public static void printArray(Computer[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            if (arr[i] != null) {
                System.out.println(arr[i]);
            }
        }

    }

    public static int getTotalSSDCapacity(Computer[] arr) {
        int res = 0;

        for(int i = 0; i < arr.length; ++i) {
            if (arr[i] != null) {
                res += arr[i].getSsd();
            }
        }

        return res;
    }

    public static double getTotalHoursCapacity(Computer[] arr) {
        double result = 0.0;

        for(int i = 0; i < arr.length; ++i) {
            if (arr[i] instanceof Laptop) {
                result += ((Laptop)arr[i]).getHours();
            }
        }

        return result;
    }

    public static int getTotalSsdCapacityOfLaptops(Computer[] arr) {
        int res = 0;

        for(int i = 0; i < arr.length; ++i) {
            if (arr[i] instanceof Laptop && !(arr[i] instanceof Smartphone)) {
                res += arr[i].getSsd();
            }
        }

        return res;
    }
}
