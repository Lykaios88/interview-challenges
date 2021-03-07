package com.inatlas.challenge;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class CoffeeShop {

    private double totalOrderPrice;
    private HashMap < Client, List<Product>> orders = new HashMap<>();
    private PriceList priceList = new PriceList(Arrays.asList( new Product("Latte", "$ 5.3"),
                                                               new Product("Espresso", "$ 4"),
                                                               new Product("Sandwich", "$ 10.10")));

    public void addProductList (List<Product> priceList){
        this.priceList.addPriceList(priceList);
    }

    public void takeOrder(Client client, String product, Integer qtt) {
        orders.get(client).add(new Product(product, qtt, priceList.getPriceToString(product)));
    }

    public void newClient(Client client){
        orders.put(client, new ArrayList<>());
    }

    public void printReceipt(Client client) {
        System.out.println("======================================");
        System.out.println("Name of client "+ client.getName());
        Promotion promotion = new Promotion();
        promotion.applyPromotions(orders.get(client), priceList);

        orders.get(client).forEach(p -> System.out.println(p.getQtt()+" "+ p));
        promotion.showAppliedPromotions();

        this.totalOrderPrice = round(promotion.getTotalOrderPrice() - promotion.totalOrderPriceDiscount());

        System.out.println("----------------");
        System.out.println("Total: $" + (this.totalOrderPrice));
        System.out.println("======================================");
    }

    public void pirntDailyReport (){
        System.out.println("==========     Daily Report    =======");

        double totalSpend=0.0;
        for (Map.Entry<Client, List<Product>> e : orders.entrySet()) {

        totalSpend+= e.getValue().stream().mapToDouble(p -> {
               System.out.println(p.getQtt()+" "+ p);
               return p.getPriceToDouble() * p.getQtt();
           }).sum();
       }

        System.out.println(" Average per customer "+ round(totalSpend/orders.size()));

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
