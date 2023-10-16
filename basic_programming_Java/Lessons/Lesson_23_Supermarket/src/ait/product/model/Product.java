package ait.product.model;

public class Product {
    private long barcode;
    private String name;
    private double price;

    public Product(long barcode, String name, double price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    public long getBarcode() {
        return this.barcode;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Product barcode= " + this.barcode + ", name= " + this.name + ", price= " + this.price;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object != null && this.getClass() == object.getClass()) {
            Product product = (Product)object;
            return this.barcode == product.barcode;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int)(this.barcode ^ this.barcode >>> 32);
    }
}
