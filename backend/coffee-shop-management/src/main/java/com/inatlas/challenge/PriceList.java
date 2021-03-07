package com.inatlas.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PriceList {

    private List<Product> priceListMenu;

    PriceList(List<Product> priceList) {
        priceListMenu = new ArrayList<>(priceList);
    }

    public void addPriceList(List<Product> priceList) {
        priceListMenu.addAll(priceList);
    }

    public String getPriceToString (String name){
        return priceListMenu.stream()
                                 .filter(p -> p.getName().equals(name))
                                 .findAny().map(Product::toString).orElse("");
    }

    public double getPriceToDouble (String name){
        Optional<Product> product = priceListMenu.stream().filter(p -> p.getName().equals(name)).findAny();
        return product.map(Product::getPriceToDouble).orElse(0.0);
    }

    public void showPriceListMenu(){
        System.out.println("********** PRICE LIST ****************");
        System.out.println("Product Name \t | \t Price");
        priceListMenu.forEach( p-> System.out.println (p.getName()+" \t "+ p.toString()));
        System.out.println("**************************************");
    }
}
