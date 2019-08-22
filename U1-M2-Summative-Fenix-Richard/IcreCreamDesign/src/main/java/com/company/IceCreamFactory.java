package com.company;

public class IceCreamFactory {

    private long customerId;
    private String customerName;

    // Composition(has-a) shows the use of instance variables that are references of other objects.
    private Address shippingAddress;
    private Address billingAddress;

    private long orderNumber;
    private int quantity;

    // Ice cream type object for customer orders etc.
    private IceCream iceCream;

    private double taxRate;
    private double totalCost;

}
