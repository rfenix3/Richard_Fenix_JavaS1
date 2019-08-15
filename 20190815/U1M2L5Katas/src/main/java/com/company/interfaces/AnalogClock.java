package com.company.interfaces;

public class AnalogClock implements Clock {

    @Override
    public void displayTime() {
        System.out.println("Displaying time....");;
    }

    @Override
    public void timer(int hour, int minute) {
        System.out.println("Timer method is running...");;
    }
}
