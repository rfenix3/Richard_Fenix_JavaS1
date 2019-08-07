package com.company;

import java.util.Scanner;

public class DoubleAndAddFive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        double num1 = scanner.nextDouble();

        double doubleAndAddFive = (double) ((num1 * 2) + 5);

        System.out.printf("The number now is: %.2f", + doubleAndAddFive);

    }
}
