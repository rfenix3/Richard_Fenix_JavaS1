package com.company;

import java.util.ArrayList;

public class Car {
    private String make;
    private String model;
    private String year;
    private String color;
    private int odometer;

    private int id = assignId();

    private static int nextId = 1;
    private static ArrayList<Car> carList = new ArrayList<>();


    public Car(String make, String model, String year, String color, int odometer) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.odometer = odometer;
        carList.add(this);
    }

    public Car(){

    }

    private static int assignId(){
        int r = nextId;
        nextId++;
        return r;
    }

    public static ArrayList<Car> getCarList() {
        return carList;
    }

    public static void setCarList(ArrayList<Car> carList) {
        Car.carList = carList;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", color='" + color + '\'' +
                ", odometer=" + odometer +
                '}';
    }
}
