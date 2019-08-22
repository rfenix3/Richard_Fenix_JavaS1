package com.company;

public class App {

    // App used to run and test Customer classes and its composition.
    public static void main(String[] args) {

        ShippingAddress richShipping = new ShippingAddress("Georgia Tech", "5th Street", "Atlanta", "GA", "30067");
        BillingAddress richBilling = new BillingAddress("Apart 123", "25th Street", "Dunwoody", "GA", "30344");

        Customer rich = new Customer("Richard", "Fenix", "rich@yahoo.com",
                "404-123-4567", richShipping, richBilling, true);

        // Display sample output to screen.
        System.out.println(rich);

    }
}
