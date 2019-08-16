package com.company;

public class Kitchen {
    private double size;
    private boolean hasCounter;
    private boolean hasMicrowave;
    private boolean renovated;

    // Can have 1 or 2 diswashers.
    private int dishwasher;

    public Kitchen(double size, boolean hasCounter, boolean hasMicrowave, boolean renovated, int dishwasher) {
        this.size = size;
        this.hasCounter = hasCounter;
        this.hasMicrowave = hasMicrowave;
        this.renovated = renovated;
        this.dishwasher = dishwasher;
    }

    public void turnOnLights(){
        System.out.println("Turning on basement lights...");
    };

    public void turnOnDiswasher(){
        System.out.println("Turning on Dishwasher...");
    }

    public void setOvenTimer(int minutes){
        System.out.println("Setting oven timer to " + minutes +;
         " minutes");
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isHasCounter() {
        return hasCounter;
    }

    public void setHasCounter(boolean hasCounter) {
        this.hasCounter = hasCounter;
    }

    public boolean isHasMicrowave() {
        return hasMicrowave;
    }

    public void setHasMicrowave(boolean hasMicrowave) {
        this.hasMicrowave = hasMicrowave;
    }

    public boolean isRenovated() {
        return renovated;
    }

    public void setRenovated(boolean renovated) {
        this.renovated = renovated;
    }

    public int getDishwasher() {
        return dishwasher;
    }

    public void setDishwasher(int dishwasher) {
        this.dishwasher = dishwasher;
    }
}
