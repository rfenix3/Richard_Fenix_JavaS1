package com.company.concreteapproach;

public class Circle extends Shape {

    private double radius;

    public Circle(String name, String color, int x, int y, double radius) {
        super(name, color, x, y);
        this.radius = radius;
    }

    public double area() {
        return radius * radius * Math.PI;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }
}
