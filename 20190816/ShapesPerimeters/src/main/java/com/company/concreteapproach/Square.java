package com.company.concreteapproach;

public class Square extends Shape{

    private double side;

    public Square(String name, String color, int x, int y, double side) {
        super(name, color, x, y);
        this.side = side;
    }

    public double area() {
        return side * side;
    }

    public double perimeter() {
        return 4 * side;
    }

    public double getSide() {
        return side;
    }


}
