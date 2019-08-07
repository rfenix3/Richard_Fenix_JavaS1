package com.company;

import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter third number: ");
        double num3 = scanner.nextDouble();

        double productOfThree = (double) (num1 * num2 * num3);

        System.out.printf("The product of the three numbers is: %.2f", + productOfThree);

    }
}