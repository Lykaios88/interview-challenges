package com.inatlas.challenge;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class CoffeeShop {

    private double totalOrderPrice;
    private List<Product> orders = new ArrayList<>();
    private PriceList priceList = new PriceList(Arrays.asList( new Product("Latte", "$ 5.3"),
                                                               new Product("Espresso", "$ 4"),
                                                               new Product("Sandwich", "$ 10.10")));

    public void addProductList (List<Product> priceList){
        this.priceList.addPriceList(priceList);
    }

    public void takeOrder(String product, Integer qtt) {
        this.orders.add(new Product(product, qtt, priceList.getPriceToString(product)));
    }

    public void printReceipt() {
        System.out.println("======================================");

        Promotion promotion = new Promotion();
        promotion.applyPromotions(this.orders, priceList);

        this.orders.forEach(p -> System.out.println(p.getQtt()+" "+ p));
        promotion.showAppliedPromotions();

        this.totalOrderPrice = round(promotion.getTotalOrderPrice() - promotion.totalOrderPriceDiscount());

        System.out.println("----------------");
        System.out.println("Total: $" + (this.totalOrderPrice));
        System.out.println("======================================");
    }

    public void printMenu() {
        priceList.showPriceListMenu();
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
