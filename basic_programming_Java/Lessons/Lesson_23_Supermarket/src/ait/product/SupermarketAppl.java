package ait.product;

import ait.product.dao.Supermarket;
import ait.product.model.Food;
import ait.product.model.Product;

public class SupermarketAppl {
    public static void main(String[] args) {
        Supermarket kiosk = new Supermarket(4);
        kiosk.addProduct(new Product(1000L, "Gift card", 20.0));
        kiosk.addProduct(new Food(2000L, "Sosages", 5.0, "20.10.2023", false));
        kiosk.addProduct(new Food(3000L, "Goat cheese", 13.0, "31.12.2023", true));
        kiosk.addProduct((Product)null);
        boolean check = kiosk.addProduct(new Food(4000L, "Pork fat", 3.0, "15.11.2023", true));
        System.out.println(check);
        check = kiosk.addProduct(new Product(5000L, "Book", 2.0));
        System.out.println(check);
        kiosk.printAllProducts();
        Product product = kiosk.findProduct(2000L);
        System.out.println(product);
        product = kiosk.updateProduct(2000L, 10.0);
        System.out.println(product);
        check = kiosk.removeProduct(5000L);
        System.out.println(check);
        int qauntity = kiosk.getQuantity();
        System.out.println(qauntity);
        kiosk.printAllProducts();
    }
}
