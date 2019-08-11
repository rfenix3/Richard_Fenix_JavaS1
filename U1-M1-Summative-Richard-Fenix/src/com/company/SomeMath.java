package com.company;

public class SomeMath {
    public static void main(String[] args) {

        int total = SomeMath.total5(1,2,3, 4, 5);
        System.out.println(total);

        double average = SomeMath.average5(1,3,5,7,9);
        System.out.println(average);

        double largest = SomeMath.largest5(42.0, 35.1, 2.3, 40.2, 15.6);
        System.out.println(largest);

    }

    public static int total5(int a, int b, int c, int d, int e){
        return a + b + c + d + e;
    }

    public static double average5(int a, int b, int c, int d, int e) {
        return (a + b + c + d + e)/5;
    }

    public static double largest5(double a, double b, double c, double d, double e){
        double largest = a;

        if (largest < b) {
            largest = b;
        };

        if (largest < c) {
            largest = c;
        };

        if (largest < d) {
            largest = d;
        };

        if (largest < e) {
            largest = e;
        };

        return largest;
    }

}
