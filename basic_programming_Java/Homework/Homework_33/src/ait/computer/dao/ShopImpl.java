package ait.computer.dao;
/*
 * Copyright (c) 2023.
 *  Igor Volotovskyi
 */

public class ShopImpl implements Shop {
    protected int article;
    protected String brandName;
    protected String model;
    protected double price;

    public ShopImpl(int article, String brandName, String model, double price) {
        this.article = article;
        this.brandName = brandName;
        this.model = model;
        this.price = price;
    }

    public int getArticle() {
        return article;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ShopImpl shop = (ShopImpl) object;

        return article == shop.article;
    }

    @Override
    public int hashCode() {
        return article;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Shop{");
        sb.append("article=").append(article);
        sb.append(", brandName='").append(brandName).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
