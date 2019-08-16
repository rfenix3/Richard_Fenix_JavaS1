package com.company;

public class Basement {

    private double size;

    // Finished or unfinished.
    private boolean finished;
    private int fullBath;
    private int halfBath;

    public Basement(double size, boolean finished, int fullBath, int halfBath) {
        this.size = size;
        this.finished = finished;
        this.fullBath = fullBath;
        this.halfBath = halfBath;
    }

    public void turnOnLights(){
        System.out.println("Turning on basement lights...");
    }

    public void turnOnWashingMachine(){
        System.out.println("Running washing machine...");
    }

    public void openVent(){
        System.out.println("Opening vents to replace stuffy air.");
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getFullBath() {
        return fullBath;
    }

    public void setFullBath(int fullBath) {
        this.fullBath = fullBath;
    }

    public int getHalfBath() {
        return halfBath;
    }

    public void setHalfBath(int halfBath) {
        this.halfBath = halfBath;
    }
}
