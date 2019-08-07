package com.company;

import java.util.Scanner;

public class AddThirteen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asks user to enter a number.
        System.out.print("Enter number: ");

        // Saves user input to num1 variable with double data type.
        double num1 = scanner.nextDouble();

        // Computes and assigns new value to addedThirteen variable.
        double addedThirteen = (num1 + 13);

        /*
        Used printf method to format the output to have 2 decimal places.
        Example, "If you add 13, the new number is: 26.00".
        */
        System.out.printf("If you add 13, the new number is: %.2f", addedThirteen);

    }
}
