package com.company;

public class Radio {
    private String manufacturer;
    private String model;
    private int numSpeakers;
    private String station;
    private int volume;
    private boolean powered;

    public Radio(String manufacturer, String model, int numSpeaker, String station, int volume, boolean powered) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.numSpeakers = numSpeaker;
        this.station = station;
        this.volume = volume;
        this.powered = powered;
    }

    public void togglePower(){
        System.out.println("turning ON or OFF.");
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumSpeaker(int numSpeaker) {
        this.numSpeakers = numSpeaker;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setPowered(boolean powered) {
        this.powered = powered;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getNumSpeakers() {
        return numSpeakers;
    }

    public String getStation() {
        return station;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isPowered() {
        return powered;
    }
}
