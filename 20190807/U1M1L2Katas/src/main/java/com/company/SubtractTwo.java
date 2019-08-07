package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asks user to enter minuend.
        System.out.print("Enter first number: ");

        // Saves user input to num1 variable with int (integer) data type.
        int num1 = scanner.nextInt();

        // Asks user to enter subtrahend.
        System.out.print("Enter second number to subtract: ");

        // Saves user input to num2 variable with int (integer) data type.
        int num2 = scanner.nextInt();


        // Compare the two values and add a statement whether the result will be POSITIVE OR NEGATIVE.
        if (num1 > num2) {
            // if num1 is greater than num2, state that the difference will be a POSITIVE number.
            System.out.println("The difference is a POSITIVE.\n");
        } else if (num1 < num2) {
            // if num1 is less than num2, state that the difference will be a NEGATIVE number.
            System.out.println("The difference is a NEGATIVE.\n");
        } else {
            // If conditions above are not met, it means num1 and num2 are equal.
            System.out.println("There difference is ZERO.\n");
        }

        // Compute and assign the difference to difference variable.
        int difference = num1 - num2;

        // Sample output, "The difference of the two number is: 4".
        System.out.print("The difference between the two number is: " + difference);

    }
}
