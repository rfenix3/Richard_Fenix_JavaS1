package com.company;

public class IceCream {

    private String itemNumber;
    private String flavor;
    private String description;
    // volume = Gallons, Pints, Quarts, Ounces, liters
    private String volume;
    // volume amount = 5, 3.75
    private double volumeAmount;
    private double unitPrice;

    public IceCream(String itemNumber, String flavor, String description,
                    String volume, double volumeAmount, double unitPrice) {
        this.itemNumber = itemNumber;
        this.flavor = flavor;
        this.description = description;
        this.volume = volume;
        this.volumeAmount = volumeAmount;
        this.unitPrice = unitPrice;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public double getVolumeAmount() {
        return volumeAmount;
    }

    public void setVolumeAmount(double volumeAmount) {
        this.volumeAmount = volumeAmount;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "itemNumber='" + itemNumber + '\'' +
                ", flavor='" + flavor + '\'' +
                ", description='" + description + '\'' +
                ", volume='" + volume + '\'' +
                ", volumeAmount=" + volumeAmount +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
