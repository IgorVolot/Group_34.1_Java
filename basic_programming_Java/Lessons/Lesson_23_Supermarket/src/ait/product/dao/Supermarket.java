package ait.product.dao;

import ait.product.model.Product;

public class Supermarket {
    private Product[] products;
    private int quantity;

    public Supermarket(int capacity) {
        this.products = new Product[capacity];
    }

    public boolean addProduct(Product product) {
        if (product != null && this.quantity != this.products.length && this.findProduct(product.getBarcode()) == null) {
            this.products[this.quantity] = product;
            ++this.quantity;
            return true;
        } else {
            return false;
        }
    }

    public Product findProduct(long barcode) {
        for(int i = 0; i < this.products.length; ++i) {
            if (this.products[i] != null && this.products[i].getBarcode() == barcode) {
                return this.products[i];
            }
        }

        return null;
    }

    public Product updateProduct(long barcode, double price) {
        for(int i = 0; i < this.products.length; ++i) {
            if (this.products[i] != null && this.products[i].getBarcode() == barcode) {
                this.products[i].setPrice(price);
                return this.products[i];
            }
        }

        return null;
    }

    public boolean removeProduct(long barcode) {
        for(int i = 0; i < this.products.length; ++i) {
            if (this.products[i] != null && this.products[i].getBarcode() == barcode) {
                if (this.products[i] != this.products[this.products.length - 1]) {
                    this.products[i] = this.products[i + 1];
                }

                this.products[i] = null;
                --this.quantity;
                return true;
            }
        }

        return false;
    }

    public void printAllProducts() {
        for(int i = 0; i < this.products.length; ++i) {
            if (this.products[i] != null) {
                System.out.println(this.products[i]);
            }
        }

    }

    public int getQuantity() {
        return this.quantity;
    }
}
