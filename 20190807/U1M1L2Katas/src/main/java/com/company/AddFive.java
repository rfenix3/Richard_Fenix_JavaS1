package com.company;

import java.util.Scanner;

public class AddFive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asks user to enter first number.
        System.out.print("Enter first number: ");

        // Saves user input to num1 variable with int data type.
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter third number: ");
        int num3 = scanner.nextInt();

        System.out.print("Enter fourth number: ");
        int num4 = scanner.nextInt();

        System.out.print("Enter fifth number: ");
        int num5 = scanner.nextInt();

        // Computes and assigns new value to total variable.
        int total = (num1 + num2 + num3 + num4 + num5);

        /*
        Output will be in whole number with no decimal place since data type is int.
        Example, "Total of five numbers is: 136".
        */
        System.out.println("Total of five numbers is: " + total);

    }
}
