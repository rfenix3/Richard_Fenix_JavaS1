package com.company;

public class CoffeeMaker {
    private String manufacturer;
    private String model;
    private int carafeSize;
    private int cupsLeft;
    private boolean powered;

    public CoffeeMaker(String manufacturer, String model, int carafeSize, int cupLeft, boolean powered) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.carafeSize = carafeSize;
        this.cupsLeft = cupLeft;
        this.powered = powered;
    }

    public void brew(){
        System.out.println("Brewing...");
    }

    public void pourCoffee(int numCups) {
        System.out.println("Pouring " + numCups + " cups now...");
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getCarafeSize() {
        return carafeSize;
    }

    public int getCupsLeft() {
        return cupsLeft;
    }

    public boolean isPowered() {
        return powered;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCarafeSize(int carafeSize) {
        this.carafeSize = carafeSize;
    }

    public void setCupsLeft(int cupLeft) {
        this.cupsLeft = cupLeft;
    }

    public void setPowered(boolean powered) {
        this.powered = powered;
    }
}
