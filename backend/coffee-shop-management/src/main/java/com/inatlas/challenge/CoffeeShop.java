package com.inatlas.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CoffeeShop {
    private List<Product> orders = new ArrayList<>();
    public void takeOrder(String product, Integer qtt) {
        this.orders.add(new Product(product, qtt));
    }

    public void printReceipt() {
        System.out.println("======================================");
        int totalLattte = this.orders.stream().parallel().filter(p -> p.getName().equals("Latte")).mapToInt(Product::getQtt).sum();
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

        Double total = this.orders.stream().map(p -> {
            System.out.println(p.getQtt()+" X "+ p);
            return Double.parseDouble(p.getPrice().split("\\$")[1])*(p.getQtt()- p.getdiscountQtt());
        }).reduce(0.0, Double::sum);

        System.out.println("----------------");
        System.out.println("Total: $" + total);
        System.out.println("======================================");
    }

    public void printMenu() {
        // Print whole menu
    }
}
