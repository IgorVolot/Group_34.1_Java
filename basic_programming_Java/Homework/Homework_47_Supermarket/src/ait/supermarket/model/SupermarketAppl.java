package ait.supermarket.model;

import ait.supermarket.dao.Supermarket;
import ait.supermarket.dao.SupermarketImpl;

import java.time.LocalDate;
import java.util.stream.StreamSupport;

public class SupermarketAppl {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        Supermarket myMarket = new SupermarketImpl();
        myMarket.addProduct(new Product(111111, "White Bread", "Bread", "Kolosok", 6.5, now.plusDays(5)));
        myMarket.addProduct(new Product(222222, "ChokoMilk", "Dairy", "MilkLand", 13, now.minusDays(3)));
        myMarket.addProduct(new Product(333333, "Cheese Gauda", "Dairy", "Farmer", 22.5, now.plusDays(50)));
        myMarket.addProduct(new Product(444444, "Cheese Chedder", "Dairy", "MilkLand", 30, now.plusDays(85)));
        myMarket.addProduct(new Product(555555, "Sweet Buns", "Bread", "Kolosok", 18.3, now.minusDays(25)));

        StreamSupport.stream(myMarket.spliterator(), false)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Products with expired date:");
        Iterable<Product> res = myMarket.findProductWithExpiredDate();
        StreamSupport.stream(res.spliterator(), false)
                .forEach(System.out::println);
        System.out.println();
    }

}
