package com.company.interfaces;

public class Buzzer implements Alarm{
    @Override
    public void sound() {
        System.out.println("Sounding alarm!!!");
    }
}
