package com.company;

public class Microwave {
    private String manufacturer;
    private String model;
    private int secondsLeft;
    private String time;
    private boolean running;

    public Microwave(String manufacturer, String model, int secondsLeft, String time, boolean running) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.secondsLeft = secondsLeft;
        this.time = time;
        this.running = running;
    }

    public void start(int secondsLeft){
        System.out.println("Staring the microwave!!!");
    }

    public void stop(){
        System.out.println("Microwave stopped!");
    }

    public void clear(){
        System.out.println("Clearing programming...");
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSecondsLeft(int secondsLeft) {
        this.secondsLeft = secondsLeft;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }

    public String getTime() {
        return time;
    }

    public boolean isRunning() {
        return running;
    }
}
