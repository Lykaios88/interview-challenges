package com.inatlas.challenge;

public class Product {
    private String name;
    private int qtt;
    private int discountQtt = 0;
    private String price;
    private boolean discount;

    public Product(String name, int qtt, String price) {
        this.name = name;
        this.qtt = qtt;
        this.price = price;
    }

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
        this.qtt = 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + "  " + getPrice());

        if (discount || discountQtt>0) {
            sb.append("\n\t (Discount ").append(discountQtt).append(" ").append(name).append(")");
        }

        return sb.toString();
    }

    public int getQtt() {
        return qtt;
    }

    public int getdiscountQtt() {
        return discountQtt;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return discount?"$ 0.0":price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public void setDiscountQtt(int discountQtt) {
        this.discountQtt = discountQtt;
    }
}
