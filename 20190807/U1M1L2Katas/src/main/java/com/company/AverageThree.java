package com.company;

import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asks user to enter the first number.
        System.out.print("Enter first number: ");

        // Saves user input to num1 variable with double data type.
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter third number: ");
        double num3 = scanner.nextDouble();

        // Computes and assigns new value to average variable.
        double average = (num1 + num2 + num3)/3;

        /*
        Used printf method to format the output to have 2 decimal places.
        Example, "The average of the three numbers is: 22.50".
        */
        System.out.printf("The average of the three numbers is: %.2f", average);

    }
}
