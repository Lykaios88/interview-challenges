package com.inatlas.challenge;

import java.util.Arrays;
import java.util.List;

public class Product {

    List<String> food = Arrays.asList("Sandwich", "Cake Slice");

    private String name;
    private int qtt;
    private String productType;
    private String price;

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
        return name + " $ " + getPriceToDouble()*qtt;
    }

    public int getQtt() {
        return qtt;
    }

    public String getName() {
        return name;
    }

    public Double getPriceToDouble (){
        return Double.parseDouble(price.split("\\$")[1]);
    }

    public String getProductType() {
        return productType;
    }
}
