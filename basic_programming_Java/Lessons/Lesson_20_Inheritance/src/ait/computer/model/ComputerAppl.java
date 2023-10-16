package ait.computer.model;

import ait.computer.Computer;

public class ComputerAppl {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Computer[] shop = new Computer[4];
        System.out.println(shop);
        shop[0] = new Computer("i5", 12, 512, "HP");
        shop[1] = new Laptop("i7", 16, 512, "Asus", 3.0, 2.1);
        shop[0].setRam(24);
        shop[2] = new Laptop("i7", 24, 1024, "Asus", 3.0, 2.1);
        shop[3] = new Smartphone("a2", 128, "Apple", 26.5, 0.34, 987612345L);

        for(int i = 0; i < shop.length; ++i) {
            System.out.println(shop[i]);
        }

    }
}
