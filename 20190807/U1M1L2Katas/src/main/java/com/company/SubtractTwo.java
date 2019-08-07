package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number to subtract: ");
        int num2 = scanner.nextInt();

        int difference = num1 - num2;

        System.out.printf("The difference of the two number is: %d", difference);

    }
}
