package com.company;

public class IceCreamPOS {

    private int orderNumber;

    // categories = Ice Cream, Cookies, Sundaes, Premium Sundaes, Frozen Beverages
    private String category;
    // orderTypes = Single Scoop, Double Scoop, Kid's Single Scoop, Banana Royale, Brownie Sundae
    private String orderType;

    private boolean pickup;
    private boolean delivery;

    // Ice cream type object for customer orders etc.
    private IceCream iceCream;

    private double unitCost;
    private double taxRate;

}
