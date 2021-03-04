package com.inatlas.challenge;

import java.util.ArrayList;
import java.util.List;

public class Promotion {

    private double totalOrderPrice;
    private double totalOrderPriceDiscount = 0;
    private List<String> promotionDiscount = new ArrayList<>();

    public void applyPromotions(List<Product> orders, PriceList priceList, double totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
        promotionEspresso(orders, priceList);
        promotionPercentDiscount(orders, 5);
    }

    public void promotionEspresso (List<Product> orders, PriceList priceList){

        int totalLattte  = orders.stream().filter(p -> p.getName().equals("Latte")).mapToInt(Product::getQtt).sum();
        int totalEspreso = orders.stream().filter(p -> p.getName().equals("Espresso")).mapToInt(Product::getQtt).sum();
        int totalFreeEspresso = totalLattte/2;

        if (totalEspreso <= totalFreeEspresso) {
            totalFreeEspresso = totalEspreso;
        }

        double discount = totalFreeEspresso * priceList.getPriceToDouble("Espresso");
        setPromotionDiscount(discount, "Discount "+totalFreeEspresso+" Expresso");
    }

    public void promotionPercentDiscount (List<Product> orders, int percent){

        int totalProducts = orders.stream().mapToInt(Product::getQtt).sum();
        if (totalProducts > 8)
        {
            setPromotionDiscount(totalOrderPrice*percent/100, "Discount "+percent+"% because the order have more than 8 products.");
        }
    }

    private void setPromotionDiscount (double discount, String descriptionDiscount){
        if (discount > totalOrderPriceDiscount){
            totalOrderPriceDiscount = discount;
            promotionDiscount.add(descriptionDiscount);
        }
    }

    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public double totalOrderPriceDiscount() {
        return totalOrderPriceDiscount;
    }

    public void showAppliedPromotions(){
        if (totalOrderPriceDiscount > 0) {
            System.out.println("--- Discount ---");
            promotionDiscount.forEach(System.out::println);
        }
    }
}
