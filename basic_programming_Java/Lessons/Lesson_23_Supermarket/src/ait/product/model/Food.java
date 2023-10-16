package ait.product.model;

public class Food extends Product {
    private String expDate;
    private boolean organic;

    public Food(long barcode, String name, double price, String expDate, boolean organic) {
        super(barcode, name, price);
        this.expDate = expDate;
        this.organic = organic;
    }

    public String getExpDate() {
        return this.expDate;
    }

    public boolean isOrganic() {
        return this.organic;
    }

    public String toString() {
        String var10000 = super.toString();
        return "Food: " + var10000 + " expDate= " + this.expDate + ", organic= " + this.organic;
    }
}
