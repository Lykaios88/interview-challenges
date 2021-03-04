package com.inatlas.challenge;

import java.util.Arrays;
import java.util.List;

public class Product {

    List<String> food = Arrays.asList("Sandwich", "Cake Slice");

    private String name;
    private int qtt;
    private String productType;
    private int discountQtt = 0;
    private String price;
    private boolean discount;

    public Product(String name, int qtt, String price) {
        this.name = name;
        this.qtt = qtt;
        this.price = price;
        this.productType= food.contains(name)?"food":"drink";
    }

    public Product(String name, String price) {
        this( name, 1, price);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + " $ " + getPriceToDouble()*qtt);

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

    public Double getPriceToDouble (){
        return Double.parseDouble(price.split("\\$")[1]);
    }

    public String getProductType() {
        return productType;
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
