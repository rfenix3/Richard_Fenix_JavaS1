package com.company.interfaces;

public class DigitalClock implements Clock, Alarm{
    @Override
    public void displayTime() {
        System.out.println("Displaying Digital Clock TIME!");
    }

    @Override
    public void timer(int hour, int minute) {
        System.out.println("Displaying Digital Clock TIMER!");
    }

    @Override
    public void sound() {
        System.out.println("Sounding Digital Clock sound... RRRIIIINNNNG!!!");
    }
}
