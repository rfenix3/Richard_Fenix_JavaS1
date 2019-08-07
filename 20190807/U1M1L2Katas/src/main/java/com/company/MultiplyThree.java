package com.company;

import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asks user to enter the first of three numbers.
        System.out.print("Enter first number: ");

        // Saves user entry into a num1 variable with data type of double.
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter third number: ");
        double num3 = scanner.nextDouble();

        // Computes and assigns new value to productOfThree variable.
        double productOfThree = num1 * num2 * num3;

        /*
        Used printf method to format the output to have 2 decimal places.
        Example, "The product of the three numbers is: 60.00".
        */
        System.out.printf("The product of the three numbers is: %.2f", productOfThree);

    }
}