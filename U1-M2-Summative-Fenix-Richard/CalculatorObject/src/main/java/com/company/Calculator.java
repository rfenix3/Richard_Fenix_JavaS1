package com.company;

public class Calculator {

    public static void main(String[] args) {

        // Instantiate calculator class.
        Calculator calculator = new Calculator();

        // Run the methods which also prints out the result.
        calculator.add(1, 1);
        calculator.subtract(23,52);
        calculator.multiply(34, 2);
        calculator.divide(12, 3);
        calculator.divide(12, 7);
        calculator.add(3.4, 2.3);
        calculator.multiply(6.7, 4.4);
        calculator.subtract(5.5, 0.5);
        calculator.divide(10.8, 2.2);
    }


    public int add(int int1, int int2){
        int sum = int1 + int2;
       System.out.printf("%d + %d = %d", int1, int2, sum);
        System.out.println("");
       return sum;
    }

    public double add(double double1, double double2){
        double sum = double1 + double2;
        System.out.printf("%.1f + %.1f = %.1f", double1, double2, sum);
        System.out.println("");
        return sum;
    }

    public int subtract(int minuend, int subtrahend){
        int diff = minuend - subtrahend;
        System.out.printf("%d - %d = %d", minuend, subtrahend, diff);
        System.out.println("");
        return diff;
    }

    public double subtract(double minuend, double subtrahend){
        double diff = minuend - subtrahend;
        System.out.printf("%.2f - %.2f = %.2f", minuend, subtrahend, diff);
        System.out.println("");
        return diff;
    }

    public int multiply(int int1, int int2){
        int product = int1 * int2;
        System.out.printf("%d * %d = %d", int1, int2, product);
        System.out.println("");
        return product;
    }

    public double multiply(double double1, double double2){
        double product = double1 * double2;
        System.out.printf("%.2f * %.2f = %.2f", double1, double2, product);
        System.out.println("");
        return product;
    }

    public double divide(int dividend, int divisor){
        int quotient = dividend / divisor;
        System.out.printf("%d / %d = %d", dividend, divisor, quotient);
        System.out.println("");
        return quotient;
    }

    public double divide(double dividend, double divisor){
        double quotient = dividend / divisor;
        System.out.printf("%.2f / %.2f = %.2f", dividend, divisor, quotient);
        System.out.println("");
        return quotient;
    }

}
