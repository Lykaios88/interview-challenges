package com.inatlas.challenge;

public class Product {
    private String name;
    private Integer qtt;
    private Integer discountQtt = 0;
    private boolean discount;

    public Product(String name, Integer qtt) {
        this.name = name;
        this.qtt = qtt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + "  " + getPrice());

        if (discount || discountQtt>0) {
            sb.append("\n\t (Discount ").append(discountQtt).append(" ").append(name).append(")");
        }

        return sb.toString();
    }

    public Integer getQtt() {
        return qtt;
    }

    public Integer getdiscountQtt() {
        return discountQtt;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {

        if (this.discount) {
            return "$ 0.0";
        }

        if ("Sandwich".equals(this.name)) {
            return "$ 10.10";
        }
        if ("Latte".equals(this.name)) {
            return "$ 5.3";
        }
        if ("Espresso".equals(this.name)) {
            return "$ 4";
        }
        return "";
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public void setDiscountQtt(int discountQtt) {
        this.discountQtt = discountQtt;
    }
}
