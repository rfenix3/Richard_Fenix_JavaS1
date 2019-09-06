package com.company.carlotjdbctemplatedao.model;

import java.util.Objects;

public class Car {
    private int id;
    private String make;
    private String model;
    private String year;
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                make.equals(car.make) &&
                model.equals(car.model) &&
                year.equals(car.year) &&
                color.equals(car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, make, model, year, color);
    }
}

