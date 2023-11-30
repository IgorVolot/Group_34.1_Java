package ait.supermarket.dao;

import ait.supermarket.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SupermarketImpl implements Supermarket {
    private Collection<Product> products;

    public SupermarketImpl() {
        products = new ArrayList<>();
    }

    @Override
    public boolean addProduct(Product product) {
        if (product == null || products.contains(product)) {
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
//        for (Product product : products) {
//            if (product.getBarCode() == barCode) {
//                return product;
//            }
//        }
//        return null;
        return products.stream()
                .filter(p -> p.getBarCode() == barCode)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Iterable<Product> findByCategory(String category) {
        return findProductByPredicate(p -> p.getCategory().equalsIgnoreCase(category));
    }

    @Override
    public Iterable<Product> findByBrand(String brand) {
        return findProductByPredicate(p -> p.getBrand().equalsIgnoreCase(brand));
    }

    @Override
    public Iterable<Product> findProductWithExpiredDate() {
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

    private Iterable<Product> findProductByPredicate(Predicate<Product> predicate) {
//        List<Product> res = new ArrayList<>();
//        for (Product product : products) {
//            if (predicate.test(product)) {
//                res.add(product);
//            }
//        }
//        return res;
        return products.stream()
                .filter(p -> predicate.test(p))
                .collect(Collectors.toList());
    }
}
