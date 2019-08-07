package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asks user to enter a number.
        System.out.print("Enter a number: ");

        // Saves user input to num1 variable with int data type.
        int num1 = scanner.nextInt();

        // Computes and assigns new value to newNumber variable.
        int newNumber = (num1 + 5)*2;

        /*
        Output will be in whole number with no decimal place since data type is int.
        Example, "Adding 5 to your number and then doubling it results in new value of: 200".
        */
        System.out.println("Adding 5 to your number and then doubling it results in new value of: " + newNumber);

    }
}
