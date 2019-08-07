package com.company;

import java.util.Scanner;

public class AddThirteen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        double num1 = scanner.nextDouble();

        double addedThirteen = (double) (num1 + 13);

        System.out.printf("The average of the three numbers is: %.2f", + addedThirteen);

    }
}
