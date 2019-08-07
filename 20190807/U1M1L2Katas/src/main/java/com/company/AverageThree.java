package com.company;

import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter third number: ");
        double num3 = scanner.nextDouble();

        double average = (double) ((num1 + num2 + num3)/3);

        System.out.printf("The average of the three numbers is: %.2f", + average);

    }
}
