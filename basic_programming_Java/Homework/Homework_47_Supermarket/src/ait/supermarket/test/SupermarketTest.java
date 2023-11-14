package ait.supermarket.test;

import ait.supermarket.dao.Supermarket;
import ait.supermarket.dao.SupermarketImpl;
import ait.supermarket.model.Product;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketTest {
    LocalDate expDate = LocalDate.now();

    Supermarket supermarket;

    @BeforeEach
    void setUp() {
        supermarket = new SupermarketImpl();
        supermarket.addProduct(new Product(1111l, "product1", "category1", "brand1", 12.5, expDate.plusDays(5)));
        supermarket.addProduct(new Product(1222l, "product2", "category2", "brand2", 1.3, expDate.minusDays(1)));
        supermarket.addProduct(new Product(1333l, "product3", "category1", "brand3", 3.7, expDate.plusDays(8)));
        supermarket.addProduct(new Product(1444l, "product4", "category3", "brand2", 0.8, expDate.plusDays(2)));
        supermarket.addProduct(new Product(1555l, "product5", "category4", "brand4", 2.4, expDate.minusDays(4)));
    }

    @Test
    void addProduct() {
        assertFalse(supermarket.addProduct(new Product(1111l, "product1", "category1", "brand1", 12.5, expDate.plusDays(5))));
        assertTrue(supermarket.addProduct(new Product(2222l, "product6", "category3", "brand1", 12.5, expDate.plusDays(7))));
    }

    @Test
    void removeProduct() {
        supermarket.removeProduct(1222l);
        assertNull(supermarket.findByBarCode(1222l));
    }

    @Test
    void findByBarCode() {
        assertNull(supermarket.findByBarCode(9999l));
        assertEquals(supermarket.findByBarCode(1222l), new Product(1222l, "product2", "category2", "brand2", 1.3, expDate.minusDays(1)));
    }

    @Test
    void findByCategory() {
        ArrayList<Product> expected = (ArrayList<Product>) supermarket.findByCategory("category1");
        ArrayList<Product> actual = new ArrayList<Product>(0);
        actual.add(supermarket.findByBarCode(1111l));
        actual.add(supermarket.findByBarCode(1333l));
        assertIterableEquals(expected, actual);
    }

    @Test
    void findByBrand() {
        ArrayList<Product> expected = (ArrayList<Product>) supermarket.findByBrand("brand2");
        ArrayList<Product> actual = new ArrayList<Product>(0);
        actual.add(supermarket.findByBarCode(1222l));
        actual.add(supermarket.findByBarCode(1444l));
        assertIterableEquals(expected, actual);
    }

    @Test
    void findProductWithExpiredDate() {
        ArrayList<Product> expected = (ArrayList<Product>) supermarket.findProductWithExpiredDate();
        ArrayList<Product> actual = new ArrayList<Product>(0);
        actual.add(supermarket.findByBarCode(1222l));
        actual.add(supermarket.findByBarCode(1555l));
        assertIterableEquals(expected, actual);
    }
    @Test
    void skuQuantity() {
        assertEquals(5, supermarket.skuQuantity());
    }
}