package com.inatlas.challenge;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeeShopTest {
    
    @Test
    public void testTakeMyFirstOrder(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.printMenu();
        coffeeShop.takeOrder("Latte", 1);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Sandwich", 1);
        coffeeShop.printReceipt();
        assertThat(coffeeShop.getTotalOrderPrice(),is(19.4) );
        // Total should be $18.1
    }

    @Test
    public void testTakeMySecondOrder(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.printMenu();
        coffeeShop.takeOrder("Latte", 2);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Sandwich", 1);
        coffeeShop.printReceipt();
        assertThat(coffeeShop.getTotalOrderPrice(),is(20.7) );
        // Total should be $15.1
    }

    @Test
    public void testTakeMyThirdOrder3(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.printMenu();
        coffeeShop.takeOrder("Latte", 1);
        coffeeShop.takeOrder("Latte", 1);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Sandwich", 1);
        coffeeShop.printReceipt();
        assertThat(coffeeShop.getTotalOrderPrice(),is(20.7) );
        // Total should be $15.1
    }

    @Test
    public void testTakeMyFourthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.printMenu();
        coffeeShop.takeOrder("Latte", 2);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Sandwich", 1);
        coffeeShop.printReceipt();
        assertThat(coffeeShop.getTotalOrderPrice(),is(24.7) );
        // Total should be $18.1
    }

    @Test
    public void testTakeMyFifthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.printMenu();
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Latte", 2);
        coffeeShop.takeOrder("Latte", 3);
        coffeeShop.takeOrder("Sandwich", 1);
        coffeeShop.printReceipt();
        assertThat(coffeeShop.getTotalOrderPrice(),is(36.6) );
        // Total should be $18.1
    }

    @Test
    public void testTakeMySixthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.printMenu();
        coffeeShop.takeOrder("Latte", 4);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Espresso", 2);
        coffeeShop.takeOrder("Sandwich", 1);
        coffeeShop.printReceipt();
        assertThat(coffeeShop.getTotalOrderPrice(),is(35.3) );
        // Total should be $18.1
    }

    @Test
    public void testTakeMySeventhOrder(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.printMenu();
        coffeeShop.takeOrder("Latte", 1);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Espresso", 2);
        coffeeShop.takeOrder("Sandwich", 5);
        coffeeShop.printReceipt();
        assertThat(coffeeShop.getTotalOrderPrice(),is(64.41) );
        // Total should be $18.1
    }

    @Test
    public void testTakeMyEighthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.printMenu();
        coffeeShop.takeOrder("Latte", 4);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Espresso", 2);
        coffeeShop.takeOrder("Sandwich", 5);
        coffeeShop.printReceipt();
        assertThat(coffeeShop.getTotalOrderPrice(),is(75.7) );
        // Total should be $18.1
    }

    @Test
    public void testTakeMyNinthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.addProductList(Arrays.asList(new Product("Capuccino", "$ 8"),
                                                new Product("Tea", "$ 6.1"),
                                                new Product("Cake Slice", "$ 9"),
                                                new Product("Milk", "$ 1")));
        coffeeShop.printMenu();
        coffeeShop.takeOrder("Latte", 4);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Espresso", 2);
        coffeeShop.takeOrder("Sandwich", 5);
        coffeeShop.takeOrder("Cake Slice", 1);
        coffeeShop.takeOrder("Capuccino", 1);
        coffeeShop.printReceipt();
        assertThat(coffeeShop.getTotalOrderPrice(),is(92.7) );
        // Total should be $18.1
    }
}
