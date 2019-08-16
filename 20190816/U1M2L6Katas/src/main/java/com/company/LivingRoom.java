package com.company;

public class LivingRoom {
    private double size;
    private boolean hasFireplace;

    // Carpet or Hardwood
    private String flooring;

    // Gas or electric fireplace
    private String fireplaceType;


    public LivingRoom(double size, boolean hasFireplace, String flooring, String fireplaceType) {
        this.size = size;
        this.hasFireplace = hasFireplace;
        this.flooring = flooring;
        this.fireplaceType = fireplaceType;
    }

    public void turnOnLights(){
        System.out.println("Turning on basement lights...");
    };

    public void turnOnFireplace(){
        System.out.println("Turning on fireplace...");
    }


    public void cleanApplicance(){
        System.out.println("Cleaning kitchen appliances...");
    }

    public String getFireplaceType() {
        return fireplaceType;
    }

    public void setFireplaceType(String fireplaceType) {
        this.fireplaceType = fireplaceType;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isHasFireplace() {
        return hasFireplace;
    }

    public void setHasFireplace(boolean hasFireplace) {
        this.hasFireplace = hasFireplace;
    }

    public String getFlooring() {
        return flooring;
    }

    public void setFlooring(String flooring) {
        this.flooring = flooring;
    }
}
