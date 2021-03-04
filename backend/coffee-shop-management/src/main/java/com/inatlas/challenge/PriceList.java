package com.inatlas.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PriceList {
    private List<Product> priceListMenu = new ArrayList<>();

    public PriceList(List<Product> priceList) {
        this.priceListMenu.addAll(priceList);
    }

    public void addPriceList(List<Product> priceList) {
        this.priceListMenu.addAll(priceList);
    }

    public String getPriceToString (String name){
        return this.priceListMenu.stream()
                                 .filter(p -> p.getName().equals(name))
                                 .findAny().map(Product::getPrice).orElse("");
    }

    public double getPriceToDouble (String name){
        Optional<Product> product = this.priceListMenu.stream().filter(p -> p.getName().equals(name)).findAny();
        return product.isPresent() ? Double.parseDouble(product.get().getPrice().split("\\$")[1]): 0.0;
    }

    public void showPriceListMenu(){
        System.out.println("********** PRICE LIST ****************");
        System.out.println("Product Name \t | \t Price");
        priceListMenu.forEach( p-> System.out.println (p.getName()+" \t "+ p.getPrice()));
        System.out.println("**************************************");
    }
}
