package com.company;

public class ComputerMouse {
    private String manufacturer;
    private String model;
    private int xPosition;
    private int yPosition;
    private int[] lastClickedLocation;

    public ComputerMouse(String manufacturer, String model, int xPosition, int yPosition, int[] lastClickedLocation) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.lastClickedLocation = lastClickedLocation;
    }

    public void move(int deltaX, int deltaY){
        System.out.println("Moving to locations " + deltaX + " x and " + deltaY + " y.");
    }

    public void click(){
        System.out.println("I am clicked.");
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setLastClickedLocation(int[] lastClickedLocation) {
        this.lastClickedLocation = lastClickedLocation;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int[] getLastClickedLocation() {
        return lastClickedLocation;
    }
}
