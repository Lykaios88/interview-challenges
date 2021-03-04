package com.inatlas.challenge;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class CoffeeShop {


    private List<Product> orders = new ArrayList<>();
    private PriceList priceList;
    private double totalOrderPrice;

    public CoffeeShop() {
        this.priceList = new PriceList(Arrays.asList(new Product("Latte", "$ 5.3"),
                                                     new Product("Espresso", "$ 4"),
                                                     new Product("Sandwich", "$ 10.10")));
    }

    public void takeOrder(String product, Integer qtt) {
        this.orders.add(new Product(product, qtt, priceList.getPriceToString(product)));
    }

    public void printReceipt() {
        System.out.println("======================================");

        Promotion promotion = new Promotion();
        this.totalOrderPrice = this.orders.stream().map(p -> Double.parseDouble(p.getPrice().split("\\$")[1])*(p.getQtt())).reduce(0.0, Double::sum);

        promotion.applyPromotions( this.orders, this.priceList, totalOrderPrice);

        this.orders.forEach(p -> System.out.println(p.getQtt()+" "+ p));

        promotion.showAppliedPromotions();

        double discount = promotion.totalOrderPriceDiscount();
        this.totalOrderPrice-=discount;
        this.totalOrderPrice = round(this.totalOrderPrice);

        System.out.println("----------------");
        System.out.println("Total: $" + (this.totalOrderPrice));
        System.out.println("======================================");
    }

    public void printMenu() {
        this.priceList.priceListMenu();
    }

    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    private static double round(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
