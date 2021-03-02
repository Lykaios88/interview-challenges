package com.inatlas.challenge;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CoffeeShop {
    private List<Product> orders = new ArrayList<>();
    private List<Product> priceList;
    private double totalOrderPrice;

    public CoffeeShop() {
        this.priceList = Arrays.asList(new Product("Latte", "$ 5.3"),
                                  new Product("Espresso", "$ 4"),
                                  new Product("Sandwich", "$ 10.10"));
    }

    public void takeOrder(String product, Integer qtt) {
        this.orders.add(new Product(product, qtt, getPrice(product)));
    }

    public String getPrice (String name){
        return this.priceList.stream().filter(p -> p.getName().equals(name)).findAny().map(Product::getPrice).orElse("");
    }

    public void printReceipt() {
        System.out.println("======================================");
        int totalLattte = this.orders.stream().filter(p -> p.getName().equals("Latte")).mapToInt(Product::getQtt).sum();
        AtomicInteger totalFreeEspresso = new AtomicInteger (totalLattte/2);

        if (totalFreeEspresso.get() > 0) {
            this.orders.forEach(p -> {
                if (p.getName().equals("Espresso")) {
                    if (p.getQtt() <= totalFreeEspresso.get()){
                        p.setDiscount(true);
                        p.setDiscountQtt(p.getQtt());
                        totalFreeEspresso.addAndGet(-p.getQtt());
                    }else
                    {
                        p.setDiscountQtt(totalFreeEspresso.get());
                        totalFreeEspresso.set(0);
                    }
                }
            });
        }

         this.totalOrderPrice = this.orders.stream().map(p -> {
            System.out.println(p.getQtt()+" X "+ p);
            return Double.parseDouble(p.getPrice().split("\\$")[1])*(p.getQtt()- p.getdiscountQtt());
        }).reduce(0.0, Double::sum);


        System.out.println("----------------");
        System.out.println("Total: $" + this.totalOrderPrice);
        System.out.println("======================================");
    }

    public void printMenu() {
        System.out.println("********** PRICE LIST ****************");
        System.out.println("Product Name \t | \t Price");
        priceList.forEach( p -> System.out.println (p.getName()+" \t "+ p.getPrice()));
        System.out.println("**************************************");
        // Print whole menu
    }

    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }
}
