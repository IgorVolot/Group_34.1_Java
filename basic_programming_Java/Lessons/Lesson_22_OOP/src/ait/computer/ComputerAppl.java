package ait.computer;

import ait.computer.model.*;
import ait.computer.model.Computer;
public class ComputerAppl {
    public static void main(String[] args) {
        Computer[] shop = new Computer[]{new Computer("i5", 12, 512, "HP"),
                new Laptop("i7", 24, 1024, "Asus", 3.0, 2.1),
                new Laptop("i7", 24, 1024, "Asus", 4.5, 2.2),
                new Smartphone("Snapdragon", 8, 128, "Samsung", 24.0, 0.15, 123456789098L), null};
        printArray(shop);
        System.out.println("======================================================");
        Computer computer = new Computer("i5", 12, 512, "HL");
        boolean checker = shop[0].equals(computer);
        System.out.println(checker);
        checker = shop[3].equals(computer);
        System.out.println(checker);
        checker = shop[1].equals(shop[2]);
        System.out.println(checker);
        Smartphone smartphone = new Smartphone("Snapdragon", 8, 128, "Samsung", 24.0, 0.15, 123456789097L);
        checker = smartphone.equals(shop[3]);
        System.out.println(checker);
    }

    public static void printArray(Computer[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            if (arr[i] != null) {
                System.out.println(arr[i]);
            }
        }

    }
}
