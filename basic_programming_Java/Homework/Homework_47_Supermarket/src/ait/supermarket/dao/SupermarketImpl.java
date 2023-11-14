package ait.supermarket.dao;

import ait.supermarket.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class SupermarketImpl implements Supermarket {
    private List<Product> products;

    public SupermarketImpl() {
        products = new ArrayList<>();
    }

    @Override
    public boolean addProduct(Product product) {
        if (product == null) {
            throw new RuntimeException("Product cannot be null");
        }
        if (products.contains(product)) {
            return false;
        }
        return products.add(product);
    }

    @Override
    public Product removeProduct(long barCode) {
        Product product = findByBarCode(barCode);
        products.remove(product);
        return product;
    }

    @Override
    public Product findByBarCode(long barCode) {
        for (Product product : products) {
            if (product.getBarCode() == barCode) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findByCategory(String category) {
        return findProductByPredicate(p -> p.getCategory().equals(category));
    }

    @Override
    public List<Product> findByBrand(String brand) {
        return findProductByPredicate(p -> p.getBrand().equals(brand));
    }

    @Override
    public List<Product> findProductWithExpiredDate() {
        return findProductByPredicate(p -> p.getExpDate().isBefore(LocalDate.now()));
    }

    @Override
    public int skuQuantity() {
        return products.size();
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }

    private List<Product> findProductByPredicate(Predicate<Product> predicate) {
        List<Product> res = new ArrayList<>();
        for (Product product : products) {
            if (predicate.test(product)) {
                res.add(product);
            }
        }
        return res;
    }
}
