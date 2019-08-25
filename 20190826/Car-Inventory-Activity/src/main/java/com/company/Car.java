package com.company;

import com.opencsv.bean.CsvBindByName;

import java.util.ArrayList;
import java.util.List;

public class Car {
    @CsvBindByName(column = "Make")
    private String make;
    @CsvBindByName(column = "Model")
    private String model;
    @CsvBindByName(column = "Year")
    private String year;
    @CsvBindByName(column = "Color")
    private String color;
    @CsvBindByName(column = "Odometer")
    private int odometer;

    private int id = assignId();

    private static int nextId = 1;
    private static List<Car> carList = new ArrayList<>();


    public Car(String make, String model, String year, String color, int odometer) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.odometer = odometer;
//        this.id = assignId();
        carList.add(this);
    }

    public Car(){

    }

    private static int assignId(){
        int r = nextId;
        nextId++;
        return r;
    }

    public static List<Car> getCarList() {
        return carList;
    }

    public static void setCarList(List<Car> carList) {
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
                "id='" + id + '\'' +
                " make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", color='" + color + '\'' +
                ", odometer=" + odometer +
                '}';
    }
}
