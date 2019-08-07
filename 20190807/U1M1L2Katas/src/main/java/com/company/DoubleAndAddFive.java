package com.company;

import java.util.Scanner;

public class DoubleAndAddFive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asks user to enter a number.
        System.out.print("Enter a number: ");

        // Saves user input to num1 variable with double data type.
        double num1 = scanner.nextDouble();

        // Computes and assigns new value to doubleAndAddFive variable.
        double doubleAndAddFive = (num1 * 2) + 5;

        /*
        Used printf method to format the output to have 2 decimal places.
        Example, "The average of the three numbers is: 22.50".
        */
        System.out.printf("If you double your number and add 5, your new number is: %.2f", doubleAndAddFive);

    }
}
