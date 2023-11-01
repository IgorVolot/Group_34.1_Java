package ait.computer.test;

/*
 * Copyright (c) 2023.
 *  Igor Volotovskyi
 */

import ait.computer.dao.Shop;
import ait.computer.dao.ShopImpl;
import ait.computer.model.Computer;
import ait.computer.model.Laptop;
import ait.computer.model.SmartPhone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    private Shop shop;
    Computer[] computers;

    @BeforeEach
    void setUp() {
        shop = new ShopImpl(10);
        computers = new Computer[9];
        computers[0] = new Computer(1000, "HP", "model1", "i5", 512, 1024, 670.0);
        computers[1] = new Computer(1001, "Dell", "model5", "i5", 512, 1024, 480.0);
        computers[2] = new Computer(1002, "PackardBell", "model5", "i5", 512, 1024, 450.0);
        computers[3] = new Laptop(1003, "Asus", "model1", "i5", 128, 512, 3.0, 2.1, 680);
        computers[4] = new Laptop(1004, "Apple", "MacBook", "i9", 128, 512, 6.0, 3.6, 860.6);
        computers[5] = new Laptop(1005, "Acer", "model2", "i7", 240, 1024, 5.0, 1.7, 740.5);
        computers[6] = new SmartPhone(1006, "Apple", "iPhone 15", "A3", 128, 512, 22.0, 0.25, 123456789099l, 980.5);
        computers[7] = new SmartPhone(1007, "Samsung", "Neo", "Snapdragon", 128, 512, 28.0, 0.35, 123456789100l, 820.45);
        computers[8] = new SmartPhone(1008, "OnePlus", "8Plus Pro", "Snapdragon2", 512, 1024, 36.0, 0.31, 123456789101l, 760.4);
        for (int i = 0; i < computers.length; i++) {
            shop.addComputer(computers[i]);
        }
    }

    @Test
    void addComputer() {
        assertFalse(shop.addComputer(null));
        assertFalse(shop.addComputer(computers[2]));
        Computer computer = new Laptop(1009, "Apple", "MacBook", "i7", 32, 512, 6.0, 3.2, 990.3);
        assertTrue(shop.addComputer(computer));
        assertEquals(10, shop.quantity());
        computer = new SmartPhone(1010, "Samsung", "Neo1", "Snapdragon", 128, 512, 28.0, 0.35, 123456789101l, 740.3);
        assertFalse(shop.addComputer(computer));
    }

    @Test
    void quantity() {
        assertEquals(9, shop.quantity());
    }

    @Test
    void removeComputer() {
        Computer computer = shop.removeComputer(1002);
        assertEquals(computers[2], computer);
        assertEquals(8, shop.quantity());
        assertNull(shop.removeComputer(1002));
    }

    @Test
    void findComputer() {
        Computer computer = shop.findComputer(1002);
        assertEquals(computers[2], computer);
        assertNull(shop.findComputer(2022));
    }

    @Test
    void findComputerByBrand() {
        Computer[] expected = {computers[4], computers[6]};
        Computer[] actual = shop.findComputerByBrand("Apple");
        assertEquals(expected, actual);
    }

    @Test
    void findLaptopByModel() {
        Computer[] expected = {computers[0], computers[3]};
        Computer[] actual = shop.findLaptopByModel("model1");
        assertEquals(expected, actual);
    }

    @Test
    void findLaptopBySsd() {
        Computer[] expected = {computers[0], computers[1], computers[2], computers[5], computers[8]};
        Computer[] actual = shop.findLaptopBySsd(1024);
        assertEquals(expected, actual);
    }

    @Test
    void findLaptopByHours() {
        Computer[] expected = {computers[4], computers[5]};
        Computer[] actual = shop.findLaptopByHours(3.5, 6.5);
        assertEquals(expected, actual);
    }

    @Test
    void findSmartPhoneByImei() {
        SmartPhone[] smartPhone = shop.findSmartPhoneByImei(123456789100l);
        assertEquals(computers[7], smartPhone);
    }

    @Test
    void findSmartPhoneByWeight() {
        Computer[] expected = {computers[4], computers[5]};
        Computer[] actual = shop.findSmartPhoneByWeight(0.2, 0.32);
        assertEquals(expected, actual);
    }

    @Test
    void findComputerByPrice() {
        Computer[] expected = {computers[3], computers[5], computers[8]};
        Computer[] actual = shop.findComputerByPrice(500, 800);
        assertEquals(expected, actual);
    }

    @Test
    void testComputerSetPrice() {
        Computer computer = new SmartPhone(1006, "Apple", "iPhone 15", "A3", 128, 512, 22.0, 0.25, 123456789099l, 950.5);
        assertTrue(shop.setPrice(1006, 950.5));
    }
}