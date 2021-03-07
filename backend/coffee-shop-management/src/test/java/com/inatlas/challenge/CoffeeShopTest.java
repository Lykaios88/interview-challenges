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
        Client client = new Client("Client1");
        coffeeShop.newClient(client);
        coffeeShop.takeOrder(client,"Latte", 1);
        coffeeShop.takeOrder(client,"Espresso", 1);
        coffeeShop.takeOrder(client,"Sandwich", 1);
        coffeeShop.printReceipt(client);
        assertThat(coffeeShop.getTotalOrderPrice(),is(19.4) );
    }

    @Test
    public void testTakeMySecondOrder(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.printMenu();
        Client client = new Client("Client1");
        coffeeShop.newClient(client);
        coffeeShop.takeOrder(client,"Latte", 2);
        coffeeShop.takeOrder(client,"Espresso", 1);
        coffeeShop.takeOrder(client,"Sandwich", 1);
        coffeeShop.printReceipt(client);
        assertThat(coffeeShop.getTotalOrderPrice(),is(20.7) );
    }

    @Test
    public void testTakeMyThirdOrder3(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.printMenu();
        Client client = new Client("Client1");
        coffeeShop.newClient(client);
        coffeeShop.takeOrder(client,"Latte", 1);
        coffeeShop.takeOrder(client,"Latte", 1);
        coffeeShop.takeOrder(client,"Espresso", 1);
        coffeeShop.takeOrder(client,"Sandwich", 1);
        coffeeShop.printReceipt(client);
        assertThat(coffeeShop.getTotalOrderPrice(),is(20.7) );
    }

    @Test
    public void testTakeMyFourthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.printMenu();
        Client client = new Client("Client1");
        coffeeShop.newClient(client);
        coffeeShop.takeOrder(client,"Latte", 2);
        coffeeShop.takeOrder(client,"Espresso", 1);
        coffeeShop.takeOrder(client,"Espresso", 1);
        coffeeShop.takeOrder(client,"Sandwich", 1);
        coffeeShop.printReceipt(client);
        assertThat(coffeeShop.getTotalOrderPrice(),is(24.7) );
    }

    @Test
    public void testTakeMyFifthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.printMenu();
        Client client = new Client("Client1");
        coffeeShop.newClient(client);
        coffeeShop.takeOrder(client,"Espresso", 1);
        coffeeShop.takeOrder(client,"Espresso", 1);
        coffeeShop.takeOrder(client,"Latte", 2);
        coffeeShop.takeOrder(client,"Latte", 3);
        coffeeShop.takeOrder(client,"Sandwich", 1);
        coffeeShop.printReceipt(client);
        assertThat(coffeeShop.getTotalOrderPrice(),is(36.6) );
    }

    @Test
    public void testTakeMySixthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.printMenu();
        Client client = new Client("Client1");
        coffeeShop.newClient(client);
        coffeeShop.takeOrder(client,"Latte", 4);
        coffeeShop.takeOrder(client,"Espresso", 1);
        coffeeShop.takeOrder(client,"Espresso", 2);
        coffeeShop.takeOrder(client,"Sandwich", 1);
        coffeeShop.printReceipt(client);
        assertThat(coffeeShop.getTotalOrderPrice(),is(35.3) );
    }

    @Test
    public void testTakeMySeventhOrder(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.printMenu();
        Client client = new Client("Client1");
        coffeeShop.newClient(client);
        coffeeShop.takeOrder(client,"Latte", 1);
        coffeeShop.takeOrder(client,"Espresso", 1);
        coffeeShop.takeOrder(client,"Espresso", 2);
        coffeeShop.takeOrder(client,"Sandwich", 5);
        coffeeShop.printReceipt(client);
        assertThat(coffeeShop.getTotalOrderPrice(),is(64.41) );
    }

    @Test
    public void testTakeMyEighthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.printMenu();
        Client client = new Client("Client1");
        coffeeShop.newClient(client);
        coffeeShop.takeOrder(client,"Latte", 4);
        coffeeShop.takeOrder(client,"Espresso", 1);
        coffeeShop.takeOrder(client,"Espresso", 2);
        coffeeShop.takeOrder(client,"Sandwich", 1);
        coffeeShop.printReceipt(client);
        assertThat(coffeeShop.getTotalOrderPrice(),is(35.3) );
    }

    @Test
    public void testTakeMyNinthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.addProductList(Arrays.asList(new Product("Capuccino", "$ 8"),
                                                new Product("Tea", "$ 6.1"),
                                                new Product("Cake Slice", "$ 9"),
                                                new Product("Milk", "$ 1")));
        coffeeShop.printMenu();
        Client client = new Client("Client1");
        coffeeShop.newClient(client);
        coffeeShop.takeOrder(client,"Latte", 4);
        coffeeShop.takeOrder(client,"Espresso", 1);
        coffeeShop.takeOrder(client,"Espresso", 2);
        coffeeShop.takeOrder(client,"Sandwich", 5);
        coffeeShop.takeOrder(client,"Cake Slice", 1);
        coffeeShop.takeOrder(client,"Capuccino", 1);
        coffeeShop.printReceipt(client);
        assertThat(coffeeShop.getTotalOrderPrice(),is(91.5) );
    }

    @Test
    public void testTakeMyTenthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.addProductList(Arrays.asList(new Product("Capuccino", "$ 8"),
                new Product("Tea", "$ 6.1"),
                new Product("Cake Slice", "$ 9"),
                new Product("Milk", "$ 1")));
        coffeeShop.printMenu();
        Client client = new Client("Client1");
        coffeeShop.newClient(client);
        coffeeShop.takeOrder(client,"Latte", 4);
        coffeeShop.takeOrder(client,"Sandwich", 5);
        coffeeShop.takeOrder(client,"Cake Slice", 1);
        coffeeShop.takeOrder(client,"Capuccino", 1);
        coffeeShop.printReceipt(client);
        assertThat(coffeeShop.getTotalOrderPrice(),is(79.5) );
    }


    @Test
    public void testTakeMyEleventhOrder(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.printMenu();
        Client client = new Client("Client1");
        coffeeShop.newClient(client);
        coffeeShop.takeOrder(client, "Latte", 4);
        coffeeShop.takeOrder(client, "Sandwich", 5);
        coffeeShop.takeOrder(client, "Sandwich", 1);
        coffeeShop.takeOrder(client, "Latte", 1);
        coffeeShop.printReceipt(client);
        assertThat(coffeeShop.getTotalOrderPrice(),is(75.6) );
    }

    @Test
    public void testTakeMyTwelfthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.addProductList(Arrays.asList(new Product("Capuccino", "$ 8"),
                new Product("Tea", "$ 6.1"),
                new Product("Cake Slice", "$ 9"),
                new Product("Milk", "$ 1")));

        coffeeShop.printMenu();
        Client client = new Client("Client1");
        coffeeShop.newClient(client);
        coffeeShop.takeOrder(client, "Latte", 4);
        coffeeShop.takeOrder(client, "Sandwich", 5);
        coffeeShop.takeOrder(client, "Sandwich", 1);
        coffeeShop.takeOrder(client, "Latte", 1);
        coffeeShop.printReceipt(client);
        assertThat(coffeeShop.getTotalOrderPrice(),is(75.6) );
        client = new Client("Client2");
        coffeeShop.newClient(client);
        coffeeShop.takeOrder(client,"Latte", 4);
        coffeeShop.takeOrder(client,"Espresso", 1);
        coffeeShop.takeOrder(client,"Espresso", 2);
        coffeeShop.takeOrder(client,"Sandwich", 5);
        coffeeShop.takeOrder(client,"Cake Slice", 1);
        coffeeShop.takeOrder(client,"Capuccino", 1);
        coffeeShop.printReceipt(client);
        assertThat(coffeeShop.getTotalOrderPrice(),is(91.5) );
        coffeeShop.pirntDailyReport();
    }
}
