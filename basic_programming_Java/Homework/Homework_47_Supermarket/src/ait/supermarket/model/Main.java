package ait.supermarket.model;

import ait.supermarket.dao.SupermarketImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalDate expDate = LocalDate.now();
        SupermarketImpl products = new SupermarketImpl();
        products.addProduct(new Product(1111l, "product1", "category1", "brand1", 12.5, expDate.plusDays(5)));
        products.addProduct(new Product(1222l, "product2", "category2", "brand2", 1.3, expDate.minusDays(1)));
        products.addProduct(new Product(1333l, "product3", "category1", "brand3", 3.7, expDate.plusDays(8)));
        products.addProduct(new Product(1444l, "product4", "category3", "brand2", 0.8, expDate.minusDays(2)));
        products.addProduct(new Product(1555l, "product5", "category4", "brand4", 2.4, expDate.plusDays(4)));

        products.forEach(product -> System.out.println(product));
        System.out.println("Expired products: " + products.findProductWithExpiredDate());
    }
}
