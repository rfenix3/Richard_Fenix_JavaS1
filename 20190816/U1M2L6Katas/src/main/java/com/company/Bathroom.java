package com.company;

public class Bathroom {
    // 30 (sqr feet)
    private double size;

    // master bedroom, first floor, 2nd floor
    private String location;

    // type values are... half bath or full bath
    private String type;

    // yes, no
    private boolean bathtub;

    public Bathroom(double size, String location, String type, boolean bathtub) {
        this.size = size;
        this.location = location;
        this.type = type;
        this.bathtub = bathtub;
    }

    public void turnOnLights(){
        System.out.println("Turning on basement lights...");
    };

    public void turnOnShower(){
        System.out.println("Turning on shower...");
    }

    public void flush() {
        System.out.println("Flushing toilet...");
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBathtub() {
        return bathtub;
    }

    public void setBathtub(boolean bathtub) {
        this.bathtub = bathtub;
    }
}
