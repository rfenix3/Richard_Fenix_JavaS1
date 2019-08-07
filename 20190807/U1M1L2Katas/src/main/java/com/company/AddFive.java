package com.company;

import java.util.Scanner;

public class AddFive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter third number: ");
        int num3 = scanner.nextInt();

        System.out.print("Enter fourth number: ");
        int num4 = scanner.nextInt();

        System.out.print("Enter fifth number: ");
        int num5 = scanner.nextInt();

        double total = (double) (num1 + num2 + num3 + num4 + num5);

        System.out.println("Total of five numbers is: " + total);

    }
}
