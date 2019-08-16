package com.company.concreteapproach;


public class Shape {
    private String name;
    private String color;
    private int x;
    private int y;

    public Shape(String name, String color, int x, int y) {
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public double area(){};

    public double perimeter(){};
}
