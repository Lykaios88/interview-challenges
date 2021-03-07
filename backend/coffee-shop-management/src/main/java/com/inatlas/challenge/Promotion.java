package com.inatlas.challenge;

import java.util.List;

public class Promotion {

    private double totalOrderPrice;
    private double totalOrderPriceDiscount = 0;
    private String promotionDiscount;

    public void applyPromotions(List<Product> orders, PriceList priceList) {
        this.totalOrderPrice = orders.stream().map(p -> p.getPriceToDouble()*(p.getQtt())).reduce(0.0, Double::sum);
        promotionEspresso(orders, priceList);
        promotionPercentDiscount(orders, 5);
        promotionDrinksAndFood(orders, priceList, 2.3);
    }

    private void promotionEspresso (List<Product> orders, PriceList priceList){

        int totalLattte  = orders.stream().filter(p -> p.getName().equals("Latte")).mapToInt(Product::getQtt).sum();
        int totalEspreso = orders.stream().filter(p -> p.getName().equals("Espresso")).mapToInt(Product::getQtt).sum();
        int totalFreeEspresso = totalLattte/2;

        if (totalEspreso <= totalFreeEspresso) {
            totalFreeEspresso = totalEspreso;
        }

        double discount = totalFreeEspresso * priceList.getPriceToDouble("Espresso");
        setPromotionDiscount(discount, "Discount "+totalFreeEspresso+" Expresso");
    }

    private void promotionPercentDiscount (List<Product> orders, int percent){

        int totalProducts = orders.stream().mapToInt(Product::getQtt).sum();
        if (totalProducts > 8)
        {
            setPromotionDiscount(totalOrderPrice*percent/100, "Discount "+percent+"% because the order have more than 8 products.");
        }
    }

    private void promotionDrinksAndFood (List<Product> orders, PriceList priceList, double priceDiscount){
        if ( totalOrderPrice > 50){
            boolean haveFood = orders.stream().anyMatch(p -> p.getProductType().equals("food"));
            boolean haveDrink = orders.stream().anyMatch(p -> p.getProductType().equals("drink"));
            if (haveFood && haveDrink){
                double totalDiscountLattte  = orders.stream().filter(p -> p.getName().equals("Latte")).mapToInt(Product::getQtt).sum() * priceDiscount;
                double newPrice = priceList.getPriceToDouble("Latte")-priceDiscount;
                setPromotionDiscount(totalDiscountLattte, "Discount $ "+ totalDiscountLattte+" new price Latte: "+ newPrice);
            }
        }
    }

    private void setPromotionDiscount (double discount, String descriptionDiscount){
        if (discount > totalOrderPriceDiscount){
            totalOrderPriceDiscount = discount;
            promotionDiscount = descriptionDiscount;
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
            System.out.println("\t--- Discount ---\n\t"+promotionDiscount);
            System.out.println("\t----------------");
        }
    }
}
